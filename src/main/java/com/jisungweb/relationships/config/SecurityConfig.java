package com.jisungweb.relationships.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(WebSecurity web) throws Exception {
		  // 허용되어야 할 경로들
	       web.ignoring().antMatchers("/resources/**", 
	                                  "/dist/**",
	                                  "/css/**",
	                                  "/font-awesome/**",
	                                  "/fonts/**",
	                                  "/img/**",
	                                  "/js/**"); 

	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() //csrf 토큰 비활성화 (테스트 시 걸어두는 게 좋음)
		.authorizeRequests()
		.antMatchers("/user/**").authenticated() // 해당 주소로 들어오면 인증이 필요함 
		.antMatchers("/manager/**").access("hasRole('ROLE_ADMIN') or hasROLE('Role_MANAGER')")
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
		.anyRequest().permitAll() //이 3개 주소가 아니라면 권한이 허용된다. 
		.and()
		.formLogin()
		.loginPage("/login");
    }
}


