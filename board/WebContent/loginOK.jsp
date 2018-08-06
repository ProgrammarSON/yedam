<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.member.DTO" %>
<%@ page import="com.member.DAO" %>

<%
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	DAO dao = DAO.getInstance();
	int checkNum = dao.userCheck(id, pw);
	if(checkNum == -1){
%>
	<script>
		alert("Not exist id");
		history.go(-1);
	</script>
<%
	} else if (checkNum == 0){
%>
	<script>
		alert("failed password");
		history.go(-1);
	</script>
<%
	} else if(checkNum == 1){
		DTO dto = dao.getMember(id);
		
		if(dto == null) {
%>
	<script>
		alert("Not exist member");
		history.go(-1);
	</script>
<%
		} else {
			String name = dto.getName();
			session.setAttribute("id",id);
			session.setAttribute("name",name);
			session.setAttribute("ValidMem","yes");
			response.sendRedirect("main.jsp");
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