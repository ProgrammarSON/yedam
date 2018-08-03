<%@ page language="java" contentType="image/gif; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>

<%
Blob image = null;
Connection conn = null;
byte[] imgdata = null ;
PreparedStatement stmt = null;
ResultSet rs = null;

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

out.clear();
out=pageContext.pushBody();

String sql = "SELECT image FROM emp_img";

try {
	stmt = conn.prepareStatement(sql);
	rs = stmt.executeQuery();
	
	if(rs.next()) {
		image = rs.getBlob(1);
		imgdata = image.getBytes(1, (int)image.length());
	} 
	else {
		out.println("Display Blob Example");
		out.println("image not found for given id>");
		return;
	}
	
	//response.setContentType("image/gif");
	OutputStream o = response.getOutputStream();
	o.write(imgdata);
	o.flush();
	o.close();

} catch (Exception e) {
	out.println("Unable To Display image");
	out.println("Image Display Error=" + e.getMessage());
	return;
	} finally {
		try {
		rs.close();
		stmt.close();
		conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
%>

    
