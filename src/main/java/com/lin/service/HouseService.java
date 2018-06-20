package com.lin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lin.bean.HouseInfo;
import com.lin.dao.HouseDao;
import com.lin.dto.Filter;

@Service
public class HouseService {
	
	@Autowired
	private HouseDao houseDao;
	
	public List<HouseInfo> initHouse(){
		List<HouseInfo> list = houseDao.initHouse();
		for (HouseInfo houseInfo : list) {
			if(houseInfo.getImgUrl() != null)
				houseInfo.setImgUrl("./assets/copy/" + houseInfo.getImgUrl().substring(0,29));  //13750004899  1523788144221  i.jpg 11+18
		}
		return list;
	}
	
	public List<HouseInfo> filterBySelect(Filter option){
		if(!option.getPrice().equals("any")){
			String[] price = option.getPrice().split("-"); 
			option.setOne(Integer.parseInt(price[0]));
			if(price.length > 1){
				option.setTwo(Integer.parseInt(price[1]));
			}else{
				option.setTwo(-1);
			}
		}
		if(!option.getArea().equals("any")){
			String[] area = option.getArea().split("-"); 
			option.setThree(Integer.parseInt(area[0]));
			if(area.length > 1){
				option.setFour(Integer.parseInt(area[1]));
			}else{
				option.setFour(-1);
			}
		}
		List<HouseInfo> list = houseDao.filterBySelect(option);
		for (HouseInfo houseInfo : list) {
			houseInfo.setImgUrl("./assets/copy/" + houseInfo.getImgUrl().substring(0,29));  //13750004899  1523788144221  i.jpg 11+18
		}
		
		return list;
	}
	
	
	public HouseInfo houseDeatilMsg(String houseNum){
		HouseInfo houseInfo = houseDao.houseDeatilMsg(houseNum);
		if(houseInfo.getImgUrl() != null){
			String[] imgs = houseInfo.getImgUrl().split(",");
			houseInfo.setHouseImg(imgs); 
			houseInfo.setImgUrl("");
		}
		return houseInfo;
	}
	
	public List<HouseInfo> filterByWord(String word){
		List<HouseInfo> list = houseDao.filterByWord(word);
		for (HouseInfo houseInfo : list) {
			if(houseInfo.getImgUrl() != null)
				houseInfo.setImgUrl("./assets/copy/" + houseInfo.getImgUrl().substring(0,29));  
		}
		return list;
	}
}
