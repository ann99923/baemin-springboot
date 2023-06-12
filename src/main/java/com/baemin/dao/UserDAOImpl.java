package com.baemin.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baemin.dto.Join;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SqlSession sql;

	@Override
	public void join(Join join) {
		// TODO Auto-generated method stub
		sql.insert("user.join", join);
		
	}

	@Override
	public int overlapCheck(String value, String valueType) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("value", value);
		map.put("valueType", valueType);
		
		return sql.selectOne("user.overlapCheck", map);
	}

}
