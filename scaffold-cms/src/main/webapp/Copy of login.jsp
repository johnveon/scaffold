<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="/script/script.jsp"></jsp:include>

<script type="text/javascript" src="login.js"></script>


<title>登录</title>
</head>
<body>
<form id="loginForm" method="post"  action="userAction!login.action">
用户名:<input type="text" id="userCode" name="userVO.userCode"  />
账     号:<input type="password" id="userPwd" name="userVO.userPwd"  />
<input type="button" value="登录" onclick="login()"/>  

</form>
</body>
</html>