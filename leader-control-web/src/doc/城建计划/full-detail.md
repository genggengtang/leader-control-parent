## 项目详情
#### 需添加授权请求头
#### 返回值中添加项目计划起止年限 2018-5-4

## 接口地址 /cb/full-detail/{id}

## 请求参数
* {id} 项目编号，非空 int
* year 计划进度年，对应折线图的年份选择，默认当前年 int

## 返回结果
* errorCode	返回码，0为成功，其余为错误码 int
* errorMsg 提示信息 string
* data object 返回数据
    *  id 项目编号 int
    *  name 项目全称 string
    *  cbFeatureDis 城建性质释义 string
    *  cbTypeDis 工程类型 string
    *  isFundPrj 是否经费开支项目，0为否，1为是 int
    *  labelArray 标签数组 array
    *  starNum 重点星数 int
    *  prjDbNo 项目库编号 string
    *  address 项目地址 string
    *  prjInvestTotal 项目计划总投资，单位万元 int
    *  planInvestTotal 当期计划总投资，单位万元 int
    *  prjStartYear 项目计划开始年份 int
    *  prjEndYear 项目计划结束年份 int
    *  planStartYear 本期计划开始年份 int
    *  planEndYear 本期计划结束年份 int
    *  planStartDate 计划开始日期，格式为"yyyy-MM-dd" date
    *  planEndDate 计划竣工日期，格式为"yyyy-MM-dd" date
    *  prjContent 主要建设规模及主要建设内容 string
    *  content 本期主要建设内容 string
    *  areaName 所属区域，多个区域以逗号分隔 int
    *  adminOrgName 主管单位,多个以逗号分隔 string
    *  remark 备注 string
    *  favoriteId 关注编号 int
    *  ownerList 业主集合 array
        *  orgName 业主单位名 string
        *  userName 业主负责人姓名 string
        *  mobilePhone 业主负责人联系手机号 string
    *  sourceFundList 资金源集合 array
        *  sourceName 资金来源名称 string
        *  sourceTypeName 资金来源分类名称 string
        *  planInvest 计划投资额，单位万元 int
        *  actualInvest 实际投资额，单位万元 int
        *  restInvest 未落实投资额，单位万元 int    
    
    *  lng 经度 double
    *  lat 纬度 double
    *  accmPlanInvest 当年至本月累计计划投资，单位万元 int
    *  accmActualInvest 当年至本月累计实际投资，单位万元 int
    *  completeRateByMonth 月度投资完成百分比 int
    *  completeRateByYear 年度投资完成百分比 int
    *  completeStatusDis 投资完成状态，即正常、超前、滞后、其他 string
    *  yearArray 年记录数组 array
    *  monthReportList 月度动态数组，升序排列 array
        *  month 月份 int
        *  accmPlanInvest2Month 当年至本月累计计划投资额，单位万元 int
        *  accmActualInvest2Month 当年至本月累计实际投资额，单位万元 int
        
    *  proveList 审批文件数组,类型按照字典表顺序排列 array
        *  proveStatus 是否审批 boolean
        *  proveType 审批类型  string
        *  proveUrl 文件地址 string
    
    *  issueList 协调事项数组 array
        *  year 年 int
        *  issueYearList 年数据 array
            *  month 月 int
            *  issueMonthList 每月协调事项内容 array
                *  issueId 编号 int
                *  title 标题 string
                *  issueType 问题类型 string
                *  issueDt 提出日期，格式为"yyyy-MM-dd" date
                *  action 解决措施 string
                *  attachmentName 会议纪要等附件名，多个以逗号分隔 string
                *  attachmentUrl 会议纪要等附件URL，多个以逗号分隔 string
    *  attachmentList 会议纪要附件数组 array
    	*  id 会议纪要编号 int
        *  title 会议纪要标题 string
        *  name 会议纪要等附件名 string
        *  url 会议纪要等附件URL string
        *  favoriteId 关注编号 int
    *  yearPrgList 年度建设进度数组 array
        *  year 年 int
        *  monthList 年数据 array
            *  month 月份 int
            *  accmPlanInvest2Month 当年至本月累计计划投资额，单位万元 int
            *  accmActualInvest2Month 当年至本月累计实际投资额，单位万元 int
            *  title 标题 string
            *  actualContentSub 简要内容，截取前40个字 string
            *  picUrl 图片信息，多张以逗号分隔 string
            *  picUrlArray 图片url数组 url 
            *  issueContentSub 问题内容，截取前40个字 string
            *  proposalSub 意见和建议，截取前40个字 string
            *  actualUrl 页面地址 string
    

## 返回例子
<pre>
{
	"errorCode":0，
	"errorMsg":"查询项目详情成功!",
	"data":{
		"id":12345678,
		"name":"邕江综合整治和开发利用工程",
		"cbFeatureDis":"预备",
		"cbTypeDis":"五象新区项目",
		"isFundPrj":0,
		"starNum":1,
		"labelArray":["60周年"],
		"prjDbNo":"2017-450114-48-01-900353",
		"prjInvestTotal":600000,
		"planInvestTotal":200000,
		"prjStartYear":2017,
		"prjEndYear":2017,
		"planStartYear":2017,
		"planEndYear":2017,
		"planStartDate":"2017-02-01",
		"planEndDate":"2017-12-31",
		"prjContent":"xxxxxxxxxxxxxxxxxxxxxxxxx",
		"content":"cccccccccccc",
		"areaName":"青秀区,兴宁区",
		"remark":"",
		"adminOrgName":"市发改委,市交通管理局"
		"favoriteId":null,
		"ownerList":[{
			"orgName":"市交警支队",
			"userName":"xxx",
			"mobilePhone":"13xxxxxxxxx"
		}],
		"sourceFundList":[{
			"sourceName":"市本级财政投资",
			"sourceTypeName":"市财政",
			"planInvest":500,
			"actualInvest":500,
			"restInvest":0
		}],
		"lng":103.2,
		"lat":23.1,
		"accmPlanInvest":200,
		"accmActualInvest":100,
		"completeRateByMonth":50,
		"completeRateByYear":20,
		"completeStatusDis":"正常",
		"yearArray":["2018","2017"],
		"monthReportList":[{
			"month":1,
			"accmPlanInvest2Month":6000,
			"accmActualInvest2Month":5800
		}],
		"proveList":[{
			"proveType":"立项批复",
			"proveUrl":"xxx.html"
		}],
		"issueList":[{
			"year":2017,
			"month":8,
			"issueMonthList":[
				{
					"title":"人行过街天桥项目建设问题",
					"issueType":"施工问题",
					"issueDt":"2017-08-25",
					"action":"adfkasdfjkahdfkl ajdfhajklsdfal sdk"，
					"attachmentName":"xxx会议纪要.pdf",
					"attachUrl":"aaaa.pdf"
				}
			]
		}],
		"attachmentList":[{
			"id":11,
			"title":"xxxxx",
			"name":"xxxxxx.pdf",
			"url":"xxxxxxxxxxxxxxxxxxxxxxx.pdf",
			"favoriteId":null
		}],
		"yearPrgList": [
       {
        "year": 2018,
        "monthList": [
	          {
	            "year": null,
	            "month": 2,
	            "title": "室内装饰基本完成，室外水泥土搅拌桩地基施工、挡土框架基础完成75%",
	            "actualContent": "1.室内楼地面完成75%，室内聚氨酯防水完成90% 。 2.屋面设备安装完成90%，配电房设备安装100%，电缆敷设完成90%，消防电气配线完成95%，竖梯、扶梯电梯调试完成30%，智能穿线完成95%，通风、防排烟风机安装完成70%，外立面照明施工完成60%，智能弱电间施工完成75%。 3.四层以上玻璃、铝板完成70%，内墙基板完成80%，吊杆完成90%，腻子施工完成80%。 4.室外水泥土搅拌桩地基施工完成75%，挡土框架基础完成75%。",
	            "actualContentSub": "1.室内楼地面完成75%，室内聚氨酯防水完成90% 。 2.屋面设备安装完成90",
	            "picUrl": "http://p53wzuaxq.bkt.clouddn.com/jpg/%E5%8D%97%E5%AE%81%E5%B8%82%E5%9B%BE%E4%B9%A6%E9%A6%8611.jpg,http://p53wzuaxq.bkt.clouddn.com/jpg/%E5%8D%97%E5%AE%81%E5%B8%82%E5%9B%BE%E4%B9%A6%E9%A6%8612.jpg,http://p53wzuaxq.bkt.clouddn.com/jpg/%E5%8D%97%E5%AE%81%E5%B8%82%E5%9B%BE%E4%B9%A6%E9%A6%8613.jpg",
	            "picUrlMap":{
		            "http://p53wzuaxq.bkt.clouddn.com/jpg/%E5%8D%97%E5%AE%81%E5%B8%82%E5%9B%BE%E4%B9%A6%E9%A6%8611.jpg":"aaaa", 
		            "http://p53wzuaxq.bkt.clouddn.com/jpg/%E5%8D%97%E5%AE%81%E5%B8%82%E5%9B%BE%E4%B9%A6%E9%A6%8612.jpg":"bbbb",
		            "http://p53wzuaxq.bkt.clouddn.com/jpg/%E5%8D%97%E5%AE%81%E5%B8%82%E5%9B%BE%E4%B9%A6%E9%A6%8613.jpg":"cccc" 
				},
	            "issueContent": "",
	            "issueContentSub": "",
	            "proposal": "",
	            "proposalSub": "",
	            "actualUrl": "http://p53wzuaxq.bkt.clouddn.com/html/%E5%8D%97%E5%AE%81%E5%9B%BE%E4%B9%A6%E9%A6%86.html",
	            "accmPlanInvest2Month": 6106,
	            "accmActualInvest2Month": 3514
	          }
	        ]
	   }]
	}
}
</pre>

## 错误码
* -203 您查询的项目编号不存在！
* -204 您查询的用户编号不存在！
