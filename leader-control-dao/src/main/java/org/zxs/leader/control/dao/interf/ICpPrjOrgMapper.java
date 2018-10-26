package org.zxs.leader.control.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.leader.control.dao.model.CpPrjOrg;
import org.zxs.leader.control.dao.model.vo.output.PrcSearchOut;
import org.zxs.leader.control.dao.model.vo.output.PrjContactOut;
import org.zxs.leader.control.dao.model.vo.output.rows.CpPrjOrgRow;

import tk.mybatis.mapper.common.Mapper;

public interface ICpPrjOrgMapper extends Mapper<CpPrjOrg> {

	/**
	 * 根据关键字查询城建项目业主信息
	 * @param nameLike
	 * @param planNo 
	 * @param isKeyPrj 
	 * @return
	 */
	List<PrcSearchOut> selectPrjOwnerByNameLike(@Param("nameLike")String nameLike, @Param("planNo")Integer planNo, @Param("isKeyPrj")Integer isKeyPrj);

	/**
	 * 根据项目编号及类型，获取业主信息
	 * @param id
	 * @param prjType
	 * @return
	 */
	List<PrjContactOut> selectOwnerListByIdAndPrjType(@Param("id")int id, @Param("prjType")int prjType);
	
	/**
	 * 根据用户、城建项目编号查询用户与项目关系
	 * @param userId
	 * @param prjId
	 * @return
	 */
	int selectCountByUserAndPrj(@Param("userId")int userId, @Param("prjId")int prjId);
	
	/**
	 * 
	* @Title: selectAllOuts 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<CpPrjOrgRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午5:00:26
	 */
	List<CpPrjOrgRow> selectAllOuts();

	/**
	 * 
	* @Title: selectRowsByKeyword 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param keyword
	* @param @return  参数说明 
	* @return List<CpPrjOrgRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月27日 下午3:17:50
	 */
	List<CpPrjOrgRow> selectRowsByKeyword(String keyword);

}