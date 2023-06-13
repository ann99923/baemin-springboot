package com.baemin.store;

import java.util.List;

import com.baemin.dto.Food;
import com.baemin.dto.Store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StoreDetail {
	
	private Store storeInfo;
	private List<Food> foodList;
	
//	private List<Review> reviewList;

}
