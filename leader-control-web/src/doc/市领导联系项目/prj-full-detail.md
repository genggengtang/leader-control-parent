## 项目详情
#### 需添加授权请求头 2018-3-20
#### 返回结果添加经纬度坐标 2018-3-21
#### 返回结果添加年度/月度建设进度集合 2018-3-27
#### 添加现场联系人返回directList 2018-4-11
#### 返回结果中添加monthReportMap,同时yearPrgList返回值中，添加picUrlArray 2018-4-18
#### 请求参数中添加year，返回结果中添加yearArray 2018-4-19
#### 会议纪要添加id返回 2018-4-21
#### 添加actualCompletionStatus项目实际竣工状态字段（String） 2018-9-4

## 接口地址 /prj-full-detail/{id}

## 请求参数
* {id} 项目编号，非空 int
* year 计划进度年，对应折线图的年份选择，默认当前年 int

## 返回结果
* errorCode	返回码，0为成功，其余为错误码 int
* errorMsg 提示信息 string
* data object 返回数据
    *  id 项目编号 int
    *  fullName 项目全称 string
    *  shortName 项目简称 string
    *  lng 经度 decimal
    *  lat 纬度 decimal
    *  type 服务类别，如2代表2星 int
    *  planStatusDis 计划建设阶段释义 string
    *  actualStatusDis 实际建设阶段释义 string
    *  is60thWelfare 是否60周年公益项目 int
    *  isPrvcPlan 是否区统筹项目 int
    *  totalPlanInvest 计划总投资，单位万元 int
    *  totalActualInvest 实际总投资，单位万元 int
    *  yearPlanInvest 年度计划投资，单位万元 int
    *  groupName 服务队名称 string
    *  rspLeaderName 负责领导人姓名 string
    *  contactLeaderName 联系领导人姓名 string
    *  contactName 牵头单位联系人姓名 string
    *  contactPhone 牵头单位联系人手机号 string
    *  contactOrgName 牵头单位名称 string
    *  industryName 产业名 string
    *  areaName 所属区域 string
    *  content 建设内容 string
    *  yearContent 年度计划建设内容 string
    *  remark 备注 string
    *  remarkDisplay 需要展示的备注 string
    *  isOwner 是否本人负责项目 boolean
    *  isFavorite 是否本人收藏项目 boolean
    *  favoriteId 关注编号 int
    *  ownerList 业主集合 array
        *  orgName 业主单位名 string
        *  userName 业主负责人姓名 string
        *  mobilePhone 业主负责人联系手机号 string

    *  accmPlanInvest 当年至本月累计计划投资，单位万元 int
    *  accmActualInvest 当年至本月累计实际投资，单位万元 int
    *  completeRateByMonth 月度投资完成百分比 int
    *  completeRateByYear 年度投资完成百分比 int
    *  seasonChar 季度号，值为一、二、三、四 string
    *  seasonPlanInvest 当季度计划投资，单位万元 int
    *  seasonPlanContent 当季度计划内容 string
    *  completeStatusDis 投资完成状态，即正常、超前、滞后、其他 string

    *  rspContactList 责任单位联系人数组 array
        *  orgName 责任单位名 string
        *  userName 责任单位负责人姓名 string
        *  mobilePhone 联系手机号 string
        
    *  directList 现场联系人集合 array
        *  orgName 单位名 string
        *  userName 现场联系人姓名 string
        *  mobilePhone 现场联系人手机号 string
    *  proveList 审批文件数组,类型按照字典表顺序排列 array
        *  proveStatus 是否审批 boolean
        *  proveType 审批类型  string
        *  proveUrl 文件地址 string
        *  attamentList 审批文件集合 array
            *  proveName 文件名 string
            *  proveUrl 文件URL string
        
    *  monthReportList 月度动态数组，升序排列 array
        *  month 月份 int
        *  accmPlanInvest2Month 当年至本月累计计划投资额，单位万元 int
        *  accmActualInvest2Month 当年至本月累计实际投资额，单位万元 int
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
    *  monthReportMap 月度动态集合,key为年份，value为当年每个月进度数组 map
        *  month 月份 int
        *  accmPlanInvest2Month 当年至本月累计计划投资额，单位万元 int
        *  accmActualInvest2Month 当年至本月累计实际投资额，单位万元 int
    *  yearArray 年记录数组 array
    *  actualCompletionStatus 实际完成情况 string - 已完成返回“已竣工”，未完成返回null

## 返回例子
<pre>
{
	"errorCode":0，
	"errorMsg":"查询项目详情成功!",
	"data":{
		"id":12345678,
		"fullName":"邕江综合整治和开发利用工程",
		"lng":103.5,
		"lat":22.15,
		"type":1,
		"planStatusDis":"预备",
		"is60thWelfare":1,
		"isPrvcPlan":0,
		"totalPlanInvest":600000,
		"totalActualInvest":600000,
		"yearPlanInvest":200000,
		"groupName":"第一服务队",
		"rspLeaderName":"张文军",
		"contactLeaderName":"赵红明",
		"contactName":"陈文胜",
		"contactPhone":13xxxxxxxxx,
		"contactOrgName":"市城乡建委",
		"industryName":"生态环保",
		"areaName":"南宁市",
		"content":"包括邕江南岸（五象大道北兴斌沙场—三岸大桥）、北岸（邕江滨水公园东侧—三岸大桥）、南岸和北岸清川大桥-五象大桥段、托洲大桥-清川大桥段、三岸大桥-蒲庙大桥、老口枢纽-托洲大桥、蒲庙大桥-邕宁水利枢纽段综合整治、河岸岸坡加固防护、绿化工程、亮化等工程。",
		"yearContent":"完成自治区党校—三岸大桥、清川大桥—五象大桥、托洲大桥-清川大桥段、三岸大桥-蒲庙大桥、老口枢纽-托洲大桥、蒲庙大桥-邕宁水利枢纽段综合整治、河岸岸坡加固防护、绿化工程、亮化等工程建设。",
		"remark":"",
		"remarkDisplay":"",
		"isOwner":true,
		"favoriteId":1001,
		"actualStatusDis":"预备",
		"accmPlanInvest":5000,
		"accmActualInvest":4500,
		"completeRateByMonth":90,
		"completeRateByYear":23,
		"seasonChar":"一",
		"seasonPlanInvest":3000,
		"seasonPlanContent":"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
		"ownerList":[
			{
				"orgName":"建宁水务集团（金水建设公司）",
				"userName":"陈胜",
				"mobilePhone":13xxxxxxxxxx
			}
		],
		"rspContactList":[
			{
				"orgName":"市邕江北岸公园",
				"userName":"李xx",
				"mobilePhone":13xxxxxxxxxx
			}
		],
		"directList":[
			{
				"orgName":"市邕江北岸公园",
				"userName":"李xx",
				"mobilePhone":13xxxxxxxxxx
			}
		],
		"proveList":[
			{
				"proveType":"立项批复",
				"attamentList": [
		          {
		            "proveName": "江北引水干渠--批复--立项批复（南环建字【2011】365号）",
		            "proveUrl": "xxxxxx.pdf"
		          }
		        ]
			}
		],
		"monthReportList":[
			{
				"month":1,
				"accmPlanInvest2Month":6000,
				"accmActualInvest2Month":5800
			}
		],
		"issueList":[
		{
			"year":17,
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
		"attachmentList":[
			{
				"id":11,
				"title":"xxxxx",
				"name":"xxxxxx.pdf",
				"url":"xxxxxxxxxxxxxxxxxxxxxxx.pdf",
				"favoriteId":null
			}
		],
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
	},
	"yearArray":["2018","2017"]
	},
	"actualCompletionStatus": "已竣工"
}
</pre>

## 错误码
* -203 您查询的项目编号不存在！
* -204 您查询的用户编号不存在！
