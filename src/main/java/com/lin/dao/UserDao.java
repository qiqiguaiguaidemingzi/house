package com.lin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lin.bean.HouseInfo;
import com.lin.bean.User;
import com.lin.dto.CheckHouseState;

public interface UserDao {
	
	/**登录验证
	 * @param username 账号
	 * @param password 密码
	 * @return 匹配数量：0/1；
	 */
	User loginValidate(@Param("acc") String acc);
	
	/**注册账号
	 * @param user 用户基本信息
	 * @return 表示插入的行数，既是创建的数量：0/1；
	 */
	int registerAccount(@Param("user") User user );
	
	/**密码更改
	 * @param username 账号
	 * @param oldp	   旧密码
	 * @param newp	   新密码
	 * @return int 更新的行数：0/1；
	 */
	int psdChange(@Param("acc") String acc,@Param("oldp") String oldp,@Param("newp") String newp);
	
	/**注册出租房屋的信息（ps：此处用了自增主键，故不能用@Param注解，大坑！）
	 * @param houseInfo
	 * @return
	 */
	int lendHouse(HouseInfo houseInfo);
	
	/**上传房屋图片
	 * @param houseNum 通过主键房屋编号，找到对应的记录
	 * @param imgUrl  图片URL字符串
	 * @return
	 */
	int copyPicture(@Param("houseNum") int houseNum,@Param("imgUrl") String imgUrl);
	
	
	/** 返回当前用户的出租房屋列表
	 * @param acc
	 * @return
	 */
	List<CheckHouseState> getUserHouse(String acc);
	
	/**	用户申请下架房屋，将房屋的state变为3
	 * @param houseNum
	 * @return
	 */
	int userDropHouse(String houseNum);
}
