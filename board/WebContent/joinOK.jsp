<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="com.member.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dto" class="com.member.DTO"/>
<jsp:setProperty name="dto" property="*" />
<%
	dto.setrDate(new Timestamp(System.currentTimeMillis()));
	DAO dao = DAO.getInstance();
	if(dao.confirmId(dto.getId()) == dao.MEMBER_EXISTENT) {
%>
	<script>
		alert("exist id");
		history.back();
	</script>
<% 
	} else {
		int ri = dao.insertMember(dto);
		if(ri == dao.MEMBER_JOIN_SUCCESS){
			session.setAttribute("id",dto.getId());	
	
%>
	<script>
		alert("Welcome the join");
		document.location.href="login.jsp";
	</script>
<%
		} else{
%>
	<script>
		alert("failed the join");
		document.location.href="login.jsp";
	</script>
<%				
		}
	}
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
