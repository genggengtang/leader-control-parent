(function($) {
	// 保存原有的jquery ajax;
	var $_ajax = $.ajax;

	$.ajaxSetup({
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		complete : function(XMLHttpRequest, textStatus) {
			/*
			 * var
			 * sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus");
			 * //通过XMLHttpRequest取得响应头，sessionstatus，
			 * if(sessionstatus=="timeout"){ alert('您的会话已经过期，请重新登陆后继续操作！');
			 * window.location.replace("/cz-web/"); return; } }
			 */
			if (isSessionTimeout(XMLHttpRequest))
				return;
		}
	});

})(jQuery);

function isSessionTimeout(xhr) {
	var sessionstatus = xhr.getResponseHeader("sessionstatus"); // 通过XMLHttpRequest取得响应头，sessionstatus，
	if (sessionstatus == "timeout") {
		alert('您的会话已经过期，请重新登陆后继续操作！');
		window.location.replace("/cz-web/");
		return true;
	}
	return false;
}

function sendFile(files) {
	console.log(files);
	var data = new FormData();
	data.append("file", files[0]);
	$.ajax({
		data : data,
		type : "POST",
		url : "../upload-img", // 图片上传出来的url，返回的是图片上传后的路径，http格式
		cache : false,
		contentType : false,
		processData : false,
		dataType : "json",
		success : function(data) {// data是返回的hash,key之类的值，key是定义的文件名
			if (data.code == 0) {
				$('#summernote').summernote('insertImage',
						data.data + '?imageslim');
			} else {
				alert(data.error);
			}

		},
		error : function() {
			alert("上传失败");
		}
	});
}

/**
 * 悬浮框展示 悬浮框写法 <a name='需要展示信息【图片给图片地址（数据库内的名称）】' data-toggle='popover'
 * rel='1'（必写1是文字 2是图片） data-placement='top'（弹出方向表格建议top）> by cjj
 */
//
function showimg()// 刷新表单同时调用本方法渲染悬浮框
{
	$("[data-toggle='popover']")
			.each(
		function() {
			var ele = $(this);
			if (ele.context.rel == "2" || ele.context.rel == 2) {
				var imgPath = IMGPATH + ele.context.name + "?t="
						+ new Date().getTime();
				if (ele.context.name == null
						|| ele.context.name == "null") {
					imgPath = "/manage/image/user/noImg.png";
}
ele.popover({
		trigger : 'hover',// 鼠标以上时触发弹出提示框
		html : true,// 开启html
					// 为true的话，data-content里就能放html代码了
		content : "<img src='" + imgPath
				+ "'height='200' width='200'>"
	});
}
else
{
ele.popover({
	trigger : 'hover',// 鼠标以上时触发弹出提示框
	html : true,// 开启html 为true的话，data-content里就能放html代码了
	content : "<a style='word-wrap: break-word; word-break: normal;'>"
				+ ele.attr("hov") + "</a>"
	});
	}
	});
}