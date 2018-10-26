layui.use(['form', 'layer', 'laydate', 'table', 'laytpl'], function() {
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : top.layer,
		$ = layui.jquery,
		laydate = layui.laydate,
		laytpl = layui.laytpl,
		table = layui.table;

	//新闻列表
	var tableIns = table.render({
		elem: '#newsList',
		url: '../../admin/ld-prj-page',
		request: {
			pageName: 'pageNum' //页码的参数名称，默认：page
				,
			limitName: 'pageSize' //每页数据量的参数名，默认：limit
		},
		response: {
			statusName: 'errorCode' //数据状态的字段名称，默认：code
				,
			statusCode: 0 //成功的状态码，默认：0
				,
			msgName: 'draw' //状态信息的字段名称，默认：msg
				,
			countName: 'recordsTotal' //数据总数的字段名称，默认：count
				,
			dataName: 'data' //数据列表的字段名称，默认：data
		},
		cellMinWidth: 95,
		page: true,
		height: "full-125",
		limit: 15,
		limits: [10, 15, 20, 25],
		id: "newsListTable",
		cols: [
			[{
					type: "checkbox",
					fixed: "left",
					width: 50
				},
				{
					field: 'id',
					title: '编号',
					width: 80,
					align: "center",
					sort: true
				},
				{
					field: 'fullName',
					title: '项目名称',
					width: 380,
					templet:'<div><span title="{{d.fullName}}">{{d.fullName}}</span></div>'
				},
				{
					field: 'rspLeaderName',
					title: '责任市领导',
					align: 'center',
					minWidth: 100
				},
				{
					field: 'content',
					title: '项目内容',
					align: 'center',
					minWidth: 400,
					templet:'<div><span title="{{d.content}}">{{d.content}}</span></div>'
				},
				{
					field: 'totalInvest',
					title: '计划总投资',
					align: 'center',
					minWidth: 100
				},
				{
					field: 'actualInvest',
					title: '实际总投资',
					align: 'center',
					minWidth: 100
				},
				{
					field: 'type',
					title: '推进难度',
					align: 'center',
					minWidth: 110
				},
				{
					field: 'industryDis',
					title: '行业',
					align: 'center'
				},
				{
					field: 'areaName',
					title: '区域',
					align: 'center',
					minWidth: 200,
					templet:'<div><span title="{{d.areaName}}">{{d.areaName}}</span></div>'
				},
				{
					field: 'lng',
					title: '经度',
					align: 'center',
					minWidth: 120
				},
				{
					field: 'lat',
					title: '纬度',
					align: 'center',
					minWidth: 120
				},
				{
					field: 'planStatusDis',
					title: '计划建设阶段',
					align: 'center',
					minWidth: 120
				},
				{
					field: 'actualStatusDis',
					title: '实际建设阶段',
					align: 'center',
					minWidth: 120
				},
				{
					field: 'planStartDt',
					title: '计划开工日期',
					align: 'center',
					minWidth: 120
				},
				{
					field: 'planEndDt',
					title: '计划竣工日期',
					align: 'center',
					minWidth: 120
				},
				{
					field: 'actualStartDt',
					title: '实际开工日期',
					align: 'center',
					minWidth: 120
				},

				{
					field: 'actualEndDt',
					title: '实际竣工日期',
					align: 'center',
					minWidth: 120
				},
				{
					field: 'is60thWelfare',
					title: '是否60周年',
					align: 'center',
					minWidth: 120
				},
				{
					field: 'isPrvcPlan',
					title: '是否区统筹',
					align: 'center',
					minWidth: 120
				},
				{
					field: 'latestYearId',
					title: '关联的年记录',
					align: 'center',
					minWidth: 120
				},

				{
					field: 'createAt',
					title: '记录时间',
					align: 'center',
					minWidth: 180
				},
				{
					field: 'remark',
					title: '备注',
					align: 'center',
					minWidth: 400,
					templet:'<div><span title="{{d.remark}}">{{d.remark}}</span></div>'
				},
				{
					title: '操作',
					width: 170,
					templet: '#newsListBar',
					fixed: "right",
					align: "center"
				}
				//{"id":21015,"latestYearId":16,"fullName":"南宁市凤岭综合客运枢纽站（长途客运站部分）一期工程","shortName":"","lng":108.42316832,"lat":22.84480483,"rspLeaderId":110000,"contactLeaderId":null,"contactId":null,"type":2,"content":"一级汽车客运站，总建筑面积为68789平方米。","totalInvest":53449,"actualInvest":null,"submitOrgId":null,"industry":20302,"planStatus":20404,"actualStatus":null,"areaId":"15","remark":"自治区层面重大项目（竣工）、60周年公益性项目","planStartDt":null,"planEndDt":null,"actualStartDt":null,"actualEndDt":null,"is60thWelfare":1,"isPrvcPlan":1,"ownerOrgName":null,"remarkDisplay":null,"createAt":"2018-01-08 10:09:02","updateAt":"2018-03-08 10:09:02","rspLeaderName":"张文军","industryDis":"基础设施","planStatusDis":"竣工投产","actualStatusDis":null,"areaName":"青秀区"}
			]
		]
	});

	//搜索功能
	$(".search_btn").on("click", function() {
		if($(".searchVal").val() != '') {
			table.reload("newsListTable", {
				page: {
					curr: 1 //重新从第 1 页开始
				},
				where: {
					keyword: $(".searchVal").val() //搜索的关键字
				}
			})
		} else {
			layer.msg("请输入搜索的内容");
		}
	});

	// 编辑项目信息
	function editProjectInfo(edit) {
		var index = layui.layer.open({
			title: "编辑项目",
			type: 2,
			content: "projectAdd.html",
			success: function(layero, index) {
				var body = layui.layer.getChildFrame('body', index);
				if(edit) {
					body.find(".fullName").val(edit.fullName);
					$.ajax({
						url: '../../admin/ld-prj-options',						
						success: function(data){
							/*body.find("#selectLeader").html("");	
							body.find("#areaName").html("");
							body.find("#industryDis").html("");
							body.find("#selectLeader").append('<option value=""></option>');
							body.find("#industryDis").append('<option value=""></option>');
							body.find("#actualStatusDis").append('<option value=""></option>');
							body.find("#actualStatusDis").append('<option value=""></option>');*/
							if (null != edit.areaName && "" != edit.areaName) {
								var allAreaName = edit.areaName.split(',');
							}
							
							for(var l=0;l<data.leaderList.length;l++){
								if(edit.rspLeaderName == data.leaderList[l].optText){									
									body.find("#selectLeader").append('<option value="'+data.leaderList[l].optValue+'" selected="">'+data.leaderList[l].optText+'</option>');									
								}
								else{
									body.find("#selectLeader").append('<option value="'+data.leaderList[l].optValue+'">'+data.leaderList[l].optText+'</option>');									
								}							   
							}
							for(var a=0;a<data.areaList.length;a++){
								if(null != allAreaName && allAreaName.indexOf(data.areaList[a].optText) > -1){									
									body.find("#areaName").append('<input type="checkbox" checked="checked" value="' + data.areaList[a].optValue + '" title="'+data.areaList[a].optText+'">');									
								}
								else{
									body.find("#areaName").append('<input type="checkbox" value="' + data.areaList[a].optValue + '" title="'+data.areaList[a].optText+'">');					
								}	
							}							
							for(var i=0;i<data.industryList.length;i++){
								if(edit.industryDis == data.industryList[i].optText){									
									body.find("#industryDis").append('<option value="'+data.industryList[i].optValue+'" selected="">'+data.industryList[i].optText+'</option>');									
								}
								else{
									body.find("#industryDis").append('<option value="'+data.industryList[i].optValue+'">'+data.industryList[i].optText+'</option>');									
								}	
							}
							for(var b=0;b<data.buildStatusList.length;b++){
								if(edit.actualStatusDis == data.buildStatusList[b].optText){									
									body.find("#actualStatusDis").append('<option value="'+data.buildStatusList[b].optValue+'" selected="">'+data.buildStatusList[b].optText+'</option>');									
								}
								else{
									body.find("#actualStatusDis").append('<option value="'+data.buildStatusList[b].optValue+'">'+data.buildStatusList[b].optText+'</option>');									
								}
								if(edit.planStatusDis == data.buildStatusList[b].optText){									
									body.find("#planStatusDis").append('<option value="'+data.buildStatusList[b].optValue+'" selected="">'+data.buildStatusList[b].optText+'</option>');									
								}
								else{
									body.find("#planStatusDis").append('<option value="'+data.buildStatusList[b].optValue+'">'+data.buildStatusList[b].optText+'</option>');									
								}	
							}
						},
						error:function(){
							layer.msg("获取数据失败");
						}
					});
					
					body.find("#id").val(edit.id);
					body.find("#fullName").val(edit.fullName);
					
					body.find("#is60thWelfare").prop("checked", edit.is60thWelfare);
					body.find("#isPrvcPlan").prop("checked", edit.isPrvcPlan);
					body.find("#totalInvest").val(edit.totalInvest);
					
					body.find("#actualInvest").val(edit.actualInvest);
					body.find("#type").val(edit.type);
					body.find("#industryDis").val(edit.industryDis);					
					body.find("#lng").val(edit.lng);
					body.find("#lat").val(edit.lat);
					
					body.find("#planStatusDis").val(edit.planStatusDis);
					body.find("#actualStatusDis").val(edit.actualStatusDis);					
					
					body.find("#planStartDt").val(edit.planStartDt);
					body.find("#planEndDt").val(edit.planEndDt);
					body.find("#actualStartDt").val(edit.actualStartDt);
					body.find("#actualEndDt").val(edit.actualEndDt);
					
					body.find("#latestYearId").val(edit.latestYearId);
					body.find("#createAt").val(edit.createAt);
					
					body.find("#remark").val(edit.remark);
					
					body.find("#content").val(edit.content);
					
					// 隐藏添加按钮
					body.find("#createPrjInfoButton").css({"visibility":"hidden"});
					body.find("#createPrjInfoButton").css({"display":"block"});
					
					form.render();
				}
				setTimeout(function() {
					layui.layer.tips('点击此处返回项目列表', '.layui-layer-setwin .layui-layer-close', {
						tips: 3
					});
				}, 500)
			}
		})
		layui.layer.full(index);
		$(window).on("resize", function() {
			layui.layer.full(index);
		})
	}
	
	$(".addNewPrjInfoButton").click(function() {
		addNewProjectInfo()
	})
	
	function addNewProjectInfo() {
		var index = layui.layer.open({
			title: "新增项目",
			type: 2,
			content: "projectAdd.html",
			success: function(layero, index) {
				var body = layui.layer.getChildFrame('body', index);
				$.ajax({
					url: '../../admin/ld-prj-options',						
					success: function(data){
						// populate leaders list drop-down menu
						for(var l=0; l<data.leaderList.length; l++){
							body.find("#selectLeader").append('<option value="' + data.leaderList[l].optValue+'">' + data.leaderList[l].optText + '</option>');
						}
						// populate areas list drop-down menu
						for(var a=0; a<data.areaList.length; a++){										
							body.find("#areaName").append('<input type="checkbox" value="' + data.areaList[a].optValue + '" title="' + data.areaList[a].optText + '">');	
						}
						// populate industry list drop-down menu
						for(var i=0;  i<data.industryList.length; i++){
							body.find("#industryDis").append('<option value="' + data.industryList[i].optValue + '">' + data.industryList[i].optText + '</option>')
						}
						// populate actual status and plan status list drop-down menu
						for(var b=0;b<data.buildStatusList.length;b++){
							body.find("#actualStatusDis").append('<option value="' + data.buildStatusList[b].optValue + '">' + data.buildStatusList[b].optText + '</option>');									
							body.find("#planStatusDis").append('<option value="' + data.buildStatusList[b].optValue + '">' + data.buildStatusList[b].optText + '</option>');									
						}
					},
					error:function() {
						layer.msg("获取数据失败");
					}
				});

				// 隐藏修改按钮
				body.find("#updatePrjInfoButton").css({"visibility":"hidden"});
				body.find("#updatePrjInfoButton").css({"display":"block"});
				
				form.render();
					
				setTimeout(function() {
					layui.layer.tips('点击此处返回项目列表', '.layui-layer-setwin .layui-layer-close', {
						tips: 3
					});
				}, 500)
			}
		})
		
		layui.layer.full(index);
		$(window).on("resize", function() {
			layui.layer.full(index);
		})
	}

	//批量删除
	$("#multipleDelete").click(function() {
		var checkStatus = table.checkStatus('newsListTable'),
			data = checkStatus.data,
			prjInfoIdList = [];
		if(data.length > 0) {
			for(var i in data) {
				prjInfoIdList.push(data[i].id);
			}
			layer.confirm('确定删除选中的文章？', {
				icon: 3,
				title: '提示信息'
			}, function(index) {
				$.ajax({
				    url: '../../admin/ld-prj-multiple-delete-by-ids',
				    type: 'POST',
				    data: JSON.stringify(prjInfoIdList),
				    contentType: 'application/json; charset=utf-8',
				    success: function (response) {
				    	layer.alert("成功删除项目！项目ID：" + prjInfoIdList);
				    }
				}); 
				
				tableIns.reload();
				layer.close(index);
				location.reload();
			})
		} else {
			layer.msg("请选择需要删除的文章");
		}
	})

	// 列表操作
	table.on('tool(newsList)', function(obj) {
		var layEvent = obj.event,
			data = obj.data;

		if(layEvent === 'edit') { //编辑
			editProjectInfo(data);
		} else if(layEvent === 'del') { //删除
			layer.confirm('确定删除此文章？', {
				icon: 3,
				title: '提示信息'
			}, function(index) {
				$.ajax({
				    url: '../../admin/ld-prj-delete-by-id',
				    type: 'POST',
				    data: jQuery.param({ projectInfoId:data.id }) ,
				    contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
				    success: function (response) {
				    	layer.alert("成功删除项目！项目ID：" + data.id + " 项目名称：" + data.fullName);
				    }
				}); 
				tableIns.reload();
				layer.close(index);
			});
		} else if(layEvent === 'look') { // 浏览
			layer.alert("此功能需要前台展示，实际开发中传入对应的必要参数进行文章内容页面访问")
		}
	});
	
})