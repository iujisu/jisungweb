package com.jisungweb.relationships.member.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jisungweb.relationships.jwt.JwtFilter;
import com.jisungweb.relationships.member.service.MemberService;
import com.jisungweb.relationships.member.vo.LoginVo;
import com.jisungweb.relationships.member.vo.MemberVo;
import com.jisungweb.relationships.member.vo.TokenVo;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/** 
 * 
 * @date : 2021. 6. 16. 
 * @author : jisungYou 
 * @version : 
 * @Method info :  
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class MemberController {
	
	public static final Logger logger = LoggerFactory.getLogger(MemberController.class); 
	
		@Value("${spring.servlet.multipart.location}") 
		private String FILE_PATH;

		@Autowired
		private   MemberService memService;
		
		@GetMapping("/hello")
		public String hello() {
			log.info("정보성 로그");
			return "<h1>member/hello spring boot</h1>";
		}
		
	    
	 
	   /**
	  * @Method Name : userIdCheck
	  * @작성일 : 2021. 6. 16.
	  * @작성자 : jisungYou
	  * @변경이력 : 
	  * @Method 설명 :아이디 중복 체크
	  * @param loginVo
	  * @return
	  */
	@ApiOperation(value="사용자 아이디 중복 체크",notes = "아이디 중복 체크를 한다")
	@GetMapping("/userIdCheck")
	   public ResponseEntity<?> userIdCheck(MemberVo memberVo) {
		   System.out.println("===========userIdCheck============"+memberVo.getUserId());
	    
		   Map<String, Object> map = memService.getUserIdcheck(memberVo);
			
			return ResponseEntity.ok(map);
	   }

		
		@ApiOperation(value="사용자 정보 등록",notes = "사용자 정보 등록을 한다")
		@PostMapping(value="/memberJoin")
		public ResponseEntity<?> memberJoin(@RequestPart(value="file", required=false) MultipartFile file,MemberVo memberVo) throws Exception {
			System.out.println("====MemberController.memberJoin====");
			
			if(file != null) {
				//logger.info("file = " + file.getSize());
				//logger.info("file.isEmpty() = " + file.isEmpty());
				//파일 생성
                String orifileName = file.getOriginalFilename();
                //확장자 짤라줌
                String ext = orifileName.substring(orifileName.indexOf("."));
                //reName 규칙 설정
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
                int rdv = (int)(Math.random()*1000);
                
                String reName = sdf.format(System.currentTimeMillis())+"_"+rdv+ext;
                String filePath = FILE_PATH  + reName;
    			File memberFile = new File(filePath);
    			file.transferTo(memberFile); 
    			memberVo.setUserImagePath(filePath);
			}
			Map<String, Object> returnMap = memService.insertUser(memberVo);
			return ResponseEntity.ok(returnMap);
		}
		
		@ApiOperation(value="사용자 정보 등록",notes = "사용자 정보 등록을 한다")
		@PostMapping(value="/loginUser")
		public ResponseEntity<?> loginUser(@RequestBody MemberVo memberVo) {
			Map<String, String> map = new HashMap<String, String>();
			System.out.println("====MemberController.insertUser====");
			Map<String, Object> returnMap = memService.loginUser(memberVo);
			
			return ResponseEntity.ok(returnMap);
		}
		
		@ApiOperation(value="사용자 상세정보",notes = "사용자 상세정보")
		@GetMapping(value="/userInfo")
		public ResponseEntity<?> userInfo(MemberVo memberVo) {
			Map<String, String> map = new HashMap<String, String>();
			System.out.println("====MemberController.userInfo====");
			System.out.println("====memberVo.getUserName()>>>"+memberVo.getUserName());
			System.out.println("====memberVo.getUserKey()>>>"+memberVo.getUserKey());
			Map<String, String> returnMap = memService.mapUser(memberVo);
			
			return ResponseEntity.ok(map);
		}
			
}
