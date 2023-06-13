package com.baemin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baemin.dao.StoreDAO;
import com.baemin.dto.Food;
import com.baemin.dto.FoodOption;
import com.baemin.dto.Store;
import com.baemin.store.StoreDetail;

@Service
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private StoreDAO storeDAO;

	@Override
	public List<Store> storeList(int category, int address) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("category", category);
		map.put("address1", address);
		
		return storeDAO.storeList(map);
	}
	
	@Override
	public StoreDetail storeDetail(long storeId) {
		// TODO Auto-generated method stub
		Store storeInfo = storeDAO.storeDetail(storeId);
		List<Food> foodList = storeDAO.foodList(storeId);
		
		return new StoreDetail(storeInfo, foodList);
	}
	
	@Override
	public List<FoodOption> foodOption(int foodId) {
		// TODO Auto-generated method stub
		return storeDAO.foodOption(foodId);
	}

}
