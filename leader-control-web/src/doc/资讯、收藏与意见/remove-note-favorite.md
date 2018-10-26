## 取消项目关注

## 接口地址 /remove-note-favorite/{id}

## 请求参数
* {id} 收藏编号，非空 int

## 返回结果
* errorCode	返回码，0为成功，其余为错误码 int
* errorMsg 提示信息 string

## 返回例子
<pre>
{
	"errorCode":0,
	"errorMsg":""
}
</pre>

## 错误码
* -404 您查询的会议纪要未关注！
* -405 会议纪要取消关注失败！
