import java.sql.*;
import java.util.*;

public class ERP_DAO {
		private Connection conn = null;
		
		private void connect() {
			try {
	            String user = "erp"; 
	            String pw = "erp";
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
		
		public List<ERP_DTO> getSandR() {
			connect();
			ERP_DTO dto = null;
			List<ERP_DTO> list = new ArrayList<>();
			String sql = "SELECT sar_id, product_id,TO_CHAR(sar_date, 'yyyy-mm-dd hh24:mm:ss') AS sar_date"
					+ " FROM STORE_AND_RELEASE";
			
			PreparedStatement pstmt;
			try {
				pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) 
				{
					dto = new ERP_DTO();
					dto.setIndex(rs.getString("sar_id"));
					dto.setProduct_id(rs.getString("product_id"));
					dto.setSar_date("sar_date");
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
		
		
}
