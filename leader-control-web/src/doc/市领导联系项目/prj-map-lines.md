## 项目地图线详情
#### 请求参数添加prjType 2018-4-19

## 接口地址 /prj-map-lines/{id}

## 请求参数
* {id} 项目编号,非空 int
* prjType 项目类型，对应字典表214字段，默认21401 int

## 返回结果
* planStatusDis 计划建设阶段释义 string
* completeStatusDis 投资完成状态，即正常、超前、滞后、其他 string
* lineList 返回数据数组 array
    *  lineId 线编号 int
    *  pointList 地图点字符串集合
        *  lng 经度 decimal
        *  lat 纬度 decimal


## 返回例子
<pre>
{
	"planStatusDis":"竣工投产",
	"completeStatusDis":"正常",
	"lineList":
	[
		{
			"lineId":12345678,
			"pointList":[
				{"lnt":107.25,"lat":22.5},
				{"lnt":102.35,"lat":23.1}
			]
		}
	]
}
</pre>

## 错误码 - 无
