package com.jisungweb.relationships.member.mapper;

import java.util.Map;
import java.util.stream.Stream;

import org.apache.ibatis.annotations.Mapper;

import com.jisungweb.relationships.member.vo.MemberVo;
import com.jisungweb.relationships.member.vo.User;

@Mapper
public interface MemberMapper {


	public String getUserSeq();
	
	public void insertUser(MemberVo memberVo);

	public String getUserKey(MemberVo memberVo);

	MemberVo  getIsUser(MemberVo memberVo);

	public void updateUser(MemberVo memberVo);

	public MemberVo getLoginUser(MemberVo memberVo);

	public User findOneWithAuthoritiesByUsername(String username);

	public MemberVo mapUser(String userKey);

}
