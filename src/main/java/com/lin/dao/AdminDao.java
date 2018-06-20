package com.lin.dao;

import java.util.List;

import com.lin.dto.AcceptUpMsg;
import com.lin.dto.HouseSimpleMsg;

public interface AdminDao {
	
	/** 得到已上架状态的房屋信息
	 * @return
	 */
	public List<HouseSimpleMsg> getHireHouse(int state);
	
	/** 根据房屋编号下架房屋
	 * @param houseNum
	 */
	public void dropHouse(String houseNum);
	
	/**	房屋申请上架
	 * @param msg	房屋编号，处理的经纪人
	 * @return update更新影响的行数，0为失败，1为成功
	 */
	public int houseApplyUp(AcceptUpMsg msg);
	
	/** 拒绝房屋的下架申请
	 * @param houseNum 房屋的编号
	 * @return
	 */
	public int cancelApplyDrop(String houseNum);
}
