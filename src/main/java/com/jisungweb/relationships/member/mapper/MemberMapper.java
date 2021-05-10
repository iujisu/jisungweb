package com.jisungweb.relationships.member.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jisungweb.relationships.member.vo.MemberVo;

@Mapper
public interface MemberMapper {


	public String getUserSeq();
	
	public void insertUser(MemberVo memberVo);

	public String getUserKey(MemberVo memberVo);

	MemberVo  getIsUser(MemberVo memberVo);

	public void updateUser(MemberVo memberVo);

	public MemberVo getLoginUser(MemberVo memberVo);

}
