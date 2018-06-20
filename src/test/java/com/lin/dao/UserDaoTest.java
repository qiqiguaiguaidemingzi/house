package com.lin.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lin.bean.HouseInfo;
import com.lin.bean.User;
import com.lin.dto.CheckHouseState;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class UserDaoTest {
	
	@Resource
	private UserDao userDao;

	@Test
	public void testLoginValidate() {
		User user = userDao.loginValidate("04151502");
		System.out.println(user.toString());
	}

	@Test
	public void testRegisterAccount() {
		User user = new User();
		user.setAcc("04151501");
		user.setPsd("123");
		user.setRealName("无名");
		user.setEmail("1111111111@qq.com");
		int num = userDao.registerAccount(user);
		System.out.println(num);
	}

	@Test
	public void testPsdChange() {
		int num = userDao.psdChange("04151501", "123", "111");
		System.out.println(num);
	}
	
	@Test
	public void testLendHouse(){
		HouseInfo houseInfo = new HouseInfo();
		houseInfo.setAcc("04151502");
		houseInfo.setAddress("广东省汕头市潮阳区");
		houseInfo.setArea("100");
		houseInfo.setHouseName("高楼大厦");
		houseInfo.setMessage("我不想说什么");
		houseInfo.setPrice("100000");
		houseInfo.setType("九房九厅");
		int num = userDao.lendHouse(houseInfo);
		System.out.println(houseInfo.getHouseNum());
	}
	
	@Test
	public void testGetUserHouse(){
		List<CheckHouseState> list = userDao.getUserHouse("13750033195");
		for (CheckHouseState checkHouseState : list) {
			System.out.println(checkHouseState.toString());
		}
	}
	
	@Test
	public void testUserDropHouse(){
		userDao.userDropHouse("142");
	}

}
