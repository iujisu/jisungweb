package com.jisungweb.relationships.member.service;

import com.jisungweb.relationships.member.vo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jisungweb.relationships.member.mapper.MemberMapper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	MemberMapper memMapper;
	
   @Override
   @Transactional
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	   System.out.println("===========loadUserByUsername============");
	   User user=memMapper.findOneWithAuthoritiesByUsername(username);
       if(user == null){
           throw new UsernameNotFoundException(username + " -> 데이터베이스에서 찾을 수 없습니다.");
       }

       return createUser(username, user);
   }
   
   private org.springframework.security.core.userdetails.User createUser(String username, User user) {
	   
	   System.out.println("===========createUser============"); 
      if (!user.isActivated()) {
         throw new RuntimeException(username + " -> 활성화되어 있지 않습니다.");
      }
      List<String> list = Arrays.asList("ROLE_USER","ROLE_ADMIN");//권한테스트
      List<GrantedAuthority> grantedAuthorities = list.stream().map(authority -> new SimpleGrantedAuthority("ROLE_USER")).collect(Collectors.toList());
      return new org.springframework.security.core.userdetails.User(user.getUsername(),
              user.getPassword(),
              grantedAuthorities);
   }
}
