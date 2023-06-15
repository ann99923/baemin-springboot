package com.baemin.dto;

import java.util.Date;

import lombok.Getter;
import lombok.ToString;
import lombok.Setter;

@Getter
@Setter
@ToString
public class Review {
	
	private String orderNum;	// 주문번호
	private long storeId;		// 매장번호
	private String storeName;	// 매장이름
	private String reviewContent;	// 리뷰내용
	private String bossComment;	//
	private Date regiDate;
	private float score;		// 별점
	private String reviewImg;	// 리뷰이미지
	
	private long userId;		// 회원아이디
	private String username;	// 회원이름
	private String nickname;	// 회원별명

}
