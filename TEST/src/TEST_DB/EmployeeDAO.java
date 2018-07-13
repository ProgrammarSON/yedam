package TEST_DB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class EmployeeDAO {
	Connection conn = null;
	
	private void connect() {
		try {
            String user = "hr"; 
            String pw = "hr";
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            
            Class.forName("oracle.jdbc.driver.OracleDriver");        
            conn = DriverManager.getConnection(url, user, pw);
            
            System.out.println("Database에 연결되었습니다.\n");
            
        } catch (ClassNotFoundException cnfe) {
            System.out.println("DB 드라이버 로딩 실패 :"+cnfe.toString());
        } catch (SQLException sqle) {
            System.out.println("DB 접속실패 : "+sqle.toString());
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
	
	public EmployeeDTO getEmpDTO(String emp_id) {
		connect();
		EmployeeDTO dto = null;
                
        String sql = "SELECT employee_id, first_name, last_name, email FROM employees "
        		+ "WHERE employee_id = ?";
                
        try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp_id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) 
			{
				dto = new EmployeeDTO();
				dto.setEmployeeId(rs.getString("employee_id"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
	}
	
	public void insertEmp(EmployeeDTO dto) {
		connect();
		String sql = "INSERT INTO employees(employee_id, first_name, last_name,email,hire_date, job_id)\r" + 
				"VALUES (?,?,?,?,sysdate,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dto.getEmployeeId());
			pstmt.setString(2,dto.getFirstName());
			pstmt.setString(3,dto.getLastName());
			pstmt.setString(4,dto.getEmail());
			pstmt.setString(5, dto.getJobId());
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "건이 입력되었습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public void updateEmp(EmployeeDTO dto) {
		connect();
		String sql = "UPDATE employees SET email = ? WHERE employee_id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dto.getEmail());
			pstmt.setString(2, dto.getEmployeeId());
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "건이 업데이트되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<EmployeeDTO> getEmpList(SearchVO vo) {
		connect();
        EmployeeDTO dto = null;
        List<EmployeeDTO> list =new ArrayList<>();
        String whereClause = "where 1=1";
        
        if(vo.getSearchCondition().equals("first_name"))
        	whereClause += " and first_name like '%" + vo.getSearchKeyword() + "%'";
        
        if(vo.getSearchCondition().equals("hire_date"))
        	whereClause += " and hire_date >= '" +vo.getSearchKeyword() + "'"; 
               
        String sql = "SELECT employee_id, first_name, last_name, email, job_id, hire_date FROM employees "
        		+ whereClause + " order by 1 desc";
         
       // System.out.println(sql);
        try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		
			while(rs.next()) 
			{
				dto = new EmployeeDTO();
				dto.setEmployeeId(rs.getString("employee_id"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				dto.setJobId(rs.getString("job_id"));
				dto.setHireDate(rs.getString("hire_date"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	public List<Map<String,Object>> getEmpListMap() {
		connect();
		String sql = "select employee_id, first_name FROM employees";
		Map<String, Object> map = null;
		List<Map<String,Object>> list = new ArrayList<>();
		
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				map = new HashMap<>();
				map.put("employee_id", rs.getString("employee_id"));
				map.put("first_name",rs.getString("first_name"));
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}		
		return list;
	}
	
	/*
	public void getEmpListCursor() {
		connect();
		try {
			CallableStatement cstmt = conn.prepareCall("{call get_emplist_proc(?,?,?)}");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date d = new Date();
			
			cstmt.setInt(1,500);
			cstmt.setDate(2,d);
			
			cstmt.registerOutParameter(3,oracle.jdbc.Ora);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
	}*/
}
