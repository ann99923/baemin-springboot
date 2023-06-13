package com.baemin.service;

import java.util.List;

import com.baemin.dto.Store;
import com.baemin.store.StoreDetail;

public interface StoreService {
	
	List<Store> storeList(int category, int address);
	
	StoreDetail storeDetail(long id);

}
