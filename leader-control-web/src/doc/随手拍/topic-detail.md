## 随手拍详情
#### 将本人在该主题下所有评论记录的状态都改为已读
#### 评论按时间降序排列
#### 需添加授权请求头
#### 返回数据添加receiveUserList、isAuthor、isNewGroup、receiveUserNames、receiveUserNamesSub 2018-6-29

## 接口地址 /topic-detail/{id}

## 请求参数
* {id} 随手拍编号，非空 int

## 返回结果
*  errorCode 返回码，0为成功，其余为错误码 int
*  errorMsg 提示信息 string
*  data 返回数据
    *  id 随手拍编号 int
    *  sendUserName 发送者名称 string
    *  receiveUserList 主题发送对象集合 array
    *  receiveUserNames 主题发送所有对象名称 string
    *  receiveUserNamesSub 主题发送对象简称，只显示前5人 string
    *  receiveCgName 接收群组名称 string
    *  content 内容 string
    *  picUrl 图片地址 string
    *  createAt 创建时间，格式为"yyyy-mm-dd hh:MM:ss" date
    *  isAuthor 是否主题发送者，0为否，1为是 int
    *  isNewGroup 发送对象是否多人，0为否，即对象为群聊组，1为是 int
    *  commentNum 总评论数 int
    *  commentList 评论列表 array
        *  id 评论编号 int
        *  commentUserName 评论者名称 string
        *  content 评论内容 string
        *  createAt 评论时间，格式为"yyyy-mm-dd hh:MM:ss" date

## 返回例子
<pre>
{
	"errorCode":0,
	"errorMsg":"",
	"data":
	{
		"id":12345678,
		"sendUserName":"xxxxxx",
		"receiveCgName":"yyyyyyyy",
		"content":"zzzzzzzzzzzzzzzzzzzzzzzzz",
		"picUrl":"http://aaaaaaaaaa.jpg",
		"createAt":"2018-06-20 10:10:12",
		"commentNum":"1,
		"receiveUserList":["dfgdfg","dafa"],
		"isAuthor":0,
		"isNewGroup": 0,
		"receiveUserNamesSub": "dfgdfg,dafa",
		"commentList":
		[{
			"id":12312312,
			"commentUserName":"ccc",
			"content":"uuuuuuuuu",
			"createAt":"2018-06-20 10:15:12"
		}]
	}
}
</pre>

## 错误码
* -323 随手拍主题不存在或已被作者删除！
