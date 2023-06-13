package com.baemin.dao;

import java.util.List;
import java.util.Map;

import com.baemin.dto.Store;
import com.baemin.store.StoreDetail;

public interface StoreDAO {
	
	List<Store> storeList(Map<String, Object> map);
	
	Store storeDetail(long storeId);

}
