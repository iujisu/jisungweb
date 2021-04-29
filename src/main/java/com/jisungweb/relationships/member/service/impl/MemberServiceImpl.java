package com.jisungweb.relationships.member.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jisungweb.relationships.member.mapper.MemberMapper;
import com.jisungweb.relationships.member.service.MemberService;
import com.jisungweb.relationships.member.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberMapper memMapper;

	@Override
	public void insertUser(MemberVo memberVo){
		System.out.println("====MemberServiceImpl.insertUser====");
		String userSeq=memMapper.getUserSeq();
		Map<String, String> memTest = new HashMap<String, String>();
		memTest.put("userSeq", userSeq);
		memTest.put("userId", "iujisu");
		memTest.put("userName", "유지성");
		memTest.put("phoneNumber", "01089211782");
		memTest.put("userPassword", "1234");
		memTest.put("userEmail", "iujisu@naver.com");
		//memTest.put("userKey", "20210428000001");

		
		memMapper.insertUser(memTest);
	}


}
