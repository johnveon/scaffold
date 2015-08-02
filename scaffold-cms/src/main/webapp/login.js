$(function(){
	
	
});


function login(){
	
	var $loginForm = $('#loginForm');
	
	var actionurl=$loginForm.attr('action');//提交路径
	//var checkurl=$('form').attr('check');
	
	//var formData = new Object();
	//var data=$(":input").each(function() {
		 //formData[this.id] =$("#"+this.id ).val();
	//});
	var formData =  $loginForm.serializeArray();
	
	$.ajax({
		async : true,
		cache : false,
		type : 'POST',
		url : actionurl,// 请求的action路径
		data : formData,
		error : function() {// 请求失败处理函数
		},
		success : function(data) {
			//var d = $.parseJSON(data);
			var d= data  ;//eval('('+data+')');
			if (d.status) {
				window.location.href='sm/user/userInfo.jsp';
			} else {
				alert(d.message);
			}
			
		}
	});
	
}