var $dg;
var $temp;
var $grid;

$(function() {
	$dg = $("#userInfo");
	$grid = $dg.datagrid({
				url : "../../userAction!getUserInfo.action",
				width : 'auto',
				height : $(this).height() - 90,
				pagination : true,
				rownumbers : true,
				border : false,
				singleSelect : false,
				striped : true,
				frozenColumns : [ [ {
					field : 'ck',
					checkbox : true
				} ] ],
//				toolbar : '#tb',
				columns : [ [
						{
							field : 'userId',
							title : 'ID',
							width : parseInt($(this).width() * 0.1),
							align : 'left',
							editor : "text"
						},
						{
							field : 'userName',
							title : '用户名称',
							width : parseInt($(this).width() * 0.1),
							align : 'left',
							editor : "text"
						},
						{
							field : 'userCode',
							title : '用户账号',
							width : parseInt($(this).width() * 0.1),
							align : 'left',
							editor : "text"
						},
						{
							field : 'email',
							title : '邮箱',
							width : parseInt($(this).width() * 0.1)
						},
						{
							field : 'industryNames',
							title : '行业',
							width : parseInt($(this).width() * 0.08)
						},
						{
							field : 'createUsear',
							title : '创建人',
							showTip : true,
							width : parseInt($(this).width() * 0.08),
							align : 'left'
						},
						{
							field : 'createDate',
							title : '创建时间',
							showTip : true,
							width : parseInt($(this).width() * 0.13),
							align : 'left'
						},
						{
							field : 'modifyUser',
							title : '修改者',
							width : parseInt($(this).width() * 0.1)
						},
						{
							field : 'modifyDate',
							title : '修改时间',
							width : parseInt($(this).width() * 0.13),
							align : 'left',
							editor : "text"
						}] ]
//				onClickRow: function(rowIndex, rowData){
//		            //加载完毕后获取所有的checkbox遍历
//		            var radio = $("input[type='radio']")[rowIndex].disabled;
//		            //如果当前的单选框不可选，则不让其选中
//		            if (radio != true) {
//		                //让点击的行单选按钮选中
//		                $("input[type='radio']")[rowIndex].checked = true;
//		            }
//		            else {
//		                $("input[type='radio']")[rowIndex].checked = false;
//		            }
//		        }
			});
	// 搜索框
	
});



//弹窗修改
function updRowsOpenDlg() {
	
	if(!onlySelectOneUser($dg)){
		return;
	}
	
	var row = $dg.datagrid('getSelected');
	if (row) {
		parent.$.modalDialog({
			title : "编辑用户",
			width : 600,
			height : 500,
			href : "../../sm/user/userEditDlg.jsp",
			onLoad : function() {
				var f = parent.$.modalDialog.handler.find("#custUserForm");
				var formData = orgFormData(row,"userVO");
				formData['userVO.confirm_userPwd'] = formData['userVO.userPwd'];
				//var orgIdsStr = formData['userVO.orgIds']; 
				//var orgIdsObj = orgIdsStr != null ? $.makeArray(orgIdsStr) : null;
				//formData['userVO.orgIds'] = orgIdsObj;
				f.form("load", formData);
			},
			buttons : [ {
				text : '编辑',
				iconCls : 'icon-ok',
				handler : function() {
					parent.$.modalDialog.openner = $grid;
					var f = parent.$.modalDialog.handler.find("#custUserForm");
					f.submit();
				}
			}, {
				text : '取消',
				iconCls : 'icon-cancel',
				handler : function() {
					parent.$.modalDialog.handler.dialog('destroy');
					parent.$.modalDialog.handler = undefined;
				}
			} ]
		});
	} else {
		parent.$.messager.show({
			title : "提示",
			msg : "请选择一行记录!",
			timeout : 1000 * 2
		});
	}
}

function orgFormData(row,name) {
	var ret = {};
	var formData = $.extend(true, {}, row);
	for ( var key in formData) {
		var tmpkey = name + "." + key;
		ret[tmpkey] = formData[key];
	}
	return ret;
}
//选择一行
function onlySelectOneUser(dataGridTB){
	var isOne = true;
	var selecteds = dataGridTB.datagrid("getSelections");
	if(selecteds.length != 1){
		var alertMeg = ""
		var sLength = selecteds.length;
		if(sLength <= 0){
			alertMeg = "请选择一行数据!";
		}else if(sLength > 1){
			alertMeg = "只能选择一条记录！";
		}
		
		parent.$.messager.show({
			title : "提示",
			msg : alertMeg,
			timeout : 1000 * 2
		});
		
		isOne = false;
	}
	
	return isOne;
}