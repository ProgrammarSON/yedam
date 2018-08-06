<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ page import="java.sql.Timestamp" %>
<%@ page import="com.board.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dto" class="com.board.boardDTO"/>
<jsp:setProperty name="dto" property="*" />

<%!
	boardDAO dao = boardDAO.getInstance();
%>
<%
	dto.setBdate(new Timestamp(System.currentTimeMillis()));
	int x = dao.insertBoard(dto);
	out.print(x+" success");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>