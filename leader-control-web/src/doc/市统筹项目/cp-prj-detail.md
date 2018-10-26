## 市统筹项目详情

## 接口地址 /cp-prj-detail/{id}
#### 返回值添加accmActualInvest、completeRateByYear、yearPrgList 2018-4-17

## 请求参数
* {id} 项目编号，非空 int

## 返回结果
*  id 项目编号 int
*  name 项目全称 string
*  planStatusDis 计划建设阶段释义 string
*  planInvestTotal 计划总投资，单位万元 int
*  yearPlanInvest 年度计划投资，单位万元 int
*  industryName 产业名 string
*  areaName 所属区域,多个以逗号分隔 string
*  areaAdminName 项目管理行政区域 string
*  content 建设内容 string
*  preContent 前一年建设内容 string
*  yearContent 年度计划建设内容 string
*  planStartMonth 计划开工月份 int
*  planEndMonth 计划竣工月份 int
*  remark 备注 string
*  remarkDisplay 需要展示的备注 string
*  labelArray 项目属性标签数组 array
*  ownerArray 业主单位数组 array
*  rspArray 责任单位数组 array
*  accmActualInvest 当年累计投资，单位万元 int
*  completeRateByYear 年度投资完成率 int
*  proveList 审批文件数组,类型按照字典表206顺序排列 array
    *  proveStatus 是否审批 boolean
    *  proveType 审批类型  string
    *  proveUrl 文件地址 string
*  attachmentList 会议纪要附件数组 array
    *  title 会议纪要标题 string
    *  name 会议纪要等附件名 string
    *  url 会议纪要等附件URL string
*  yearPrgList 年度建设进度数组 array
    *  year 年 int
    *  monthList 年数据 array
        *  month 月份 int
        *  accmPlanInvest2Month 当年至本月累计计划投资额，单位万元 int
        *  accmActualInvest2Month 当年至本月累计实际投资额，单位万元 int
        *  title 标题 string
        *  actualContentSub 简要内容，截取前40个字 string
        *  picUrl 图片地址，多张图片以逗号分隔 string
        *  issueContentSub 问题内容，截取前40个字 string
        *  proposalSub 意见和建议，截取前40个字 string
        *  actualUrl 页面地址 string

## 返回例子
<pre>
{
	"id":12345678,
	"name":"邕江综合整治和开发利用工程",
	"planStatusDis":"预备",
	"planInvestTotal":600000,
	"yearPlanInvest":200000,
	"industryName":"生态环保",
	"areaName":"南宁市",
	"areaAdminName":"市直",
	"preContent":"xxxxxxxxxxxxxxxxxxxxxx",
	"content":"包括邕江南岸（五象大道北兴斌沙场—三岸大桥）、北岸（邕江滨水公园东侧—三岸大桥）、南岸和北岸清川大桥-五象大桥段、托洲大桥-清川大桥段、三岸大桥-蒲庙大桥、老口枢纽-托洲大桥、蒲庙大桥-邕宁水利枢纽段综合整治、河岸岸坡加固防护、绿化工程、亮化等工程。",
	"yearContent":"完成自治区党校—三岸大桥、清川大桥—五象大桥、托洲大桥-清川大桥段、三岸大桥-蒲庙大桥、老口枢纽-托洲大桥、蒲庙大桥-邕宁水利枢纽段综合整治、河岸岸坡加固防护、绿化工程、亮化等工程建设。",
	"planStartMonth":1,
	"planEndMonth":12,
	"accmActualInvest":1000,
	"completeRateByYear":10,
	"remark":"",
	"remarkDisplay":"",
	"labelArray":["xxxx","ddddddddd"],
	"ownerArray":["xxxxxxx"],
	"rspArray":["xxxxxxxxxxxxx","xxxxxx"],
	"proveList":[
		{
			"proveType":"立项批复",
			"proveUrl":"xxx.html"
		}
	],
	"attachmentList":[
		{
			"title":"xxxxx",
			"name":"xxxxxx.pdf",
			"url":"xxxxxxxxxxxxxxxxxxxxxxx.pdf",
		}
	],
	"yearPrgList":[]
}
</pre>

## 错误码 - 无
