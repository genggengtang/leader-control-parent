## 取消项目关注

## 接口地址 /prj-favorite-remove/{id}

## 请求参数
* {id} 关注编号，非空 int

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
* -208 您查询的关注编号不存在！
* -209 项目取消关注失败！
