package com.jisungweb.relationships.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class MybatisConfig {

		@Bean
	    public  SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
	
	        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource);
	        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
	        sessionFactory.setMapperLocations(resolver.getResources("classpath:mapper/**/*.xml"));
	        sessionFactory.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
	        SqlSessionFactory factory =  sessionFactory.getObject();
	        factory.getConfiguration().setMapUnderscoreToCamelCase(true);
	        return factory;
	
	    }
	  
	    @Bean
	    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
	        return new SqlSessionTemplate(sqlSessionFactory);
	    }
}
