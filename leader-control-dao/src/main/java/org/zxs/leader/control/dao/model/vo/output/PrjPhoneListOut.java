package org.zxs.leader.control.dao.model.vo.output;

import java.util.List;

/**
 * 项目通讯录组对象
 * @author Administrator
 *
 */
public class PrjPhoneListOut {
	private List<PhoneListOut> bookList;
	private List<ChatGroupBaseOut> cgList;
	
	public List<PhoneListOut> getBookList() {
		return bookList;
	}
	public void setBookList(List<PhoneListOut> bookList) {
		this.bookList = bookList;
	}
	public List<ChatGroupBaseOut> getCgList() {
		return cgList;
	}
	public void setCgList(List<ChatGroupBaseOut> cgList) {
		this.cgList = cgList;
	}
	
}
