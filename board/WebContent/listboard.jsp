<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.board.*" %>
<%@ page import="java.util.*" %>
<% response.setCharacterEncoding("UTF-8"); %>
<% 
   int totalpage, i, pages;
   int startpage,endpage;
   String value = request.getParameter("value");
   if(value == null) pages = 1;
   else pages = Integer.parseInt(value); 
   
   boardDAO dao = boardDAO.getInstance(); 
   List<boardDTO> list = dao.getBoard(pages*10);
   
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
         	System.out.println(list.get(i).getRownum());
         %>
         
         <tr>
            <td><%=list.get(i).getBnum() %> </td> 
            <td><a href="contentboard.jsp?rownum=<%=list.get(i).getRownum() %> "><%=list.get(i).getSubject() %></a></td> 
            <td><%=list.get(i).getWriter() %></td> 
            <td><%=list.get(i).getBdate() %></td>  <td><%=list.get(i).getHits() %></td>
         </tr>
         </a>
            <%}%>
      </table>
         <%
            totalpage=list.get(i).getPagecnt();
        	System.out.println(totalpage); 	
         	if(totalpage % 10 != 0) totalpage = totalpage / 10 + 1;
         	else totalpage = totalpage / 10;
          	
          	startpage = ((pages-1)/10) *10 +1;
         	endpage = (startpage) + 9;
         	if(endpage > totalpage) endpage = totalpage;
         	
         	
         	if(startpage == 1){
         %>
         	<button type="button" class="btn btn-primary" onclick="location='listboard.jsp?value=<%=1%>'"> ◁ </button>
         	<%} else {%>
         	<button type="button" class="btn btn-primary" onclick="location='listboard.jsp?value=<%=startpage-1%>'"> ◁ </button>
         	<%} %>
         <%
         	for(i=startpage; i<=endpage; i++){
         %>
              <button type="button" class="btn btn-primary" onclick="location='listboard.jsp?value=<%=i%>'"><%=i%></button>   
   			<%}%>
   		
   		<%
   			if(endpage != totalpage) endpage++;
         %>
            	<button type="button" class="btn btn-primary" onclick="location='listboard.jsp?value=<%=endpage%>'"> ▷ </button>
   </div>
</body>
</html>