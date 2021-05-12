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
		//memTest.put("userKey", "20210428000001");
		/*회원여부
		 * userKey 가 있다면 회원등록한 유저
		 * */

		MemberVo usertInfo= memMapper.getIsUser(memberVo);

		 if(usertInfo == null ) {	
			String userSeq=memMapper.getUserSeq();
			memberVo.setUserSeq(userSeq);
			memberVo.setUserPassword(passwordEncoder.encode(memberVo.getUserPassword()));
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
		memberVo.setUserPassword(passwordEncoder.encode(memberVo.getUserPassword()));
		MemberVo usertLogin= memMapper.getLoginUser(memberVo);
		if(usertLogin !=null) {
			 map.put("success",true);
			 map.put("userInfo",usertLogin);
			 map.put("message","로그인 성공.");
		}else {
			 map.put("success",false);
			 map.put("message","로그인 실패.");
		}
		 //boolean check = passwordEncoder.matches(memberVo.getUserPassword(), usertLogin.getUserPassword());

		return null;
	}


}
