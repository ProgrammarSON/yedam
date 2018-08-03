package com.image;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Image_DAO {
	private Connection conn = null;
	
	private void connect() {
		try {
            String user = "erp"; 
            String pw = "erp";
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            
            Class.forName("oracle.jdbc.driver.OracleDriver");        
            conn = DriverManager.getConnection(url, user, pw);
            
            System.out.println("Database�� ����Ǿ����ϴ�.\n");
            
        } catch (ClassNotFoundException cnfe) {
            System.out.println("DB ����̹� �ε� ���� :"+cnfe.toString());
        } catch (SQLException sqle) {
            System.out.println("DB ���ӽ��� : "+sqle.toString());
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
	
	
}
