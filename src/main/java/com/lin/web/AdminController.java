package com.lin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lin.dto.AcceptUpMsg;
import com.lin.dto.HouseSimpleMsg;
import com.lin.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="/admin/HireHouse",method = RequestMethod.POST)
	@ResponseBody
	public List<HouseSimpleMsg> getHireHouse(@RequestBody int state){  //根据参数得到对应状态的房屋信息
		return adminService.getHireHouse(state);
	}
	
	@RequestMapping(value="/admin/drop",method = RequestMethod.POST)
	@ResponseBody
	public void dropHouse(@RequestBody String houseNum){	//根据房屋编号下架房屋
		adminService.dropHouse(houseNum);
	}
	
	@RequestMapping(value="/admin/up",method = RequestMethod.POST)
	@ResponseBody
	public void houseApplyUp(@RequestBody AcceptUpMsg msg){		//房屋申请上架
		adminService.houseApplyUp(msg);
	}
	
	@RequestMapping(value="/admin/cancelDrop",method = RequestMethod.POST)
	@ResponseBody
	public void cancelApplyDrop(@RequestBody String houseNum){		//拒绝房屋的下架申请
		adminService.cancelApplyDrop(houseNum);
	}
	
	
}
