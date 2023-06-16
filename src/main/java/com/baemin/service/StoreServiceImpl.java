package com.baemin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baemin.dao.StoreDAO;
import com.baemin.dto.Food;
import com.baemin.dto.FoodOption;
import com.baemin.dto.Review;
import com.baemin.dto.Store;
import com.baemin.dto.StoreDetail;
import com.baemin.util.Page;

@Service
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private StoreDAO storeDAO;

	@Override
	public List<Store> storeList(int category, int address) {
		// TODO Auto-generated method stub
		
		return storeList(category, address, "주문접소 대기 중", 1);
	}
	
	@Override
	public StoreDetail storeDetail(long storeId) {
		// TODO Auto-generated method stub
		Store storeInfo = storeDAO.storeDetail(storeId);
		List<Food> foodList = storeDAO.foodList(storeId);
		List<Review> reviewList = storeDAO.reviewList(storeId);
		
		System.out.println("가게정보: " + storeInfo);
		System.out.println("메뉴목록: " + foodList);
		System.out.println("댓글목록: " + reviewList);

		return new StoreDetail(storeInfo, foodList, reviewList);
	}
	
	@Override
	public List<FoodOption> foodOption(int foodId) {
		// TODO Auto-generated method stub
		return storeDAO.foodOption(foodId);
	}
	
	@Override
	public void reviewWrite(Review review) {
		// TODO Auto-generated method stub
		storeDAO.reviewWrite(review);
	}
	
	@Override
	public void reviewModify(Review review) {
		// TODO Auto-generated method stub
		storeDAO.reviewModify(review);
	}
	
	@Override
	public List<Store> storeList(int category, int address1, String sort, int page) {
		// TODO Auto-generated method stub
		Page p = new Page(page, 8);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("category", category);
		map.put("address1", address1);
		map.put("firstList", p.getFirstList());
		System.out.println(p.getFirstList());
		map.put("lastList", p.getLastList());
		map.put("sort", sort);
		System.out.println("페이지 시작 = " + p.getFirstList() + " 페이지 끝 = " + p.getLastList());
		
		return storeDAO.storeList(map);
	}

}
