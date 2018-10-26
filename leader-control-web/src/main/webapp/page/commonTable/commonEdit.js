layui.use(['form', 'layer', 'layedit', 'laydate', 'upload'], function() {
	var form = layui.form
	layer = parent.layer === undefined ? layui.layer : top.layer,
	laypage = layui.laypage,
	upload = layui.upload,
	layedit = layui.layedit,
	laydate = layui.laydate,
	$ = layui.jquery;
	
	// render date widget
	if($('.datepicker').length > 0){
	var dates = $('.datepicker').length
	for(var d=0;d<dates;d++){
		var datepickerId = $('.datepicker').eq(d).attr('id');
		laydate.render({
			elem: '#' + datepickerId,
			type: 'datetime'
			});
		}
	}
	
	// render form
	form.render();
	
	// 修改项目信息
	// 提交按钮点击事件
	form.on("submit(updateItem)", function() {

		//获取表单提交URL
		var updateUrl = $('#updateUrl').val();
		
		if($('.form-field').length > 0){
			var json = {};
			var dates = $('.form-field').length
			for(var d=0;d<dates;d++) {
				// 去有class属性中有form-field的节点的id
				var formFieldId = $('.form-field').eq(d).attr('id');
				
				// check if element is of certain class
				if (document.getElementById(formFieldId).className.split(" ").indexOf("checkbox") > -1) {
					var formFieldValue = $('#'+formFieldId).prop("checked") ? 1 : 0;
				} else {
					var formFieldValue = $('#'+formFieldId).val();
				}
				
				if (document.getElementById(formFieldId).className.split(" ").indexOf("multicheck") > -1) {
					// 遍历所有勾选项目
					var formFieldValue = '';
					$("#" + formFieldId + " input:checkbox").each(function(){
						if ($(this).prop("checked")) {
							formFieldValue += $(this).val() + ",";
						}
					})
					formFieldValue = formFieldValue.substring(0, formFieldValue.length - 1);
				}
				
				json[formFieldId] = formFieldValue;
				//console.log("formField >> " + formFieldId + " fieldValue >> " + formFieldValue);
			}
			
			// post JSON from form
			console.log("编辑 >>> " + JSON.stringify(json))
			$.ajax({
				type: "POST",
			    url: updateUrl,
			    data: JSON.stringify(json),
			    contentType: "application/json",
			    dataType: "json",
				complete: function(message) {
					//top.layer.msg(message);
					layer.closeAll("iframe");
					parent.location.reload();},
			    failure: function(errMsg) {
			        alert(errMsg);
			    }
			});
		}
	})
	
	// 新增项目信息
	// 提交按钮点击事件
	form.on("submit(newItem)", function() {
		var updateUrl = $('#updateUrl').val();
		if($('.form-field').length > 0){
			var json = {};
			var dates = $('.form-field').length
			for(var d=0;d<dates;d++) {
				var formFieldId = $('.form-field').eq(d).attr('id');
				// check if element is of certain class
				if(document.getElementById(formFieldId).className.split(" ").indexOf("checkbox") > -1) {
					var formFieldValue = $('#'+formFieldId).prop("checked") ? 1 : 0;
				} else {
					var formFieldValue = $('#'+formFieldId).val();
				}
				
				if (document.getElementById(formFieldId).className.split(" ").indexOf("multicheck") > -1) {
					// 遍历所有勾选项目
					var formFieldValue = '';
					$("#" + formFieldId + " input:checkbox").each(function(){
						if ($(this).prop("checked")) {
							formFieldValue += $(this).val() + ",";
						}
					})
					formFieldValue = formFieldValue.substring(0, formFieldValue.length - 1);
				}
				
				json[formFieldId] = formFieldValue;
				//console.log("formField >> " + formFieldId + " fieldValue >> " + formFieldValue);
			}
			
			// post JSON from form
			console.log("新增JSON >>> " + JSON.stringify(json))
			$.ajax({
				type: "POST",
			    url: updateUrl,
			    data: JSON.stringify(json),
			    contentType: "application/json",
			    dataType: "json",
				complete: function(message) {
					//top.layer.msg(message);
					layer.closeAll("iframe");
					parent.location.reload();},
			    failure: function(errMsg) {
			        alert(errMsg);
			    }
			});
		}
	})

});