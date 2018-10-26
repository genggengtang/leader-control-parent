package org.zxs.leader.control.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.leader.control.dao.model.PrjProve;
import org.zxs.leader.control.dao.model.vo.output.PrjAttachmentOut;
import org.zxs.leader.control.dao.model.vo.output.PrjProveOut;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjProveRow;

import tk.mybatis.mapper.common.Mapper;

public interface IPrjProveMapper extends Mapper<PrjProve> {
	
	/**
	 * 根据项目编号获取审批信息
	 * @param prjId
	 * @return
	 */
    List<PrjProveOut> selectByPrjId(@Param("prjId")int prjId, @Param("prjType")int prjType);
    
    /**
     * 根据编号获取附件信息
     * @param ids
     * @return
     */
    List<PrjAttachmentOut> selectAttamentMap(@Param("ids")String ids);

    /**
     * 
    * @Title: selectAllOuts 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @return  参数说明 
    * @return List<PrjProveRow>    返回类型 
    * @throws 
    * @author weiqingwen
    * @date 2018年7月19日 下午3:21:50
     */
	List<PrjProveRow> selectAllOuts();

	/**
	 * 
	* @Title: selectRowsByKeyword 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param keyword
	* @param @return  参数说明 
	* @return List<PrjProveRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月23日 上午9:40:54
	 */
	List<PrjProveRow> selectRowsByKeyword(String keyword);
    
}