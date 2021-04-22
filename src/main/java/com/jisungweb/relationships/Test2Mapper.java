package com.jisungweb.relationships;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Test2Mapper {
	void insertUser(Map<String, String> memTest);
}
