## 添加会议纪要关注
#### 需添加授权请求头

## 接口地址 /add-note-favorite/{id}
#### POST

## 请求参数
* {id} 项目编号，非空 int

## 返回结果
* errorCode	返回码，0为成功，其余为错误码 int
* errorMsg 提示信息 string
* data 返回数据，为关注编号 int

## 返回例子
<pre>
{
	"errorCode":0,
	"errorMsg":""，
	"data":1001
}
</pre>

## 错误码
* -401 您查询的会议纪要编号不存在！
* -402 您已关注该会议纪要，不能重复关注！
* -403 收藏会议纪要失败！
