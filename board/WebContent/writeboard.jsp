<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="JavaScript" src="members.js" ></script>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" 
crossorigin="anonymous">

<style>
.layer{
  position:absolute;
  top:50%;
  left:50%;
  transform:translate(-50%, -50%)
}
</style>

</head>
<body>
	<div class="center-block layer">
	<form action="writeOK.jsp" name="bw">
	  <div class="form-group">
    	<label for="exampleInputEmail1">Subject</label>
    	<input type="text" class="form-control" id="exampleInputEmail1" name="subject">
      </div>
      
       <div class="form-group">
    	<label for="exampleInputEmail1">Writer</label>
    	<input type="text" class="form-control" id="exampleInputEmail1" name="writer">
      </div>
	
	
	<div class="form-group">
    	<label for="exampleFormControlTextarea1">Contents</label>
    	<textarea class="form-control" id="exampleFormControlTextarea1" rows="10" cols="100" name="content"></textarea>
  	</div>
  
  	<input type="submit" class="btn" value="작성">
	<input type="reset" class="btn" value="초기화">
	</form>
	</div>
</body>
</html>