package com.board;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class boardDAO {
	
	public static final int MEMBER_NONEXISTENT  = 0;
	public static final int MEMBER_EXISTENT = 1;
	public static final int MEMBER_JOIN_FAIL = 0;
	public static final int MEMBER_JOIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_PW_NO_GOOD = 0;
	public static final int MEMBER_LOGIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_IS_NOT = -1;
	
	private static boardDAO instance = new boardDAO();
	
	public static boardDAO getInstance(){
		return instance;
	}
	
	public int insertBoard(boardDTO dto) {
		int ri = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO board VALUES (bnum_seq.nextval,?,?,?,0,?)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			//pstmt.setString(1, dto.getBnum());
			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getWriter());
			pstmt.setTimestamp(3, dto.getBdate());
			pstmt.setString(4, dto.getContent());
			pstmt.executeUpdate();
			ri = boardDAO.MEMBER_JOIN_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return ri;
	}
	
	public List<boardDTO>getBoard(){
		List<boardDTO> list= new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boardDTO dto = null;
		String sql = "SELECT * FROM board";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new boardDTO();
				dto.setBnum(rs.getString("bnum"));
				dto.setSubject(rs.getString("subject"));
				dto.setWriter(rs.getString("writer"));
				dto.setBdate(rs.getTimestamp("bdate"));
				dto.setHits(rs.getString("hits"));
				list.add(dto);
			}
			sql = "SELECT count(*) AS pagecnt FROM board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				dto = new boardDTO();
				dto.setPagecnt(rs.getInt("pagecnt"));
				list.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(rs != null) rs.close();
					if(conn != null)conn.close();
					if(pstmt != null)pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return list;
	}
	
	
	
	private Connection getConnection() {
		
		Context context = null;
		DataSource dataSource = null;
		Connection connection = null;
		
		try {
			context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			connection = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
