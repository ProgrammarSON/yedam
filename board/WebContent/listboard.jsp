<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.board.*" %>
<%@ page import="java.util.*" %>
<% response.setCharacterEncoding("UTF-8"); %>
<%! 
	boardDAO dao = boardDAO.getInstance(); 
	List<boardDTO> list = dao.getBoard();
%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<table border="1">
			<tr>
				<th>번호</th> <th>제목</th> <th>작성자</th> <th>조회</th>
			</tr>
			<%
				for(boardDTO d : list) {
			%>
			<tr>
				<td> <%=d.getBnum() %> </td> <td><%=d.getSubject() %></td> <td><%=d.getWriter() %></td> 
				<td><%=d.getBdate() %></td> <td><%=d.getHits() %></td>
			</tr>
			<%} %>					
		</table>
	</div>
</body>
</html>