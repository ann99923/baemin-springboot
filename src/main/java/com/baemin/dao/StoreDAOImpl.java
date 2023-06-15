package com.baemin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baemin.dto.Food;
import com.baemin.dto.FoodOption;
import com.baemin.dto.Review;
import com.baemin.dto.Store;

@Repository
public class StoreDAOImpl implements StoreDAO {
	
	@Autowired
	private SqlSession sql;

	@Override
	public List<Store> storeList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sql.selectList("store.storeList", map);
	}
	
	@Override
	public Store storeDetail(long storeId) {
		// TODO Auto-generated method stub
		return sql.selectOne("store.storeDetail", storeId);
	}
	
	@Override
	public List<Food> foodList(long id) {
		// TODO Auto-generated method stub
		return sql.selectList("store.foodList", id);
	}
	
	@Override
	public List<FoodOption> foodOption(int foodId) {
		// TODO Auto-generated method stub
		return sql.selectList("store.foodOption", foodId);
	}
	
	@Override
	public void reviewWrite(Review review) {
		// TODO Auto-generated method stub
		sql.insert("store.reviewWrite", review);
	}
	
	@Override
	public List<Review> reviewList(long id) {
		// TODO Auto-generated method stub
		return sql.selectList("store.reviewList", id);
	}
	
	@Override
	public void reviewModify(Review review) {
		// TODO Auto-generated method stub
		sql.update("store.reviewModify", review);
	}

}
