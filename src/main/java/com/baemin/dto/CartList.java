package com.baemin.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CartList {
	
	private long storeId;			// 가게 id
	private String storeName;		// 가게 이름
	int cartTotal;					// 장바구니 가격 총합
	private int deleveryTip;		// 배달팁
	
	List<Cart> cart;

}
