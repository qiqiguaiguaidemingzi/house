package com.lin.dao;

import java.util.List;

import com.lin.bean.HouseInfo;
import com.lin.dto.Filter;

public interface HouseDao {
	
	/** 主页面的房屋列表
	 * @return 
	 */
	public List<HouseInfo> initHouse();
	
	/** 根据前端传来的筛选数组，选出符合条件的
	 * @param option
	 * @return 
	 */
	public List<HouseInfo> filterBySelect(Filter option);
	
	/** 通过房屋编号，得到相应的房屋信息
	 * @param houseNum
	 * @return
	 */
	public HouseInfo houseDeatilMsg(String houseNum);
	
	/** 通过搜索框的关键字，搜索名称和地址匹配的房屋
	 * @param word
	 * @return
	 */
	public List<HouseInfo> filterByWord(String word);
}
