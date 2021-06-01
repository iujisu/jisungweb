package com.jisungweb.relationships.common.utils;

import java.util.HashMap;

import org.apache.ibatis.type.Alias;
import org.springframework.jdbc.support.JdbcUtils;

@Alias("Camelmap")
@SuppressWarnings("serial")
public class Camelmap extends HashMap<String, Object> {

    @Override
    public Object put(String key, Object value) {
        return super.put(JdbcUtils.convertUnderscoreNameToPropertyName(key), value);
    }
    
}