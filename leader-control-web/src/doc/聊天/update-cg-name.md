## 更改群聊组名字
#### 需添加授权请求头

## 接口地址 /update-cg-name/{id}
#### POST

## 请求参数
* {id} 群组编号，非空 int
* name 修改后的名字，非空 string

## 返回结果
* errorCode	返回码，0为成功，其余为错误码 int
* errorMsg 提示信息 string
* data 返回更改后群名 string

## 返回例子
<pre>
{
	"errorCode":0,
	"errorMsg":"更改群组名字成功！",
	"data":"xxxx"
}
</pre>

## 错误码
* -303 权限不足！
* -304 该聊天群组可能已解散！
* -313 修改的名字不能超过100字！
* -314 更改聊天群组名称失败！
