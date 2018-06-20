package com.lin.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lin.bean.HouseInfo;
import com.lin.bean.User;
import com.lin.bean.UserCheck;
import com.lin.dao.UserDao;
import com.lin.dto.CheckHouseState;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	//账号登录验证
	public UserCheck Check(String acc,String psd){
		UserCheck uc = new UserCheck();
		User user = userDao.loginValidate(acc);
		if(user == null){
			uc.setAccCheck(false);
			uc.setPsdCheck(false);
			return uc; //账号不存在
		}else{
			if(psd.equals(user.getPsd())){
				uc.setAccCheck(true);
				uc.setPsdCheck(true);
				return uc;	//登录成功
			}else {
				uc.setAccCheck(true);
				uc.setPsdCheck(false);
				return uc;	//密码错误
			}
		}
	}
	
	//注册账号
	public boolean register(User user){
		int num = userDao.registerAccount(user);
		if(num == 1){
			return true;
		}else{
			return false;
		}
	}
	
	//账号密码更改
	public boolean psdChange(String acc,String oldp,String newp){
		int num = userDao.psdChange(acc, oldp, newp);
		if(num == 1){
			return true;
		}else{
			return false;
		}
	}
	
	//注册出租的房屋
	public boolean lendHouse(HouseInfo houseInfo,HttpServletRequest request){
		String acc = (String)request.getSession().getAttribute("acc");
		houseInfo.setAcc(acc);
		int num = userDao.lendHouse(houseInfo);
		if(num == 1){
			return true;
		}else{
			return false;
		}
		
	}
	
	//保存图片Url到数据库
	public boolean copyPicture(int houseNum, String imgUrl){
		int num = userDao.copyPicture(houseNum, imgUrl);
		if(num == 1){
			return true;
		}else{
			return false;
		}
	}
	
	//返回当前用户的出租房屋列表
	public List<CheckHouseState> getUserHouse(String acc){
		return userDao.getUserHouse(acc);
	}
	
	public boolean userDropHouse(String houseNum){
		int num = userDao.userDropHouse(houseNum);
		if(num == 1){
			return true;
		}else{
			return false;
		}
	}
	
}
