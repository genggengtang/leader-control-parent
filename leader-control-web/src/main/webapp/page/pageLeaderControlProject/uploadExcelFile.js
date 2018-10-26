function selectFile() {
	$("#formSelectFileButton").click();
}

function onSelect() {
	$("#formExcelSubmitButton").click();
}

$(document).ready(function() {
    $("#formExcelSubmitButton").click(function(event){
    	event.preventDefault();
    	fireAjaxSubmit();
    }); 
});

function fireAjaxSubmit() {
	
	var form = $('#excelUploadForm')[0];
	var json = new FormData(form);
	
	$.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "../../admin/ld-import-prj-info-excel",
        data: json,
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (json) {
            layer.open({
                type: 2,
                title: 'Excel导入结果',
                maxmin: false,
                shadeClose: true, //点击遮罩关闭层
                area : ['800px' , '520px'],
                content: "insertResultFrame.html",
                end : function(index) {
                	location.reload();
                },
                success : function(layero, index) {
                	console.log("json >> ", json);
                	
                	var body = layer.getChildFrame('body', index);
                	if (json) {
                		
                		
                		if (json.data.errorRows != 0) {
                			body.find("#result").text("导入失败行数：" + json.data.errorRows + "  总共记录行数：" + json.data.totalNumRows);
                			
	                		$(body).append("<table id='resultTable' class='layui-table'>" +
	                				"<colgroup><col width='100'><col></colgroup>" +
	                				"<thead><tr><th><center>Excel行号</center></th><th><center>错误原因</center></th></tr></thead>" +
	                				"<tbody></tbody></table>");
	                		
	                		var array = json.data.errorRowNums;
	                		for (var i = 0; i < array.length; i ++) {
	                			body.find("#resultTable").append("<tr><td><center>" + array[i] + "</center></td><td>" + json.data.exceptionList[i] + "</td></tr>");
	                		}
                		} else {
                			body.find("#result").text("成功导入Excel表中全部记录！ 总行数：" + json.data.totalNumRows);
                		}
                		

                	}
                }
            });
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
}