package com.jisungweb.relationships.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import com.jisungweb.relationships.member.service.MemberService;

import lombok.RequiredArgsConstructor;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


/** 
 * 
 * @date : 2021. 6. 3. 
 * @author : jisungYou 
 * @version : 
 * @Method info :  
 */
@RequiredArgsConstructor
public class JwtFilter extends GenericFilterBean {
	
   private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);

   public static final String AUTHORIZATION_HEADER = "Authorization";

   private final TokenProvider tokenProvider;
   

   
  
   @Override
   public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
	   logger.info("JwtFilter.doFilter====>>>>>token 체크");
       ModifiableHttpServletRequestWrapper requestWrapper = new ModifiableHttpServletRequestWrapper((HttpServletRequest)servletRequest);
       HttpServletResponse response = (HttpServletResponse) servletResponse;

      // 헤더에서 JWT 를 받아옵니다.
      String jwt = resolveToken(requestWrapper);
      String requestURI = requestWrapper.getRequestURI();
      
      // 유효한 토큰인지 확인합니다.
      if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
         Authentication authentication = tokenProvider.getAuthentication(jwt);

         SecurityContextHolder.getContext().setAuthentication(authentication);
         String userKey=authentication.getName();
         requestWrapper.setParameter("userKey", userKey);
         
			/*
			 * for(Map.Entry<String,String> entry : userMap.entrySet()){
			 * System.out.println("key : " + entry.getKey() + " , value : " +
			 * entry.getValue()); requestWrapper.setParameter(entry.getKey(),
			 * entry.getValue()); }
			 */
         
         logger.info("Security Context에 '{}' 인증 정보를 저장했습니다, uri: {}", authentication.getName(), requestURI);
      } else {
         logger.info("유효한 JWT 토큰이 없습니다, uri: {}", requestURI);
      }

      filterChain.doFilter(requestWrapper, response);
   }

   private String resolveToken(HttpServletRequest request) {
      String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
      if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
         return bearerToken.substring(7);
      }
      return null;
   }
}
