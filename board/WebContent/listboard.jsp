<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.board.*" %>
<%@ page import="java.util.*" %>
<% response.setCharacterEncoding("UTF-8"); %>
<%! 
	boardDAO dao = boardDAO.getInstance(); 
	List<boardDTO> list = dao.getBoard();
	int pagesize,i;
%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" 
crossorigin="anonymous">
</head>
<body>
	<div>
		<table border="1">
			<tr>
				<th>번호</th> <th>제목</th> <th>작성자</th><th>날짜</th><th>조회</th>
			</tr>
			<%
				for(i=0; i<list.size()-1; i++) {
			%>
			<tr>
				<td><%=list.get(i).getBnum() %> </td> <td><%=list.get(i).getSubject() %></td> <td><%=list.get(i).getWriter() %></td> 
				<td><%=list.get(i).getBdate() %></td>  <td><%=list.get(i).getHits() %></td>
			</tr>
				<%}%>
		</table>
			<%
				pagesize=list.get(i).getPagecnt();
				if(pagesize%10 != 0)
					for(i=0;i<pagesize/10+1;i++){
			%>
					<button type="button" class="btn btn-primary"><%=i+1%></button>	
			<%}%>		
				
		
	</div>
</body>
</html>