package org.zxs.leader.control.service.interf;

import org.zxs.leader.control.dao.model.PrjAttachment;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjAttachmentRow;

import com.github.pagehelper.PageInfo;

public interface IPrjAttachmentService {
	
	/**
	 * 
	* @Title: getPrjAttachmentOutsByPage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @param keyword
	* @param @return  参数说明 
	* @return PageInfo<PrjAttachmentRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月1日 上午9:11:15
	 */
	PageInfo<PrjAttachmentRow> getPrjAttachmentOutsByPage(Integer pageNum, Integer pageSize, String keyword);
	
	/**
	 * 
	* @Title: findById 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param id
	* @param @return  参数说明 
	* @return PrjAttachment    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月1日 上午9:11:21
	 */
	PrjAttachment findById(Integer id);
	
	/**
	 * 
	* @Title: insert 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prjAttachment
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月1日 上午9:11:31
	 */
	int insert(PrjAttachment prjAttachment);
	
	/**
	 * 
	* @Title: update 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prjAttachment
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月1日 上午9:11:39
	 */
	int update(PrjAttachment prjAttachment);
	
	/**
	 * 
	* @Title: insertWithResult 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param record
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月9日 上午11:53:37
	 */
	String insertWithResult(PrjAttachment record);

}
