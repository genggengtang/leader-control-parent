layui.use(['form', 'layer', 'layedit', 'laydate', 'upload'], function() {
	var form = layui.form
	layer = parent.layer === undefined ? layui.layer : top.layer,
		laypage = layui.laypage,
		upload = layui.upload,
		layedit = layui.layedit,
		laydate = layui.laydate,
		$ = layui.jquery;
	
	// 根据ID渲染日期组件
	laydate.render({
		elem: '#planStartDt'
	});
	laydate.render({
		elem: '#planEndDt'
	});
	laydate.render({
		elem: '#actualStartDt'
	});
	laydate.render({
		elem: '#actualEndDt'
	});
	laydate.render({
		elem: '#createAt'
	});
	
	form.render();
	//用于同步编辑器内容到textarea
	layedit.sync(editIndex);

	//上传缩略图
	upload.render({
		elem: '.thumbBox',
		url: '../../json/userface.json',
		method: "get", //此处是为了演示之用，实际使用中请将此删除，默认用post方式提交
		done: function(res, index, upload) {
			var num = parseInt(4 * Math.random()); //生成0-4的随机数，随机显示一个头像信息
			$('.thumbImg').attr('src', res.data[num].src);
			$('.thumbBox').css("background", "#fff");
		}
	});

	//格式化时间
	function filterTime(val) {
		if(val < 10) {
			return "0" + val;
		} else {
			return val;
		}
	}
	
	//定时发布
	var time = new Date();
	var submitTime = time.getFullYear() + '-' + filterTime(time.getMonth() + 1) + '-' + filterTime(time.getDate()) + ' ' + filterTime(time.getHours()) + ':' + filterTime(time.getMinutes()) + ':' + filterTime(time.getSeconds());
	laydate.render({
		elem: '#release',
		type: 'datetime',
		trigger: "click",
		done: function(value, date, endDate) {
			submitTime = value;
		}
	});
	
	form.on("radio(release)", function(data) {
		if(data.elem.title == "定时发布") {
			$(".releaseDate").removeClass("layui-hide");
			$(".releaseDate #release").attr("lay-verify", "required");
		} else {
			$(".releaseDate").addClass("layui-hide");
			$(".releaseDate #release").removeAttr("lay-verify");
			submitTime = time.getFullYear() + '-' + (time.getMonth() + 1) + '-' + time.getDate() + ' ' + time.getHours() + ':' + time.getMinutes() + ':' + time.getSeconds();
		}
	});

	form.verify({
		isNumber: function(val) {
			var re = /^[0-9]+.?[0-9]*$/;
			if(!re.test(val) && val != '') {
				return "请输入数字格式";
			}			
		},
		isNumber0: function(val) {
			var re = /^[1-9]$/;
			if(!re.test(val) && val != '') {
				return "请输入大于0的整数";
			}			
		},
		isDate: function(val) {
			if(!reg.test(val)&&RegExp.$2<=12&&RegExp.$3<=31&&val != '') {
				return "请输入正确的yyyy-MM-dd日期格式";
			}
		}
	})
	
	// 修改项目信息
	// 修改按钮点击事件
	form.on("submit(updateProjectInfo)", function() {
		postFormValuesAsJson("update")
	})
	
	// 新增项目信息
	// 新增按钮点击事件
	form.on("submit(createProjectInfo)", function() {
		postFormValuesAsJson("create")
	})
	
	function postFormValuesAsJson(type) {
		
		var url = "";
		var message = "";
		var prjInfoId = 0;
		
		if (type == "create") {
			url = "../../admin/ld-create-prj-info"
			message = "创建新项目信息成功！"
		}
		
		if (type == "update") {
			url = "../../admin/ld-prj-update-whole"
			message = "更新项目信息成功！"
			prjInfoId = $('#id').val();
		}
		
		// text input
		var fullName = $('#fullName').val();
		
		// drop-down menu
		var rspLeaderId = $('#selectLeader').find(":selected").val();
		var industry = $('#industryDis').find(":selected").val();
		var planStatus = $('#planStatusDis').find(":selected").val();
		var actualStatus = $('#actualStatusDis').find(":selected").val();
		
		// check-box
		var is60thWelfare = $('#is60thWelfare').prop("checked") ? 1 : 0;
		var isPrvcPlan = $('#isPrvcPlan').prop("checked") ? 1 : 0;
		
		// text input
		var totalInvest = $('#totalInvest').val();
		var actualInvest = $('#actualInvest').val();
		var type = $('#type').val();
		var lng = $('#lng').val();
		var lat = $('#lat').val();
		
		// date input
		var planStartDt = $('#planStartDt').val();
		var planEndDt = $('#planEndDt').val();
		var actualStartDt = $('#actualStartDt').val();
		var actualEndDt = $('#actualEndDt').val();
		
		// text input
		var latestYearId = $('#latestYearId').val();
		var createAt = $('#createAt').val(); // 记录时间
		var remark = $('#remark').val();
		var content = $('#content').val();
		
		var areaId = '';
		$("#areaName input:checkbox").each(function(){
			if ($(this).prop("checked")) {
				areaId += $(this).val() + ",";
			}
		})
		// remove last character
		areaId = areaId.substring(0, areaId.length - 1);
		
		var json = {
			  "actualEndDt": actualEndDt,
			  "actualInvest": parseInt(actualInvest),
			  "actualStartDt": actualStartDt,
			  "actualStatus": parseInt(actualStatus),
			  "areaId": areaId,
			  "contactId": 0,
			  "contactLeaderId": 0,
			  "content": content,
			  "createAt": createAt,
			  "fullName": fullName,
			  "id": prjInfoId,
			  "industry": parseInt(industry),
			  "is60thWelfare": parseInt(is60thWelfare),
			  "isPrvcPlan": parseInt(isPrvcPlan),
			  "lat": parseInt(lat),
			  "latestYearId": parseInt(latestYearId),
			  "lng": parseInt(lng),
			  "ownerOrgName": "",
			  "planEndDt": planEndDt,
			  "planStartDt": planStartDt,
			  "planStatus": parseInt(planStatus),
			  "remark": remark,
			  "remarkDisplay": "",
			  "rspLeaderId": parseInt(rspLeaderId),
			  "shortName": "",
			  "submitOrgId": parseInt(0),
			  "totalInvest": parseInt(totalInvest),
			  "type": parseInt(type),
			  "updateAt": createAt
			};
		
		console.log(JSON.stringify(json))
		
		$.ajax({
			type: "POST",
		    url: url,
		    data: JSON.stringify(json),
		    contentType: "application/json; charset=utf-8",
		    dataType: "json",
			complete: function(message) {
				top.layer.msg(message);
				layer.closeAll("iframe");
				parent.location.reload();},
		    failure: function(errMsg) {
		        alert(errMsg);
		    }
		});
	}
	
	//预览
	form.on("submit(look)", function() {
		layer.alert("此功能需要前台展示，实际开发中传入对应的必要参数进行文章内容页面访问");
		return false;
	})

	//创建一个编辑器
	var editIndex = layedit.build('news_content', {
		height: 535,
		uploadImage: {
			url: "../../json/newsImg.json"
		}
	});

})