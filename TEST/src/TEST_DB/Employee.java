package TEST_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
 
public class Employee 
{
    public static Connection dbConn;
      
    	public static void main(String []args) {
    		
    		Scanner sc = new Scanner(System.in);
    		System.out.print("메뉴 ?");
    		EmployeeMgmt mgmt = new EmployeeMgmt(); 
    		
    		while(true)
    		{    
    			System.out.print("1(전체조회) 2(간단조회) 3(삽입) 4(수정) 5(전체조회)");
    			int menu=sc.nextInt();
    			
    			switch(menu) 
    			{
    				case 1:
    					mgmt.empListProc();
    					break;
    				case 2:
    					mgmt.empDTOProc();
    					break;
    				case 3:
    					mgmt.insertEmpProc();
    					break;
    				case 4:
    					mgmt.updateEmpProc();
    					break;
    				case 5:
    					mgmt.empListmap();
    					break;
    				case 6:
    					System.out.println("시스템을 종료합니다.");
    					System.exit(0);
    			}
    				
    		}
    	}
}

