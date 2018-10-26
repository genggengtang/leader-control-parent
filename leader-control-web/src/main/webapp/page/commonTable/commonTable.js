// retrieve data-*
var tableName = window.parent.document.getElementsByClassName("layui-this")[0].getElementsByTagName('a')[0].getAttribute('data-table')
var isSoftDeletable = window.parent.document.getElementsByClassName("layui-this")[0].getElementsByTagName('a')[0].getAttribute('data-soft')
var create = window.parent.document.getElementsByClassName("layui-this")[0].getElementsByTagName('a')[0].getAttribute('data-create')
var down = window.parent.document.getElementsByClassName("layui-this")[0].getElementsByTagName('a')[0].getAttribute('data-down')
var soft = window.parent.document.getElementsByClassName("layui-this")[0].getElementsByTagName('a')[0].getAttribute('data-soft')
var impr = window.parent.document.getElementsByClassName("layui-this")[0].getElementsByTagName('a')[0].getAttribute('data-impr')

var rowsUrl = "../../tables/" + tableName.replace(/_/g, "-") + "/rows"
var colsUrl = "../../tables/" + tableName.replace(/_/g, "-") + "/cols"
var optionsUrl = "../../tables/" + tableName.replace(/_/g, "-") + "/edit-page"
var updateUrl = "../../tables/" + tableName.replace(/_/g, "-") + "/update"
var deleteUrl = "../../tables/delete-by-id"
var exportUrl = "../../tables/export-excel?table=" + tableName

// render table after retrieving header data successfully
layui.use(['table', 'form', 'layer', 'laydate', 'table', 'laytpl'], function() {
	var form = layui.form,
	layer = parent.layer === undefined ? layui.layer : top.layer,
	$ = layui.jquery,
	laydate = layui.laydate,
	laytpl = layui.laytpl,
	table = layui.table;
	
	// render manipulation buttons
	if (create == "false") {
		$(".newItemButton").hide();
	}
	if (down == "false") {
		$(".excelExportButton").hide();
	}
	if (impr == "false") {
		$(".excelImportButton").hide();
	}
	
	// 绑定点击事件
	$('[data-type]').click(function(){
		var type = $(this).data('type');
		action[type].call(this);
	});

	// 搜索关键字事件
	var action = {
		search:function() {
			var keywordVal = document.getElementById('searchVal').value;
			table.reload('commonList', {
				where: {
					keyword: keywordVal,
				},
				page: {
		            curr: 1 // 重新从第 1 页开始
		        }
			});
		}
	};
	
	// 刷新当前分页
//	action = {
//		reload:function() {
//			table.reload('commonList', {
//				where: {
//					pageName: 'pageNum',
//    				limitName: 'pageSize'
//				}
//			});
//		}
//	};
	
	var tableIns;
	// 渲染列表
	$.ajax({ 
	    type: "GET", 
	    url: colsUrl, 
	    dataType: "json", 
	    success: function (headerData) {
	    	var template = ',{"templet":"#operationBar","width":170,"fixed":"right","title":"操作","align":"center"}'
    		var templateSoft = ',{"templet":"#operationBarSoft","width":170,"fixed":"right","title":"操作","align":"center"}'
			if (soft == "true") {
				var headerArray = JSON.parse("[" + JSON.stringify(headerData).slice(0, -1) + templateSoft + "]]")
			} else {
				var headerArray = JSON.parse("[" + JSON.stringify(headerData).slice(0, -1) + template + "]]")
			}
	    	
	    	tableIns = table.render({
	    		id: 'commonList',
    			elem: '#commomTableList',
    			url: rowsUrl, // table row data URL
    			request: 
    			{
    				pageName: 'pageNum',		//当前页码
    				limitName: 'pageSize'		//每页显示记录条数
    			},
    			response:
    			{
    				statusName:	'errorCode', 	//数据状态的字段名称，默认：code
    				statusCode:	0, 				//成功的状态码，默认：0
    				msgName:	'draw',			//状态信息的字段名称，默认：msg
    				countName:	'recordsTotal',	//数据总数的字段名称，默认：count
    				dataName:	'data' 			//数据列表的字段名称，默认：data
    			},
    			cellMinWidth: 95,
    			page: true,
    			height: "full-125",
    			limit: 15,
    			limits: [10, 15, 20, 25],
    			cols: headerArray // dynamically set table headers
    		}); // end table render
	    },
	    error: function (XMLHttpRequest, textStatus, errorThrown) { 
	    	alert("无法获取表头数据！ " + errorThrown); 
	    }
	})
	
	// 工具栏
	table.on('tool(commomTableList)', function(obj) {
		var layEvent = obj.event,
			data = obj.data;
		if(layEvent === 'edit') { //编辑
			// trigger edit function
			editItem(data);
		} else if(layEvent === 'del') { //删除
			layer.confirm('确定删除此记录？', {
				icon: 3,
				title: '提示信息'
			}, function(index) {
				$.ajax({
				    url: deleteUrl,
				    type: 'POST',
				    data: jQuery.param(
				    		{
				    			table : tableName,
				    			id : data.id 
				    		}),
				    contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
				    success: function (response) {
				    	if (response) {
				    		layer.alert(response.errorMsg)
				    	}
				    }
				});
				tableIns.reload();
				layer.close(index);
			});
		} else if(layEvent === 'look') { // 浏览
			layer.alert("此功能需要前台展示，实际开发中传入对应的必要参数进行文章内容页面访问")
		}
	});
	
	$(".newItemButton").click(function() {
		newItem();
	})
	
	$(".excelExportButton").click(function() {
		excelExport();
	})
	
	function excelExport() {
		console.log("excelExport()")
		window.location = exportUrl;
	}
	
	// 编辑项目
	var globalIndex;
	function editItem(edit) {
		if(edit) {
			$.ajax({
				url: optionsUrl, // optionsUrl defined at the top of the document				
				success: function(data) {
					var index = layui.layer.open({
						title: "编辑项目",
						type: 2,
						content: "commonEdit.html",
						error:function() {
							layer.msg("获取数据失败");
						},
						success: function(layero, index) {
							var body = layui.layer.getChildFrame('body', index);
							globalIndex = index;
							
							// 赋值updateUrl
							body.find("#customDiv").append('<input id="updateUrl" type="text" value="' + updateUrl + '" style="display: none;">');
							
							for (var i=0; i < data.headers.length; i++) {
								// 输入框
								if ("text" == data.headers[i].fieldType) {
									var colName = data.headers[i].engColName;
									var value = edit[colName];
									
									body.find("#customDiv").append(
											'<div class="layui-inline">' +
											'<label class="layui-form-label">' + data.headers[i].chnColName + '</label>' +
											'<div class="layui-input-inline">' + 
											'<input id="' + data.headers[i].engColName + '" lay-verify="required" type="text" value="' + ((value === null) ? "" : value) + '" class="layui-input form-field"></div>' +
											'</div>');
								}
								
								if ("number" == data.headers[i].fieldType) {
									var colName = data.headers[i].engColName;
									var value = edit[colName];
									
									body.find("#customDiv").append(
											'<div class="layui-inline">' +
											'<label class="layui-form-label">' + data.headers[i].chnColName + '</label>' +
											'<div class="layui-input-inline">' + 
											'<input id="' + data.headers[i].engColName + '" lay-verify="number" type="text" value="' + ((value === null) ? "" : value) + '" class="layui-input form-field"></div>' +
											'</div>');
								}
								
								// 输入区域
								if ("textarea" == data.headers[i].fieldType) {
									var colName = data.headers[i].engColName;
									var value = edit[colName];
									
									body.find("#customDiv").append(
											'<div class="layui-form-item layui-form-text">' +
											'<label class="layui-form-label">' + data.headers[i].chnColName + '</label>' +
											'<div class="layui-input-block">' + 
											'<textarea placeholder="' + data.headers[i].chnColName + '" id="' + data.headers[i].engColName +  '" class="layui-textarea form-field">' + ((value === null) ? "" : value) + '</textarea></div>' +
											'</div>');
								}
								
								// 日期选择
								if ("date" == data.headers[i].fieldType) {
									var colName = data.headers[i].engColName;
									var datetime = edit[colName];
									
									body.find("#customDiv").append(
											'<div class="layui-inline">' +
											'<label class="layui-form-label">' + data.headers[i].chnColName + '</label>' +
											'<div class="layui-input-inline">' + 
											'<input id="' + data.headers[i].engColName.replace("Trans","") + '" value="' + datetime + '" type="text" placeholder="日期时间" class="layui-input datepicker form-field" autocomplete="off"></div>' +
											'</div>');
								}
								
								// 下拉选择
								if ("select" == data.headers[i].fieldType) {
									var html = '<div class="layui-inline">' +
										'<label class="layui-form-label">' + data.headers[i].chnColName + '</label>' +
										'<div class="layui-input-block">' + 
										'<select id="' + data.headers[i].engColName.replace("Trans","") + '" class="form-field">' +
										'<option value=""></option>';
									
									var colName = data.headers[i].engColName;
									
									if (undefined == data.options[colName]) {
										return;
									}
									
									//console.log("colName >>> " + colName + " edit[colName] >>> " + edit[colName])
									
									var selected = edit[colName];
									Object.keys(data.options[colName]).forEach(function(key){
										var optText = data.options[colName][key].optText;
										var optValue = data.options[colName][key].optValue;
										
										//console.log("optText:" + optText + " optValue:" + optValue +  " selected:" + selected)
										
										if (optText == selected) {
											html += '<option value="' + optValue + '" selected="">' + optText + '</option>';
										} else {
											html += '<option value="' + optValue + '">' + optText + '</option>';
										}
									});
									
									html += '</select></div></div>';
									body.find("#customDiv").append(html);
								}
								
								// 单选
								if ("checkbox" == data.headers[i].fieldType) {
									var html = '<div class="layui-item">' +
												'<label class="layui-form-label">' + data.headers[i].chnColName + '</label>' +
												'<div class="layui-input-block">';
									
									var colName = data.headers[i].engColName;
									
									if (edit[colName] == 1) { // checked
										html +='<input id="' + data.headers[i].engColName.replace("Trans","") + '" type="checkbox" class="form-field checkbox" checked lay-skin="switch" lay-text="是|否">';
									} else {
										html +='<input id="' + data.headers[i].engColName.replace("Trans","") + '" type="checkbox" class="form-field checkbox" lay-skin="switch" lay-text="是|否">';
									}
									
									html += "</div></div>";
									body.find("#customDiv").append(html);
								}
								
								// 多选
								if ("multicheck" == data.headers[i].fieldType) {
									var chnCol = data.headers[i].chnColName;
									var engCol = data.headers[i].engColName;
									var value = edit[engCol];
									
									var html = '<div class="layui-inline">' +
									'<label class="layui-form-label">' + data.headers[i].chnColName + '</label>' +
									'<div class="layui-input-block form-field multicheck" id="' + engCol.replace("Trans","") +'">'
									
									Object.keys(data.options[engCol]).forEach(function(key) {
										var optText = data.options[engCol][key].optText;
										var optValue = data.options[engCol][key].optValue;
										
										if(value.includes(optText)) {
											html += '<input id="' + data.headers[i].engColName.replace("Trans","") + '" type="checkbox" checked="checked" value="' + optValue + '" title="' + optText + '">'
										} else {
											html += '<input id="' + data.headers[i].engColName.replace("Trans","") + '" type="checkbox" value="' + optValue + '" title="' + optText + '">'
										}
									})
									html += "</div></div>";
									body.find("#customDiv").append(html);
								}
								
							} // end for loop
							
							body.find("#customDiv").append(
									'<div class="layui-item">' +
									'<div class="layui-input-block">' +
									'<button id="updateItemButton" class="layui-btn" lay-submit="" lay-filter="updateItem">修改</button>' + 
									'</div></div>');

							// render and maximize
							layui.form.render();
							layui.layer.full(index);
							$(window).on("resize", function() {
								layui.layer.full(globalIndex);
							})
							setTimeout(function() {
								layui.layer.tips('点击此处返回项目列表', '.layui-layer-setwin .layui-layer-close', {
									tips: 3
								});
							}, 500)
						} // end layer open success
					}) // end layer open
				} // end AJAX success
			}) // end AJAX
		} // end if
	} // end editItem()

	// 新增项目
	function newItem() {
		$.ajax({
			url: optionsUrl, // optionsUrl defined at the top of the document				
			success: function(data) {
				var index = layui.layer.open({
					title: "新增项目",
					type: 2,
					content: "commonEdit.html",
					error:function() {
						layer.msg("获取数据失败");
					},
					success: function(layero, index) {
						var body = layui.layer.getChildFrame('body', index);
						globalIndex = index;
						
						// 取updateUrl
						body.find("#customDiv").append('<input id="updateUrl" type="text" value="' + updateUrl + '" style="display: none;">');
						
						for (var i=0; i < data.headers.length; i++) {
							
							// 输入框
							if ("text" == data.headers[i].fieldType) {
								if (data.headers[i].engColName == 'id') {
									body.find("#customDiv").append(
											'<div class="layui-inline" style="display: none;">' +
											'<label class="layui-form-label">' + data.headers[i].chnColName + '</label>' +
											'<div class="layui-input-inline">' + 
											'<input id="' + data.headers[i].engColName.replace("Trans","") + '" type="text" class="layui-input form-field"></div>' +
									'</div>');
								} else {
									body.find("#customDiv").append(
											'<div class="layui-inline">' +
											'<label class="layui-form-label">' + data.headers[i].chnColName + '</label>' +
											'<div class="layui-input-inline">' + 
											'<input id="' + data.headers[i].engColName.replace("Trans","") + '" type="text" class="layui-input form-field"></div>' +
									'</div>');
								}
							}
							
							// 数字
							if ("number" == data.headers[i].fieldType) {
								body.find("#customDiv").append(
										'<div class="layui-inline">' +
										'<label class="layui-form-label">' + data.headers[i].chnColName + '</label>' +
										'<div class="layui-input-inline">' + 
										'<input id="' + data.headers[i].engColName.replace("Trans","") + '" lay-verify="number" type="text" class="layui-input form-field"></div>' +
								'</div>');
							}
							
							// 文本区域
							if ("textarea" == data.headers[i].fieldType) {
								body.find("#customDiv").append(
										'<div class="layui-form-item layui-form-text">' +
										'<label class="layui-form-label">' + data.headers[i].chnColName + '</label>' +
										'<div class="layui-input-block">' + 
										'<textarea placeholder="请输入备注" id="' + data.headers[i].engColName.replace("Trans","") +  '" class="layui-textarea form-field"></textarea></div>' +
										'</div>');
							}
							
							// 日期选择
							if ("date" == data.headers[i].fieldType) {
								body.find("#customDiv").append(
										'<div class="layui-inline">' +
										'<label class="layui-form-label">' + data.headers[i].chnColName + '</label>' +
										'<div class="layui-input-inline">' + 
										'<input id="' + data.headers[i].engColName.replace("Trans","") + '" type="text" placeholder="日期时间" class="layui-input datepicker form-field" autocomplete="off"></div>' +
										'</div>');
							}
							
							// 下拉选择
							if ("select" == data.headers[i].fieldType) {
								var html = '<div class="layui-inline">' +
									'<label class="layui-form-label">' + data.headers[i].chnColName + '</label>' +
									'<div class="layui-input-block">' + 
									'<select id="' + data.headers[i].engColName.replace("Trans","") + '" class="form-field" placeholder="请选择">' +
									'<option value=""></option>';
								
								var colName = data.headers[i].engColName;
								
								//console.log("colName >>> " + colName + "   data.options[colName] >>> " + data.options[colName])
								Object.keys(data.options[colName]).forEach(function(key){
									var optText = data.options[colName][key].optText;
									var optValue = data.options[colName][key].optValue;
									
									//console.log("optText >>> " + optText + " optValue >>> " + optValue)
									html += '<option value="' + optValue + '">' + optText + '</option>';
								});
								
								html += '</select></div></div>';
								body.find("#customDiv").append(html);
							}
							
							// 单选
							if ("checkbox" == data.headers[i].fieldType) {
								var html = '<div class="layui-item">' +
											'<label class="layui-form-label">' + data.headers[i].chnColName + '</label>' +
											'<div class="layui-input-block">' + 
											'<input id="' + data.headers[i].engColName.replace("Trans","") + '" type="checkbox" class="form-field checkbox" lay-skin="switch" lay-text="是|否">';
								
								html += "</div></div>";
								body.find("#customDiv").append(html);
							}
							
							// 多选
							if ("multicheck" == data.headers[i].fieldType) {
								var chnCol = data.headers[i].chnColName;
								var engCol = data.headers[i].engColName;
								
								var html = '<div class="layui-inline">' +
								'<label class="layui-form-label">' + data.headers[i].chnColName + '</label>' +
								'<div class="layui-input-block form-field multicheck" id="' + engCol.replace("Trans","") +'">'
								
								Object.keys(data.options[engCol]).forEach(function(key) {
									var optText = data.options[engCol][key].optText;
									var optValue = data.options[engCol][key].optValue;
									html += '<input type="checkbox" value="' + optValue + '" title="' + optText + '">'
								})
								
								html += "</div></div>";
								body.find("#customDiv").append(html);
							}
						} // end for loop
						
						body.find("#customDiv").append(
								'<div class="layui-item">' +
								'<div class="layui-input-block">' +
								'<button id="newItemButton" class="layui-btn" lay-submit="" lay-filter="newItem">添加</button>' +
								'</div></div>');
	
						layui.form.render();
						layui.layer.full(index);
						$(window).on("resize", function() {
							layui.layer.full(globalIndex);
						})
						setTimeout(function() {
							layui.layer.tips('点击此处返回项目列表', '.layui-layer-setwin .layui-layer-close', {
								tips: 3
							});
						}, 500)
					}
				})
			}
		})
	}
})