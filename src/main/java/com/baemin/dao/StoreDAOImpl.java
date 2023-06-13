package com.baemin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baemin.dto.Store;
import com.baemin.store.StoreDetail;

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

}
