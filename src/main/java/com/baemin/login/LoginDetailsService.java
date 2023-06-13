package com.baemin.login;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.baemin.dto.User;

@Service
public class LoginDetailsService implements UserDetailsService {
	
	@Autowired
	private SqlSession sql;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = sql.selectOne("user.login", username);
		
		if(user != null) {
			LoginService loginDetail = new LoginService();
			
			loginDetail.setUser(user);
			
			return loginDetail;
		}else {
			throw new UsernameNotFoundException("유저없음");
		}
	}
	
	

}