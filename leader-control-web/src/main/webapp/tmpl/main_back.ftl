<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
    <title>后台主页</title>
    <!-- <link rel="stylesheet" href="//adminlte.io/themes/AdminLTE/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="//adminlte.io/themes/AdminLTE/bower_components/font-awesome/css/font-awesome.min.css"> -->
    <link href="https://colorlib.com/polygon/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://colorlib.com/polygon/vendors/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/main.css"/>
    <link rel="stylesheet" href="../css/backstage.css"/>
    <!-- <link rel="stylesheet" href="//adminlte.io/themes/AdminLTE/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css"> -->
    <link href="https://colorlib.com/polygon/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
</head>
<body class="nav-md">
<div id="wait" style="position: absolute;background: rgba(0,0,0,0.3);width: 100%;height: 100%;top: 0;left: 0;display:none;z-index: 99999">
    <img src="//qiniu.jyblue.com/wait.gif" style="width: 20%;margin-left: 40%;margin-top: 15%;">
</div>
<div class="container body">
    <div class="main_container">

        <div class="col-md-3 left_col">
            <div class="left_col scroll-view">
                <div class="navbar nav_title" style="border: 0;">
                    <a href="main" class="site_title"><i class="fa fa-home"></i> <span>核查后台</span></a>
                </div>

                <div class="clearfix"></div>

                <!-- menu profile quick info -->
                <div class="profile">
                    <div class="profile_pic">
                        <img src="http://www.admineap.com/resources/adminlte/dist/img/user0-160x160.jpg" alt="..." class="img-circle profile_img">
                    </div>
                    <div class="profile_info">
                        <span>欢迎您,</span>
                        <h2>${admin.nickname}</h2>
                    </div>
                </div>
                <!-- /menu profile quick info -->

                <br>


                <!-- sidebar menu -->
                <div class="clearBoth"></div>
                <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                
                    <div class="menu_section" >
                        <ul class="nav side-menu" style="">
		                  <li class="active"><a><i class="fa fa-paw"></i> 项目管理 <span class="fa fa-chevron-down"></span></a>
		                    <ul class="nav child_menu" style="display:block;">
		                      <li id="ld_prj" class="active"><a><span id="ld_prj_cnt" class="label label-danger pull-right">4</span><i class="fa fa-star"></i>市领导联系项目</a>
		                      </li>
		                    </ul>
		                  </li>
		                </ul>
                    </div>
                </div>
                <!-- /sidebar menu -->
            </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
            <div class="nav_menu">
                <nav class="" role="navigation">
                    <div class="nav toggle">
                        <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                    </div>

                    <ul class="nav navbar-nav navbar-right">
                        <li class="">
                            <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                <!-- <img src="http://www.admineap.com/resources/adminlte/dist/img/user0-160x160.jpg" alt=""> --><span>${admin.nickname}</span>
                                <span class=" fa fa-angle-down"></span>
                            </a>
                            <ul class="dropdown-menu dropdown-usermenu pull-right">
                                 <li data-toggle="modal" data-target="#myModal"><a><i class="fa fa-key pull-right"></i>修改密码</a></li>  
                                <li><a href="../html/admin/login.html"><i class="fa fa-sign-out pull-right"></i> 退出登录</a></li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <!-- /top navigation -->	        
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">修改密码</h4>
            </div>
            <div class="modal-body">
                <form action="update-password" name="rpsw" method="post" id="rpsw">
                    <div>
                        <label for="oldpassword"><span class="must">*</span>旧密码 (必填)</label><br />
                        <input id="oldpassword" type="password" required="required"/>
                        <input id="oldpasswordInput" name="oldPassword" type="hidden"/>
                    </div>
                    <div>
                        <label for="newpassword"><span class="must">*</span>新密码 (必填)</label><br />
                        <input id="newpassword" type="password" required="required"/>
                        <input id="newpasswordInput" name="newPassword" type="hidden"/>
                    </div>
                    <div>
                        <label for="newpassword1"><span class="must">*</span>重复新密码 (必填)</label><br />
                        <input id="newpassword1" type="password" required="required" />
                    </div>

                    <div>
                        <input id="pswSubmit" type="submit" value="提交" class="btn-success" >
                    </div>
                </form>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>

        <!-- page content -->
        <div class="right_col" role="main">
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
            <div class="pull-right">
                技术支持  —— 南宁市工程咨询规划事务所
            </div>
            <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
    </div>
</div><!-- jQuery -->
<script src="https://adminlte.io/themes/AdminLTE/bower_components/jquery/dist/jquery.min.js"></script>
<!-- <script type="text/javascript" src="https://adminlte.io/themes/AdminLTE/bower_components/datatables.net/js/jquery.dataTables.min.js"></script> -->
<script type="text/javascript" src="https://colorlib.com/polygon/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://colorlib.com/polygon/vendors/jquery.inputmask/dist/min/jquery.inputmask.bundle.min.js"></script>
<!-- <script src="https://editor.datatables.net/extensions/Editor/js/dataTables.editor.min.js" type="text/javascript"></script> -->
<!-- Bootstrap -->
<script src="https://adminlte.io/themes/AdminLTE/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- <script type="text/javascript" src="https://adminlte.io/themes/AdminLTE/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script> -->
<!-- Custom Theme Scripts -->
<script src="../js/custom.min.js"></script>
<script src="//qiniu.jyblue.com/js/md5.js"></script>
<script src="//qiniu.jyblue.com/jquery.form.js"></script>
<script src="../js/common.js" type="text/javascript"></script>

<script>

    /*
     * 设置datatables初始化公共参数
     */
    var dtConfig = function(sAjaxSource,  fnServerParams,aoColumns, fnDrawCallback){
        return {
        	"searching": true,
            "bAutoWidth":false,
            "language": {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                //"sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoFiltered": "",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
            "processing" : true,//显示“处理中...”
            "bPaginate":true,
            "bServerSide": true,
            //每页显示10条数据
            "pageLength": 10,
            "lengthMenu": [
                [10, 15, 20],
                [10, 15, 20] // 更改每页显示记录数
            ],
            "bSort":true,
            "fnServerData":function ( sSource, aoData, fnCallback ) {
                //alert(rentRuleId);
                
                var map = {};  
		        for (var i = 0; i < aoData.length; i++) {  
	              var item = aoData[i];  
	              if (!map[item.name]) {  
	                  map[item.name] = item.value;  
	              }  
	            }
	            var pageNum = parseInt(map.iDisplayStart / map.iDisplayLength) + 1;
	            var pageSize = map.iDisplayLength;
	            aoData.push({'name':'pageNum','value':pageNum});
	            aoData.push({'name':'pageSize','value':pageSize});
	             
                $.ajax( {
                    type: "GET",
                    url: sSource,
                    dataType:"json",
                    //data: "jsonParam="+JSON.stringify(aoData)+"&isHistory=0&rentRuleId="+rentRuleId,
                    data: aoData, //以json格式传递
                    beforeSend: function () {
                        $("#loading").show();
                    },
                    complete:function(){
                        $("#loading").hide();
                    },
                    success: function(data) {
                        //$("#url_sortdata").val(data.aaData);
                        fnCallback(data); //服务器端返回的对象的returnObject部分是要求的格式
                    }, error: function(xhr, msg) {
                    	console.log(msg);
                    	if(isSessionTimeout(xhr)) // session失效
            	    		return;
                    }
                });
            },
            "sAjaxSource":sAjaxSource,
            "fnServerParams":fnServerParams,
            "aoColumns":aoColumns,
            "fnDrawCallback":fnDrawCallback,
            "aoColumnDefs" : [{  
		        "aTargets" :　["_all"],  
		        "fnCreatedCell" : function(td, cellData, rowData, row, col) {
		        	if(null == cellData)
		        		cellData = '';
		        	if($(td).hasClass('edittext')){ // 文字字段
                		td.innerHTML = "<span>" + cellData + "</span> <input type='text' autofocus='autofocus' value='" + cellData 
	                		+ "' style='display:none;' onclick='return false;'/> <a class='btn btn-xs btn-success' data-id='" + rowData.id + "' data-cell='" + col + "' onclick='saveInputMdf(this)' style='display:none;'>保存</a> <a class='btn btn-xs btn-danger' data-origin='" + cellData
	                		+ "' onclick='cnclMdf(this)' style='display:none;'>取消</a>";
	                		
	                	$(td).on('mousedown', function(e){
	                		getTextMdf(this);
	                	});
	                	
	                	/* td.innerHTML = "<span>" + cellData + "</span> <input type='text' autofocus='autofocus' value='" + cellData 
	                		+ "' style='display:none;' onclick='return false;'/>";
	                		
	                	$(td).on('mousedown', function(e){
	                		getTextMdf(this);
	                		
	                	});
	                	
	                	$(td).find('input').on('blur', function(e){
			                		cnclMdf(this);
			                }); */
	                	
	                	
                	}else if($(td).hasClass('editnum')){ // 数字字段
                		td.innerHTML = "<span>" + cellData + "</span> <input type='number' value='" + cellData 
	                		+ "' style='display:none;' onclick='return false;'/> <a class='btn btn-xs btn-success' data-id='" + rowData.id + "' data-cell='" + col + "' onclick='saveInputMdf(this)' style='display:none;'>保存</a> <a class='btn btn-xs btn-danger' data-origin='" + cellData
	                		+ "' onclick='cnclMdf(this)' style='display:none;'>取消</a>";
	                		
	                	$(td).click(function(e){
	                		getNumMdf(this);
	                	});
	                	
                	}else if($(td).hasClass('editdate')){ // 日期字段
                		td.innerHTML = "<span>" + cellData + "</span> <input type='text' class='data-mask' value='" + cellData 
	                		+ "' style='display:none;' onclick='return false;'/> <a class='btn btn-xs btn-success' data-id='" + rowData.id + "' data-cell='" + col + "'onclick='saveInputMdf(this)' style='display:none;'>保存</a> <a class='btn btn-xs btn-danger' onclick='cnclMdf(this)' style='display:none;'>取消</a>";
	                		
	                	$(td).click(function(e){
	                		getDateMdf(this);
	                	});
                	}else if($(td).hasClass('edittime')){ // 时间字段
                		td.innerHTML = "<span>" + cellData + "</span> <input type='text' class='data-mask' value='" + cellData 
	                		+ "' style='display:none;' onclick='return false;'/> <a class='btn btn-xs btn-success' data-id='" + rowData.id + "' data-cell='" + col + "'onclick='saveInputMdf(this)' style='display:none;'>保存</a> <a class='btn btn-xs btn-danger' onclick='cnclMdf(this)' style='display:none;'>取消</a>";
	                		
	                	$(td).click(function(e){
	                		$(td).find('input').focus();
	                		getTimeMdf(this);
	                	});
                	}else if($(td).hasClass('edittrans')){ // ID转换字段
                		var oldHtml = $(td).html();
	                	var optsId = $(td).find('input[type="hidden"]').attr('data-related');
	                	if(null == cellData)
			        		cellData = '';
			        		
		        		var dataList = JSON.parse($('.'+optsId).val());
                		var htmlStr = oldHtml + "<select data-cell='" + col + "' data-id='" + rowData.id + "' style='display:none'>";
                		for(var i in dataList){
                			if(rowData.rspLeaderId == dataList[i].optValue){
                				htmlStr += "<option value='" + dataList[i].optValue +  "' selected='selected'>" + dataList[i].optText + " </option>"
                			}else{
                				htmlStr += "<option value='" + dataList[i].optValue +  "'>" + dataList[i].optText + "</option>"
                			}
                		}
                		htmlStr += "</select>";
                		
                		$(td).html(htmlStr);
                		
                		var jqSelect = $(td).find('select');                		
                		jqSelect.on('click',function(e){
                			e.stopPropagation();
                			return false;
                		});
                		
                		jqSelect.on('change',function(e){
                			var r=confirm("确定修改选项？")
                			if (r==true){
                				saveSelectMdf(this);
                			}else{
                				var jqSpan = $(this).parent().find('span');
                				this.hide();
	                			jqSpan.show();
                			}
                		});
                		
                		jqSelect.on('blur', function(e){
	                		console.log('td blur');
                			$(this).parent().find('span').show();
	                		$(this).hide();
                		});
			        		
			        		
	                	$(td).on('click',function(e){
	                		var jqSpan = $(this).find('span');
	                		var jqSelect = $(this).find('select');
	                		jqSelect.show();
	                		jqSpan.hide();
	                	});
	                	
	                }
		        }
		    }]
            /* ,"createdRow": function( row, data, dataIndex ) {
                var rowHtml = $(row).html();
                console.log(data);
                rowHtml += "<input type='hidden' value='" + data + "'>"
                console.log(rowHtml);
            } */
        };
    }; 

    $(function () {
        $(".right_col").load("../ld_prj.html");
        
        $("#ld_prj").on("click","a",function () {
            $('.right_col').load('../ld_prj.html');
        });
        
        $('#rpsw').on('submit', function() {
        	var newPssd = $('#newpassword').val();
        
        	if(newPssd != $('#newpassword1').val()){
        		alert("两次输入的密码不一致");
        		return false;
        	}
        	
        	$('#oldpasswordInput').val(hex_md5($('#oldpassword').val()));
        	$('#newpasswordInput').val(hex_md5(newPssd));
        	
            $(this).ajaxSubmit({
                beforeSend: function () {
                    $("#wait").show();
                    $("#pswSubmit").attr({ disabled: "disabled" });
                },
                success: function(data,status,xhr) { // data 保存提交后返回的数据，一般为 json 数据
                	var ret;
                	if(typeof data == "string"){
                		if(data || data==""){ 
                			if(isSessionTimeout(xhr)) // session失效
                	    		return;
                			
               	         	alert("后台返回空数据，操作失败!");
               	         	return;
                		}
                		ret = eval("(" + data + ")");
                	}else if(typeof data=="object"){
                		ret = data;
                	}
                	
                     if(ret.code == 0)  {
                         $(':input','#rpsw') //初始化表单
                                 .not(':button, :submit, :reset, :hidden')
                                 .val('')
                                 .removeAttr('checked')
                                 .removeAttr('selected');
                         alert("修改密码成功！");
                         $('#myModal').modal('hide');
                     }
                     else {
                         alert(ret.error);
                     }

                },
                complete:function(){
                    $("#wait").modal('hide');
                    $("#pswSubmit").removeAttr("disabled");
                }
            });
            return false;
        });
        
        $(".right_col").css("minHeight",$(window).height()-$(".top_nav").height()-51);

    })
  
	
	//部分备注信息
	function getPartialRemarksHtml(remarks){
	      return remarks.substr(0, 10) + '&nbsp;&nbsp;<a href="javascript:void(0);" style="color:blue;"><b>更多</b></a>';
	}
	
	//全部备注信息
	function getTotalRemarksHtml(remarks){
	      return remarks + '&nbsp;&nbsp;<a href="javascript:void(0);" style="color:blue;">收起</a>';
	}
	
	// 改成文本输入框编辑修改模式
    function getTextMdf(obj){
    	$(obj).on('click', 'a', function(){
			return false;
		});
		
    	$(obj).find('span').hide();
		$(obj).find('input').show();
		$(obj).find('a').show();
		
    }
    
    // 改成数字输入框编辑修改模式
    function getNumMdf(obj){
    	/* var ctx = $(obj).parent().html();
		var row = $(obj).attr('data-row');
		var cell = $(obj).attr('data-cell');
		var dataOrigin = $(obj).attr('data-origin');
		var td = $(obj).parent();
		td.html("<input type='number' value='" + dataOrigin + "'/> <a class='btn btn-xs btn-success' data-row='" + row + "' data-cell='" + cell + "' onclick='saveInputMdf(this)'>保存</a> <a class='btn btn-xs btn-danger' data-origin='" + dataOrigin + "' data-row='" + row + "' data-cell='" + cell + "' onclick='cnclMdf(this)'>取消</a>");
		*/
		
		// var ctx = $(obj).find('span').html();
		// $(obj).html("<span style='display:none;'>" + ctx + "</span><input type='number' value='" + ctx + "'/> <a class='btn btn-xs btn-success' onclick='saveInputMdf(this)'>保存</a> <a class='btn btn-xs btn-danger' data-origin='" + ctx + "' onclick='cnclMdf(this)'>取消</a>");
		
		$(obj).on('click', 'a', function(){
			return false;
		});
		$(obj).find('span').hide();
		$(obj).find('input').show();
		$(obj).find('a').show();
    }
    
    // 改成日期输入框编辑修改模式
    function getDateMdf(obj){
    	/* var ctx = $(obj).parent().html();
		var row = $(obj).attr('data-row');
		var cell = $(obj).attr('data-cell');
		var dataOrigin = $(obj).attr('data-origin');
		var td = $(obj).parent();
		td.html("<input type='text' class='data-mask' value='" + dataOrigin + "'/> <a class='btn btn-xs btn-success' data-row='" + row + "' data-cell='" + cell + "' onclick='saveInputMdf(this)'>保存</a> <a class='btn btn-xs btn-danger' data-origin='" + dataOrigin + "' data-row='" + row + "' data-cell='" + cell + "' onclick='cnclMdf(this)'>取消</a>");
    	$(".data-mask").inputmask("y-m-d");
    	*/
    	
    	/* var ctx = $(obj).find('span').text();
		$(obj).html("<span style='display:none;'>" + ctx + "</span><input type='text' class='data-mask' value='" + ctx + "'/> <a class='btn btn-xs btn-success' onclick='saveInputMdf(this)'>保存</a> <a class='btn btn-xs btn-danger' data-origin='" + ctx + "' onclick='cnclMdf(this)'>取消</a>");
    	$(".data-mask").inputmask("y-m-d"); */
    	
    	$(obj).on('click', 'a', function(){
			return false;
		});
    	$(obj).find('span').hide();
		$(obj).find('input').show();
		$(obj).find('a').show();
    }
    
    // 改成时间输入框编辑修改模式
    function getTimeMdf(obj){
    	/* var ctx = $(obj).parent().html();
		var row = $(obj).attr('data-row');
		var cell = $(obj).attr('data-cell');
		var dataOrigin = $(obj).attr('data-origin');
		var td = $(obj).parent();
		td.html("<input type='text' class='time-mask' value='" + dataOrigin + "'/> <a class='btn btn-xs btn-success' data-row='" + row + "' data-cell='" + cell + "' onclick='saveInputMdf(this)'>保存</a> <a class='btn btn-xs btn-danger' data-origin='" + dataOrigin + "' data-row='" + row + "' data-cell='" + cell + "' onclick='cnclMdf(this)'>取消</a>");
    	$(".time-mask").inputmask("y-m-d h:m:s"); */
    	
    	/* var ctx = $(obj).find('span').html();
		$(obj).html("<span style='display:none;'>" + ctx + "</span><input type='text' class='data-mask' value='" + ctx + "'/> <a class='btn btn-xs btn-success' onclick='saveInputMdf(this)'>保存</a> <a class='btn btn-xs btn-danger' data-origin='" + ctx + "' onclick='cnclMdf(this)'>取消</a>");
    	$(".data-mask").inputmask("y-m-d h:m:s"); */
    	
    	$(obj).on('click', 'a', function(){
			return false;
		});
    	$(obj).find('span').hide();
		$(obj).find('input').show();
		$(obj).find('a').show();
    }
    
    // 单个输入字段更新
    function saveInputMdf(btn){ // 保存按钮
    	var col = $(btn).attr('data-cell');
    	var updId = $(btn).attr('data-id');
    	var oldCtx = $(btn).parent().find('span').val();
    	var mdfCtx = $(btn).parent().find('input').val();
    	var tObj = $(btn).parent().parent().parent().parent();
    	var updUrl = tObj.attr('data-upd') + "/" + updId;
    	var propName = $(btn.find('thead tr th')[col]).attr('name');
    	
    	var params = '{"' + propName + '":"' + mdfCtx + '"}';
    	
    	postUpdAjax(tObj, params, updUrl);
    }
    
    // 单个选项字段更新
    function saveSelectMdf(btn){ // 保存按钮
    	var mdfCtx = $(btn).parent().find('select').val();
    	var tObj = $(btn).parent().parent().parent().parent();
    	
    	var updId = $(btn).attr('data-id');
    	var updUrl = tObj.attr('data-upd') + "/" + updId;
    	
    	var col = $(btn).attr('data-cell');
    	var propName = $(tObj.find('thead tr th')[col]).attr('name');
    	var params = '{"' + propName + '":"' + mdfCtx + '"}';
    	
    	postUpdAjax(tObj, params, updUrl);
    }
    
    function postUpdAjax(tObj, params, updUrl){
    	$.ajax( {
            type: "POST",
            url: updUrl,
            dataType:"json",
            //data: "jsonParam="+JSON.stringify(aoData)+"&isHistory=0&rentRuleId="+rentRuleId,
            data: JSON.parse(params), //以json格式传递
            beforeSend: function () {
                $("#loading").show();
            },
            complete:function(){
                $("#loading").hide();
            },
            success: function(data) {
                console.log(data);
                alert(data.errorMsg);
                if(data.errorCode == 0){
                	tObj.dataTable().fnDraw(false);
                }
		
            }, error: function(xhr, msg) {
            	console.log(msg);
            	if(isSessionTimeout(xhr)) // session失效
    	    		return;
            }
        });
    }
    
    function cnclMdf(btn){
    	$(btn).parent().find('span').show();
		$(btn).parent().find('input').hide();
		$(btn).parent().find('a').hide();
	}
    

</script>
</body>


</html>