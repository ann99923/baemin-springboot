package com.baemin.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baemin.dto.Cart;
import com.baemin.dto.OrderDetail;
import com.baemin.dto.OrderInfo;
import com.baemin.dto.OrderList;
import com.baemin.util.Page;

@Repository
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	private SqlSession sql;

	@Override
	public int getDeleveryTip(long storeId) {
		// TODO Auto-generated method stub
		return sql.selectOne("order.getDeleveryTip", storeId);
	}

	@Override
	public List<Integer> foodPriceList(List<Cart> cartList) {
		// TODO Auto-generated method stub
		return sql.selectList("order.foodPriceList", cartList);
	}

	@Override
	public List<Integer> optionPriceList(List<Cart> cartList) {
		// TODO Auto-generated method stub
		return sql.selectList("order.optionPriceList", cartList);
	}

	@Override
	public void order(OrderInfo info) {
		// TODO Auto-generated method stub
		sql.insert("order.order", info);
	}
	
	@Override
	public void orderDetail(OrderDetail[] detail, long userId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("detail", detail);
		sql.insert("order.orderDetail", map);
		
	}
	
	@Override
	public List<OrderList> orderList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sql.selectList("order.orderList", map);
	}
	
	@Override
	public OrderList orderListDetail(String orderNum) {
		// TODO Auto-generated method stub
		return sql.selectOne("order.orderListDetail", orderNum);
	}
}
