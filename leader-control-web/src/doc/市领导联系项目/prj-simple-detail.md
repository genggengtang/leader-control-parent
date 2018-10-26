## 项目摘要详情
#### 需添加授权请求头 2018-3-20
#### 在返回结果中添加责任单位联系人集合rspContactList 2018-3-21
#### 添加现场联系人返回directList 2018-4-11

## 接口地址 /prj-simple-detail/{id}

## 请求参数
* {id} 项目编号,非空 int

## 返回结果
* errorCode	返回码，0为成功，其余为错误码 int
* errorMsg 提示信息 string
* data object 返回数据
    *  id 项目编号 int
    *  fullName 项目全称 string
    *  shortName 项目简称 string
    *  type 服务类别，如2代表2星 int
    *  planStatusDis 计划建设阶段释义 string
    *  is60thWelfare 是否60周年公益项目 int
    *  isPrvcPlan 是否区统筹项目 int
    *  totalPlanInvest 计划总投资，单位万元 int
    *  yearPlanInvest 年度计划投资，单位万元 int
    *  groupName 服务队名称 string
    *  rspLeaderName 负责领导人姓名 string
    *  contactLeaderName 联系领导人姓名 string
    *  contactName 牵头单位联系人姓名 string
    *  contactPhone 牵头单位联系人手机号，当此联系人级别高于查询用户，隐藏中间四位数字 string
    *  contactOrgName 牵头单位名称 string
    *  industryName 产业名 string
    *  areaName 所属区域 string
    *  content 建设内容 string
    *  yearContent 年度计划建设内容 string
    *  remark 备注 string
    *  remarkDisplay 需要展示的备注 string
    *  isOwner 是否本人负责项目 boolean
    *  favoriteId 关注编号 int
    *  ownerList 业主集合 array
        *  orgName 业主单位名 string
        *  userName 业主负责人姓名 string
        *  mobilePhone 业主负责人联系手机号 string
    *  rspContactList 责任单位联系人数组 array
        *  orgName 责任单位名 string
        *  userName 责任单位负责人姓名 string
        *  mobilePhone 联系手机号 string
    *  directList 现场联系人集合 array
        *  orgName 单位名 string
        *  userName 现场联系人姓名 string
        *  mobilePhone 现场联系人手机号 string

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
		"yearPlanInvest":200000,
		"groupName":"第一服务队",
		"rspLeaderName":"张文军",
		"contactLeaderName":"赵红明",
		"contactName":"陈胜",
		"contactPhone":13xxxxxxxxxx,
		"contactOrgName":"市城乡建委",
		"industryName":"生态环保",
		"areaName":"南宁市",
		"content":"包括邕江南岸（五象大道北兴斌沙场—三岸大桥）、北岸（邕江滨水公园东侧—三岸大桥）、南岸和北岸清川大桥-五象大桥段、托洲大桥-清川大桥段、三岸大桥-蒲庙大桥、老口枢纽-托洲大桥、蒲庙大桥-邕宁水利枢纽段综合整治、河岸岸坡加固防护、绿化工程、亮化等工程。",
		"yearContent":"完成自治区党校—三岸大桥、清川大桥—五象大桥、托洲大桥-清川大桥段、三岸大桥-蒲庙大桥、老口枢纽-托洲大桥、蒲庙大桥-邕宁水利枢纽段综合整治、河岸岸坡加固防护、绿化工程、亮化等工程建设。",
		"remark":"",
		"remarkDisplay":"",
		"isOwner":true,
		"favoriteId":1001,
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
	}
}
</pre>

## 错误码
* -203 您查询的项目编号不存在！
* -204 您查询的用户编号不存在！
