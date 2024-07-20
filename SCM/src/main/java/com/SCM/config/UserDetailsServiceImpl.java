package com.SCM.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.SCM.DAO.*;
import com.SCM.model.userVO;

public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepo userdao;
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		userVO user =  userdao.getUsername(email);
		
		if(user==null){
			throw new UsernameNotFoundException("User Not found");
		}
		
		
		CustomUserDetails customuserdetails = new CustomUserDetails(user); 
		
		
		return customuserdetails;
	}
	
}
