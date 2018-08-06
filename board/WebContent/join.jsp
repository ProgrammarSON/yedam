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
	.btn{
  background:#1AAB8A;
  color:#fff;
  border:none;
  position:relative;
  height:60px;
  font-size:1.6em;
  padding:0 2em;
  cursor:pointer;
  transition:800ms ease all;
  outline:none;
}
.btn:hover{
  background:#fff;
  color:#1AAB8A;
}
.btn:before,button:after{
  content:'';
  position:absolute;
  top:0;
  right:0;
  height:2px;
  width:0;
  background: #1AAB8A;
  transition:400ms ease all;
}
.btn:after{
  right:inherit;
  top:inherit;
  left:0;
  bottom:0;
}
.btn:hover:before,btn:hover:after{
  width:100%;
  transition:800ms ease all;
}

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
	<form action="joinOK.jsp" method="post" name="reg_frm">
	<table class="table table-bordered">
		<tr>
			<td class="table-success"><h4 class="font-weight-bold">아이디</h4></td>
			<td class="table-primary" colspan="3"><input type="text" name="id" size="20"></td>
		</tr>
		<tr>
			<td class="table-success"><h4 class="font-weight-bold">비밀번호</h4></td> <td class="table-primary"><input type="password" name="pw" size="20"></td>
			<td class="table-success"><h4 class="font-weight-bold">비밀번호 확인</h4></td> <td class="table-primary"><input type="password" name="pw_check" size="20"></td>
		</tr>
		<tr>
			<td class="table-success"><h4 class="font-weight-bold">이름</h4></td> <td class="table-primary" colspan="3"><input type="text" name="name" size="20"></td>
		</tr>
		<tr>
			<td class="table-success"><h4 class="font-weight-bold">메일</h4></td> <td class="table-primary" colspan="3"><input type="text" name="eMail" size="20"></td>
		</tr>
		<tr>
			<td class="table-success"><h4 class="font-weight-bold">주소</h4></td> <td class="table-primary" colspan="3"><input type="text" name="address" size="50"></td>
		</tr>
	</table>
		<input type="button"  class="btn" value="회원가입" onclick="infoConfirm()">
		<input type="reset" class="btn" value="취소" onclick="javascript:window.location='login.jsp'">
	</form>
	</div>
	
	<div class="layer">
		
	</div>
</body>
</html>