package com.jisungweb.relationships.member.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jisungweb.relationships.jwt.JwtFilter;
import com.jisungweb.relationships.jwt.TokenProvider;
import com.jisungweb.relationships.member.vo.LoginVo;
import com.jisungweb.relationships.member.vo.TokenVo;

import javax.validation.Valid;

/** 
 * 사용자 로그인
 * @date : 2021. 6. 7. 
 * @author : jisungYou 
 * @version : 1.0
 * @Method info :  
 */
@RestController
@RequestMapping("/api")
public class AuthController {
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public AuthController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    /**
      * @Method Name : authorize
      * @작성일 : 2021. 6. 7.
      * @작성자 : jisungYou
      * @변경이력 : 1.0
      * @Method 설명 : jwt 로그인 
      * @param loginVo
      * @return
      */
    @PostMapping("/authenticate")
    public ResponseEntity<TokenVo> authorize(@Valid @RequestBody LoginVo loginVo) {
 	   System.out.println("===========loadUserByUsername============");
        UsernamePasswordAuthenticationToken authenticationToken =new UsernamePasswordAuthenticationToken(loginVo.getUsername(), loginVo.getPassword());

 	   System.out.println("loadUserByUsername.username>>"+authenticationToken);
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        
        System.out.println("authenticate>>"+authentication);
        
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.createToken(authentication);
        
        System.out.println("authenticate.jwt>>"+jwt);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return new ResponseEntity<>(new TokenVo(jwt), httpHeaders, HttpStatus.OK);
    }
}
