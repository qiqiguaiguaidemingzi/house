package com.lin.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lin.bean.HouseInfo;
import com.lin.dto.Filter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class HouseDaoTest {

	@Resource
	private HouseDao houseDao;
	
	@Test
	public void testInitHouse() {
		List<HouseInfo> list = houseDao.initHouse();
		
		for (HouseInfo houseInfo : list) {
			houseInfo.setImgUrl(houseInfo.getImgUrl().substring(0,28));
			System.out.println(houseInfo.toString());
		}
		
	}
	
	@Test
	public void testFilterBySelect(){
		Filter f = new Filter();
		f.setPrice("3000-6000");
		f.setArea("100-");
		f.setType("any");
		
		if(!f.getPrice().equals("any")){
			String[] price = f.getPrice().split("-"); 
			f.setOne(Integer.parseInt(price[0]));
			if(price.length > 1){
				f.setTwo(Integer.parseInt(price[1]));
			}else{
				f.setTwo(-1);
			}
		}
		if(!f.getArea().equals("any")){
			String[] area = f.getArea().split("-"); 
			f.setThree(Integer.parseInt(area[0]));
			if(area.length > 1){
				f.setFour(Integer.parseInt(area[1]));
			}else{
				f.setFour(-1);
			}
		}
		
		
		List<HouseInfo> list = houseDao.filterBySelect(f);
		
		for (HouseInfo houseInfo : list) {
			System.out.println(houseInfo.toString());
		}
	}
	
	@Test
	public void testHouseDeatilMsg(){
		HouseInfo h = houseDao.houseDeatilMsg("127");
		System.out.println(h);
	}
	
	@Test
	public void testFilterByWord(){
		List<HouseInfo> list = houseDao.filterByWord("某某");
		for (HouseInfo houseInfo : list) {
			System.out.println(houseInfo.toString());
		}
	}

}
