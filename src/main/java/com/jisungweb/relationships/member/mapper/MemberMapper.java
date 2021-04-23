package com.jisungweb.relationships.member.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberMapper {

	public void insertUser(Map<String, String> memTest);

}
