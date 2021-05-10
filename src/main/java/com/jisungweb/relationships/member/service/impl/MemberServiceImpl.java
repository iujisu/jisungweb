package com.jisungweb.relationships.member.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jisungweb.relationships.member.mapper.MemberMapper;
import com.jisungweb.relationships.member.service.MemberService;
import com.jisungweb.relationships.member.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberMapper memMapper;
	
    @Autowired
    private PasswordEncoder passwordEncoder;

	@Override
	public Map<String, Object> insertUser(MemberVo memberVo){
		System.out.println("====MemberServiceImpl.insertUser====");
		Map<String, Object> map = new HashMap<String, Object>();
	
		/*
		 * memTest.put("userSeq", userSeq); memTest.put("userId", "iujisu");
		 * memTest.put("userName", "유지성"); memTest.put("phoneNumber", "01089211782");
		 * memTest.put("userPassword", "1234"); memTest.put("userEmail",
		 * "iujisu@naver.com");
		 */
		//memTest.put("userKey", "20210428000001");
		/*회원여부
		 * userKey 가 있다면 회원등록한 유저
		 * */

		MemberVo usertInfo= memMapper.getIsUser(memberVo);

		System.out.println("==usertInfo>>"+usertInfo);
		
		 if(usertInfo == null ) {
			System.out.println("==getUserPassword>>"+memberVo.getUserPassword());
				
			String userSeq=memMapper.getUserSeq();
			memberVo.setUserSeq(userSeq);
			memberVo.setUserPassword(passwordEncoder.encode(memberVo.getUserPassword()));

			System.out.println("==getUserSeq>>"+memberVo.getUserSeq());
			System.out.println("==getUserId>>"+memberVo.getUserId());
			System.out.println("==getUserName>>"+memberVo.getUserName());
			System.out.println("==getPhoneNumber>>"+memberVo.getPhoneNumber());
			System.out.println("==getUserEmail>>"+memberVo.getUserEmail());
			memMapper.insertUser(memberVo);
			map.put("success",true);
			map.put("message","회원가입성공");
		 }else {
			 if(usertInfo.getUserId()  ==null && usertInfo.getUserPassword() ==null ) { 
				 memberVo.setUserKey(usertInfo.getUserKey());
				 memMapper.updateUser(memberVo);
				 map.put("success",true);
				 map.put("message","회원가입성공");
			 }else {
				 map.put("success",false);
				 map.put("message","이미등록된 유저입니다.");
			 }
		 }

		// boolean check = passwordEncoder.matches(member.getPassword(), m.getPassword());
		 
		return map;
		 
	}

	@Override
	public Map<String, Object> loginUser(MemberVo memberVo) {
		System.out.println("====MemberServiceImpl.loginUser====");
		Map<String, Object> map = new HashMap<String, Object>();
		
		MemberVo usertLogin= memMapper.getLoginUser(memberVo);
		
		 boolean check = passwordEncoder.matches(memberVo.getUserPassword(), usertLogin.getUserPassword());
		 map.put("success",false);
		 map.put("message","이미등록된 유저입니다.");
		return null;
	}


}
