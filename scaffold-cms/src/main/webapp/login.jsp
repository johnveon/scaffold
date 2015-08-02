<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
    <jsp:include page="/script/script.jsp"></jsp:include>

</head>
<body style="position: relative;">
<div style="position: absolute;left: 387px;">
    <p>填写登录信息并添提交</p>
    <div style="margin:20px 0;"></div>
    <div class="easyui-panel" title="登录" style="width:400px">
        <div style="padding:10px 60px 20px 60px">
        <form id="loginForm" method="post"  action="userAction!login.action">
            <table cellpadding="5">
                <tr>
                    <td>用户名:</td>
                    <td><input class="easyui-textbox" type="text" name="userVO.userCode" value="admin" data-options="required:true"></input></td>
                </tr>
                <tr>
                    <td>密码:</td>
                    <td><input class="easyui-textbox" type="password" name="userVO.userPwd" value="123456" data-options="required:true"></input></td>
                </tr>
            </table>
        </form>
        <div style="text-align:center;padding:5px">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">清空</a>
        </div>
        </div>
    </div>
</div>
    <script>
        function submitForm(){
            $('#loginForm').form('submit',
            		{
		            	success:function(data){
		            		var d= eval('('+data+')');
		        			if (d.status) {
		        				window.location.href='sm/user/userInfo.jsp';
		        			} else {
		        				alert(d.message);
		        			}
		                }
            		});
            
        }
        function clearForm(){
            $('#loginForm').form('clear');
        }
    </script>
</body>
</html>