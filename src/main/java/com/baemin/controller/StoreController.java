package com.baemin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baemin.dto.FoodOption;
import com.baemin.dto.Store;
import com.baemin.service.StoreService;
import com.baemin.store.StoreDetail;

@Controller
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@GetMapping("/store/{category}/{address1}")
	public String store(@PathVariable int category, @PathVariable int address1, Model model) {
		
		List<Store> storeList = storeService.storeList(category, address1 / 100);
		model.addAttribute("storeList", storeList);
		return "store/store";
	}
	
	@GetMapping("/store/detail/{id}")
	public String storeDetail(@PathVariable long id, Model model) {
		StoreDetail storeDetail = storeService.storeDetail(id);
		model.addAttribute("store", storeDetail);
		
		return "store/detail";
	}
	
	// 메뉴 클릭시 음식 추가옵션 가져오기
	@ResponseBody
	@GetMapping("/foodOption")
	public List<FoodOption> menuDetail(int foodId){
		List<FoodOption> foodOption = storeService.foodOption(foodId);
		return foodOption;
	}

}
