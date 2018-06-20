package com.lin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lin.bean.HouseInfo;
import com.lin.dto.Filter;
import com.lin.service.HouseService;

@Controller
public class HouseController {
	
	@Autowired
	private HouseService houseService;
	
	@RequestMapping(value="/init")
	@ResponseBody
	public List<HouseInfo> initHouse(){
		List<HouseInfo> list = houseService.initHouse();
		return list;
	}
	
	@RequestMapping(value="/filter")
	@ResponseBody
	public List<HouseInfo> filterBySelect(@RequestBody Filter option){
		List<HouseInfo> list = houseService.filterBySelect(option);
		return list;
	}
	
	@RequestMapping(value="/detail")
	@ResponseBody
	public HouseInfo houseDeatilMsg(@RequestBody String s){
		return houseService.houseDeatilMsg(s);
	}
	
	@RequestMapping(value="/search")
	@ResponseBody
	public List<HouseInfo> filterByWord(@RequestBody String word){
		return houseService.filterByWord(word);
	}

	
}
