package com.lin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lin.bean.HouseInfo;
import com.lin.dao.AdminDao;
import com.lin.dto.AcceptUpMsg;
import com.lin.dto.HouseSimpleMsg;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	public List<HouseSimpleMsg> getHireHouse(int state){
		List<HouseSimpleMsg> list = adminDao.getHireHouse(state);
		return list;
	}
	
	public void dropHouse(String houseNum){
		adminDao.dropHouse(houseNum);
	}
	
	public boolean houseApplyUp(AcceptUpMsg msg){
		int num = adminDao.houseApplyUp(msg);
		if(num == 1){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean cancelApplyDrop(String houseNum){
		int num = adminDao.cancelApplyDrop(houseNum);
		if(num == 1){
			return true;
		}else{
			return false;
		}
	}
}
