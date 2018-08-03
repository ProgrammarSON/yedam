package com.image;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class show_image
 */
@WebServlet("/show_image")
public class show_image extends HttpServlet {
	private  Connection conn = null;
	
	private void connect() {
		try {
            String user = "hr"; 
            String pw = "hr";
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            
            Class.forName("oracle.jdbc.driver.OracleDriver");        
            conn = DriverManager.getConnection(url, user, pw);
            
            System.out.println("Connect DataBase\n");
            
        } catch (ClassNotFoundException cnfe) {
            System.out.println("failed DB drive loading :"+cnfe.toString());
        } catch (SQLException sqle) {
            System.out.println("failed DB connect: "+sqle.toString());
        } catch (Exception e) {
            System.out.println("Unkonwn error");
            e.printStackTrace();
        }
	}
	
	private void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void get_image() {
		connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		byte[] imgdata = null;
		Blob image = null;
		
		String sql = "SELECT image FROM emp_img";
		
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				image = rs.getBlob(1);
				imgdata = image.getBytes(1, (int)image.length());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
