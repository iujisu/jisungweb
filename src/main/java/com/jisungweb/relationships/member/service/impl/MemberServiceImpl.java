package com.jisungweb.relationships.member.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jisungweb.relationships.member.mapper.MemberMapper;
import com.jisungweb.relationships.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberMapper memMapper;

	@Override
	public void insertUser() throws Exception{
		System.out.println("====MemberServiceImpl.insertUser====");
		Map<String, String> memTest = new HashMap<String, String>();
		memTest.put("id", "iujisu");
		memTest.put("name", "유지성");
		memTest.put("mobile", "01089211782");
		
		memMapper.insertUser(memTest);
	}


}
