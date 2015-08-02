<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript" src="../../lib3rd/my-easyui-validatebox-rule-extend.js"></script>
<script type="text/javascript" src="userEditDlg.js?time=New Date()"></script>
<link rel="stylesheet" type="text/css" href="menuEditDlg.css?time=New Date()">
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 8px;">
		<form id="custUserForm" method="post">
			<fieldset>
				<legend><img src="fromedit.png" style="margin-bottom: -3px;"/> 用户编辑</legend>
				<input name="userVO.userId" id="userId"  type="hidden"/>
				<input name="userVO.pwdChange" id="pwdChange" value="NO"  type="hidden"/>
<!-- 				<input name="userVO.custAccount" id="custAccount"  type="hidden"/> -->
				
				<!-- 
				<input name="created" id="created"  type="hidden"/>
				<input name="creater" id="creater"  type="hidden"/>
				<input name="status" id="status"  type="hidden"/>
				<input name="organizeName" id="organizeName"  type="hidden"/>
				 -->
				 <table>
					 <tr>
					    <th>用户名称</th>
						<td><input name="userVO.userName" id="userName" placeholder="请输入用户名称" class="easyui-textbox easyui-validatebox" type="text" 
								   data-options="required:true,validType:['normalChar','length[0,30]']"/></td>
						<th>用户账号</th>
						<td><input name="userVO.userCode" id="userCode"  class="easyui-textbox easyui-validatebox" type="text"  required="required"
								    validType="englishAnInt[0,30]" invalidMessage="英文或数字！不能超过30个字符！"/></td>
					 </tr>
					 <tr>
					    <th>用户密码</th>
						<td><input name="userVO.userPwd" id="userPwd"  type="password" class="easyui-textbox easyui-validatebox" 
								    validType="maxlengthEqualTo['confirm_userPwd',31]" invalidMessage="两次输入不一致或不能超过31个字符！"/></td>
						<th>确认密码</th>
						<td><input name="userVO.confirm_userPwd" id="confirm_userPwd" type="password" class="easyui-textbox easyui-validatebox" 
						           validType="maxlengthEqualTo['userPwd',31]" invalidMessage="两次输入不一致或不能超过31个字符！"/></td>
					 </tr>
					 <tr>
						<th>邮箱地址</th>
						<td><input name="userVO.email" id="email"  type="text" class="easyui-textbox easyui-validatebox"  required="required"
										 validType="email[99]" invalidMessage="输入正确邮箱或不超过99个字符！"/></td>
					    <th></th>
						<td></td>
						
					 </tr>
					<tr>
						<th>行业</th>
						<td colspan="3"><input name="userVO.industrys"  id="industrys" class="easyui-textbox easyui-validatebox" style="width: 435px;"></input></td>
					</tr>
				 </table>
			</fieldset>
		</form>
	</div>
</div>
