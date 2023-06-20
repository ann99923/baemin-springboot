package com.baemin.service;

import java.util.List;

import com.baemin.dto.FoodOption;
import com.baemin.dto.Review;
import com.baemin.dto.Store;
import com.baemin.dto.StoreDetail;

public interface StoreService {
	
	List<Store> storeList(int category, int address);
	
	StoreDetail storeDetail(long id, long userId);
	
	// 해당 메뉴의 옵션 가져오기
	List<FoodOption> foodOption(int foodId);
	
	// 리뷰작성
	void reviewWrite(Review review);
	
	// 리뷰수정
	void reviewModify(Review review);
	
	// 매장목록
	List<Store> storeList(int category, int address, String sort, int page);

	// 찜
	void likes(long storeId, String likes, long userId);
	
	// 찜한 가게들
	List<Store> likesList(long userId);

}
