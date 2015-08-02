//扩展easyui combo添加清除当前值。
	var oldResize = $.fn.combo.methods.resize;
	$.extend($.fn.combo.methods,{
		initClear:function(jq){
			return jq.each(function(){
				initClear(this);
			});
        },
        resize:function(jq){
            //调用默认combo resize方法。
            var returnValue = oldResize.apply(this,arguments);
            var opts = jq.data("combo").options;
            if(opts.initClear){
                jq.combo("initClear",jq);
            }
            return returnValue;
        }
    });

$(function() {
//	$("#organizeId").combotree({
//		width : 171,
//		url : "orgz/organizationAction!findOrganizationList.action",
//		idFiled : 'id',
//		textFiled : 'name',
//		parentField : 'pid',
//		onSelect : function(node) {
//			$("#organizeName").val(node.text);
//		}
//	});
	
//	$("#userName").change(function(){
////		$("#remark").val($(this).val());
//	});
	
	$('#userPwd').textbox({
		  onChange: function(value){
		    $("#pwdChange").val("YES");
		  }
		});
	
	$('#confirm_userPwd').textbox({
		  onChange: function(value){
		    $("#pwdChange").val("YES");
		  }
		});
	
//	$("#userType").combobox({
//		width : 171,
//		editable:true,
//		url : 'userAction!findDictByTypeid.action?dictTypeId=USER_TYPE',
//		valueField : 'id',
//		textFiled : 'text'
//	});
	
	
//	$("#orgIds").combotree({
//		width : '90.8%',
//		multiple : true,
//		animate : true,
//		checkbox : true,
//		editable:false,
//		cascadeCheck : false,
//		lines:true,
//		parentField : 'parentId',
//		url : 'organAction!findByAdmin4Tree.action'
//	});
	
	//$("#orgIds").combotree("setValues",["27","29","30"]);
	//$("#orgIds").combotree("initClear");
	
//	$("#roleIds").combobox({
//		 width : '90.8%',
//		 url:'roleAction!findByAdmin.action',
//         method:'get',
//         valueField:'id',
//         textField:'text',
//         multiple:true,
//         panelHeight:'auto'
//	});
	
	$("#industrys").combotree({
		url : '../../userAction!getIndustrys.action',
		width : '90.8%',
		multiple : true,
		animate : true,
		checkbox : true,
		editable:false,
		cascadeCheck : false,
		lines:true
	});
	

	$("#custUserForm").form({
		url : "../../userAction!updateUser.action",
		onSubmit : function() {
			parent.$.messager.progress({
				title : '提示',
				text : '数据处理中，请稍后....'
			});
			var isValid = $(this).form('validate');
			if (!isValid) {
				parent.$.messager.progress('close');
			}
			return isValid;
		},
		success : function(result) {
			parent.$.messager.progress('close');
			result = $.parseJSON(result);
			if (result.status) {
				parent.reload;
				parent.$.modalDialog.openner.datagrid('reload');// 之所以能在这里调用到parent.$.modalDialog.openner_datagrid这个对象，是因为role.jsp页面预定义好了
				parent.$.modalDialog.handler.dialog('close');
				parent.$.messager.show({
					title : result.title,
					msg : result.message,
					timeout : 1000 * 5
				});
			} else {
				parent.$.messager.show({
					title : result.title,
					msg : result.message,
					timeout : 1000 * 5
				});
			}
		}
	});
//	
//	$("#userValiddate").datebox().datebox('calendar').calendar({
//        validator: function(date){
//            var now = new Date();
//            var d = new Date(now.getFullYear(), now.getMonth(), now.getDate());
//            return d<=date;
//        }
//    });
	
//	$("#pwdValiddate").datebox().datebox('calendar').calendar({
//		validator: function(date){
//			var now = new Date();
//			var d = new Date(now.getFullYear(), now.getMonth(), now.getDate());
//			return d<=date;
//		}
//	});
    
});

 //初始化清除按钮
    function initClear(target){
        var jq = $(target);
        var opts = jq.data('combo').options;
        var combo = jq.data('combo').combo;
        var arrow = combo.find('span.combo-arrow');
        
        var clear = arrow.siblings("span.combo-clear");
        if(clear.size()==0){
            //创建清除按钮。
            clear = $('<span class="combo-clear" style="height: 20px;"></span>');
            
            //清除按钮添加悬停效果。
            clear.unbind("mouseenter.combo mouseleave.combo").bind("mouseenter.combo mouseleave.combo",
                function(event){
                    var isEnter = event.type=="mouseenter";
                    clear[isEnter ? 'addClass' : 'removeClass']("combo-clear-hover");
                }
            );
            //清除按钮添加点击事件，清除当前选中值及隐藏选择面板。
            clear.unbind("click.combo").bind("click.combo",function(){
                jq.combo("setValue","").combo("setText","");
                jq.combo('hidePanel');
            });
            arrow.before(clear);
        };
        var input = combo.find("input.combo-text");
        input.outerWidth(input.outerWidth()-clear.outerWidth());
        
        opts.initClear = true;//已进行清除按钮初始化。
    }

function myformatter(date){
    var y = date.getFullYear();
    var m = date.getMonth()+1;
    var d = date.getDate();
    return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
}
function myparser(s){
    if (!s) return new Date();
    var ss = (s.split('-'));
    var y = parseInt(ss[0],10);
    var m = parseInt(ss[1],10);
    var d = parseInt(ss[2],10);
    if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
        return new Date(y,m-1,d);
    } else {
        return new Date();
    }
}
