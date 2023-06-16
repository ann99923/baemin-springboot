package com.baemin.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.baemin.dto.FoodOption;
import com.baemin.dto.Review;
import com.baemin.dto.Store;
import com.baemin.dto.StoreDetail;
import com.baemin.login.LoginService;
import com.baemin.service.StoreService;
import com.baemin.util.UploadFile;

@Controller
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private UploadFile uploadFile;
	
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
		System.out.println(storeDetail.getStoreInfo());
		return "store/detail";
	}
	
	// 메뉴 클릭시 음식 추가옵션 가져오기
	@ResponseBody
	@GetMapping("/foodOption")
	public List<FoodOption> menuDetail(int foodId){
		List<FoodOption> foodOption = storeService.foodOption(foodId);
		return foodOption;
	}
	
	// 리뷰 작성
	@PostMapping("/store/review")
	public String review(Review review, MultipartFile file, @AuthenticationPrincipal LoginService user) throws IOException {
		if(file.isEmpty()) {
			String img = "";
			review.setReviewImg(img);
		}else {
			String img = uploadFile.fileUpload(file);
			review.setReviewImg(img);
		}
		
		long userId = user.getUser().getId();
		review.setUserId(userId);
		
		storeService.reviewWrite(review);
		
		return "redirect:/orderList";
	}
	
	// 리뷰 수정
	@PostMapping("/store/reviewModify")
	public String reviewModify(Review review, MultipartFile file, @AuthenticationPrincipal LoginService user) throws IOException {
		if(!file.isEmpty()) {
			String img = uploadFile.fileUpload(file);
			review.setReviewImg(img);
		}
		
		long userId = user.getUser().getId();
		review.setUserId(userId);
		
		System.out.println(review);
		storeService.reviewModify(review);
		
		return "redirect:/orderList";	
	}
	
	// 다음 페이지 불러오기
	@ResponseBody
	@GetMapping("/store/storeList")
	public ResponseEntity<List<Store>> sortStore(int category, int address1, String sort, int page, Model model) {
		List<Store> storeList = storeService.storeList(category, address1 / 100, sort, page);
		return new ResponseEntity<List<Store>>(storeList, HttpStatus.OK);
	}
}
