
<style>
    input {border: 1px solid #ABABAB;}
    .ldPrjMdfTip input{padding: 6px 3px;border-radius: 5px;height: 25px;width: 100%;}
    .ldPrjMdfTip select{padding: 0 3px;border-radius: 5px;height: 25px;width: 100%;}
    .ldPrjMdfTip{margin-top: 10px;line-height: 25px;}
    .ldPrjMdfTip i{line-height: 25px;}
    .ldPrjMdfControl{text-align: center;margin-top: 20px;}
    .ldPrjMdfControl button{padding: 3px;border-radius: 5px;width: 20%;}
    .ldPrjMdfControl input{padding: 3px;border-radius: 5px;width: 20%;margin-left: 5%;}
</style>

<div class="AddArea container-fluid">	
    <div class="row">
	    <div class="addTitle">
	        <h2>修改市领导联系项目</h2>
	    </div>
	
	     <div class="info-name">
          <label>编号：</label>
          <input type="text" class="text" value="${detail.id}">
        </div>
        <div class="info-tel">
          <label>项目全名：</label>
          <input type="text" class="text" value="${detail.fullName}">
        </div>
        <div class="info-org">
          <label>单位：</label>
          <input type="text" class="text" value="${reporter.orgName}">
        </div>
	
	     <div class="ldPrjMdfControl col-xs-12 col-md-8">
	         <input class="btn btn-success pull-left" value="提交">
	         <input type="button" class="btn btn-danger pull-left" onclick="$('.right_col').load('ld_prj.html');" value="取消">
	     </div>

    </div>


</div>

<script>  

 /* $('#ldPrjMdfForm').on('submit', function() {     

     $('#ldPrjMdfForm').ajaxSubmit({
         url:'sms-user-update-information/',
    	 success: function(data) { // data 保存提交后返回的数据，一般为 json 数据
             if(typeof(data)=="object"){

                 if(data.code == 0)  {
                	 alert('修改市领导联系项目信息成功！');
                    $(".right_col").load("ld_prj.html");
                 }
                 else {
                     alert(data.error);
                 }
             }

         }

     });
    }); */
    
    $(function() {
      
      
    });
    
</script>