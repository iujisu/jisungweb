package com.jisungweb.relationships.member.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jisungweb.relationships.member.mapper.MemberMapper;
import com.jisungweb.relationships.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	private MemberMapper memMapper;

	@Override
	public void insertUser() {
		System.out.println("====MemberServiceImpl.insertUser====");
		Map<String, String> memTest = new HashMap<String, String>();
		memTest.put("id", "iujisu");
		memTest.put("name", "유지성");
		memTest.put("mobile", "01089211782");
		
		memMapper.insertUser(memTest);
	}


}
