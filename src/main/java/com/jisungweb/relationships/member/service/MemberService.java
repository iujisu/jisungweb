package com.jisungweb.relationships.member.service;

import java.util.Map;

import com.jisungweb.relationships.member.vo.MemberVo;

public interface MemberService {

	Map<String, Object> insertUser(MemberVo memberVo) ;

	Map<String, Object> loginUser(MemberVo memberVo);

}
