package com.jisungweb.relationships.member.service;

import java.util.Map;

import com.jisungweb.relationships.member.vo.MemberVo;

public interface MemberService {

	Map<String, Object> insertUser(MemberVo memberVo) ;

	Map<String, Object> loginUser(MemberVo memberVo);
	
	MemberVo getIsUser(MemberVo memberVo);

	Map<String, String> mapUser(MemberVo memberVo);

}
