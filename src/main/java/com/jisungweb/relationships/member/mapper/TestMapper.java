package com.jisungweb.relationships.member.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {

	void insertUser(Map<String, String> memTest);

}
