package com.lin.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lin.bean.HouseInfo;
import com.lin.bean.User;
import com.lin.bean.UserCheck;
import com.lin.dto.CheckHouseState;
import com.lin.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/Login/Check")
	@ResponseBody
	public UserCheck Check(@RequestBody User user,HttpServletRequest request){  //账号登录验证
		UserCheck uc = userService.Check(user.getAcc(),user.getPsd());
		if(uc.isPsdCheck()){
			request.getSession().setAttribute("acc", user.getAcc());
		}
		return uc;
		
	}
	
	@RequestMapping(value="/Login/checkSession")
	@ResponseBody
	public boolean checkSession(HttpServletRequest request){		//是否已登录
		String acc = (String)request.getSession().getAttribute("acc");
		if(null != acc){
			return true;
		}else{
			return false;
		}
	}
	
	@RequestMapping(value="/Login/loginOut")
	@ResponseBody
	public boolean loginOut(HttpServletRequest request){		//退出登录
		request.getSession().removeAttribute("acc");
		return false;
	}
	
	@RequestMapping(value="/Register/Create")
	@ResponseBody
	public boolean register(@RequestBody User user){		//注册账号
		return userService.register(user);
	}
	
	@RequestMapping(value="/Login/PsdChange")
	@ResponseBody
	public boolean psdChange(@RequestBody Map<String,Object> map,HttpServletRequest request){		//账号密码更改
		String acc = (String)request.getSession().getAttribute("acc");
		String oldp = map.get("oldp").toString();
		String newp = map.get("newp").toString();
		if(acc == null)
			return false;
		return userService.psdChange(acc, oldp, newp);
	}
	
	@RequestMapping(value="/Login/lendHouse")
	@ResponseBody
	public boolean lendHouse(@RequestBody HouseInfo houseInfo,HttpServletRequest request){		//注册出租的房屋
		boolean b = userService.lendHouse(houseInfo, request);
		System.out.println(houseInfo.getHouseNum());
		request.getSession().setAttribute("houseNum", houseInfo.getHouseNum());
		return b;
	}
	
	
	
	@RequestMapping(value="/Login/picture")
	@ResponseBody
	public boolean copyPicture(@RequestParam("uploadFile") MultipartFile[] uploadFile,HttpServletRequest request){		//上传图片到服务器
		String acc = (String)request.getSession().getAttribute("acc");
		if(uploadFile != null && uploadFile.length > 0){
			String imgUrl = "";
			int houseNum = (Integer)request.getSession().getAttribute("houseNum");
    		try {
    			for(int i = 0; i < uploadFile.length;i++){
    			String FileName = acc + System.currentTimeMillis() + i + ".jpg";
				FileUtils.copyInputStreamToFile(uploadFile[i].getInputStream(), new File("G:/JAVA/javaworks/house/src/main/webapp/assets/copy/",FileName));
				imgUrl = imgUrl + FileName + ",";
    			}
    			imgUrl = imgUrl.substring(0, imgUrl.length()-1);
    			return userService.copyPicture(houseNum, imgUrl);
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
		return false;
	}
	
	@RequestMapping(value="/login/userHouse")
	@ResponseBody
	public List<CheckHouseState> getUserHouse(HttpServletRequest request){		//返回当前用户的出租房屋列表
		String acc = (String)request.getSession().getAttribute("acc");
		return userService.getUserHouse(acc);
	}
	
	@RequestMapping(value="login/applyDrop")
	@ResponseBody
	public void userDropHouse(@RequestBody String houseNum){		//用户申请下架房子
		userService.userDropHouse(houseNum);
	}
	
	
}






