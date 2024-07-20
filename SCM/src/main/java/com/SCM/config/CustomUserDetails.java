package com.SCM.config;


import java.util.Collection;
import java.util.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.SCM.model.userVO;




public class CustomUserDetails implements UserDetails{

	private userVO user;
	
	public CustomUserDetails(userVO user) {
		super();
		this.user = user;
	}
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
		return Arrays.asList(authority);
	}

	public String getPassword() {
		
		return user.getPassword();
		
	}

	public String getUsername() {
		
		return user.getEmail();
	}

	public boolean isAccountNonExpired() {
		
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	public boolean isEnabled() {
		
		return true;
	}

}
