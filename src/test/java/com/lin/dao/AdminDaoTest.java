package com.lin.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lin.bean.HouseInfo;
import com.lin.dto.AcceptUpMsg;
import com.lin.dto.HouseSimpleMsg;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class AdminDaoTest {
	
	@Autowired
	private AdminDao adminDao; 

	@Test
	public void testGetHireHouse() {
		List<HouseSimpleMsg> list = adminDao.getHireHouse(2);
		
		for (HouseSimpleMsg houseInfo : list) {
			System.out.println(houseInfo.toString());
		}
	}
	
	@Test
	public void testDropHouse(){
		adminDao.dropHouse("137");
	}
	
	@Test
	public void testHouseApplyUp(){
		AcceptUpMsg msg = new AcceptUpMsg();
		msg.setHouseNum("144");
		msg.setManager("yyy");
		adminDao.houseApplyUp(msg);
	}
	
	@Test
	public void testCancelApplyDrop(){
		adminDao.cancelApplyDrop("143");
	}

}
