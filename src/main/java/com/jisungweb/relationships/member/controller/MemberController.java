package com.jisungweb.relationships.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jisungweb.relationships.member.service.MemberService;
import com.jisungweb.relationships.member.vo.MemberVo;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/api")
@Slf4j
public class MemberController {
	
	public static final Logger logger = LoggerFactory.getLogger(MemberController.class); 

		@Autowired
		private   MemberService memService;
		
		@GetMapping("/hello")
		public String hello() {
			log.info("정보성 로그");
			return "<h1>member/hello spring boot</h1>";
		}

		
		@ApiOperation(value="사용자 정보 등록",notes = "사용자 정보 등록을 한다")
		@PostMapping(value="/memberadd")
		public ResponseEntity<?> memberAdd(@RequestPart(value="file", required=false) MultipartFile file,MemberVo memberVo) {
			Map<String, String> map = new HashMap<String, String>();
			
			System.out.println("====MemberController.insertUser====");
			System.out.println("getUserId==>>>"+memberVo.getPhoneNumber());

			System.out.println("====fileTest====");
			logger.info("file = " + file.getSize());
		
			
			Map<String, Object> returnMap = memService.insertUser(memberVo);
			System.out.println("====returnMap.message=>>"+returnMap.get("message"));
			return ResponseEntity.ok(returnMap);
		}
		
		@ApiOperation(value="사용자 정보 등록",notes = "사용자 정보 등록을 한다")
		@PostMapping(value="/loginUser")
		public ResponseEntity<?> loginUser(@RequestBody MemberVo memberVo) {
			Map<String, String> map = new HashMap<String, String>();
			System.out.println("====MemberController.insertUser====");
			System.out.println("getUserId==>>>"+memberVo.getPhoneNumber());

			Map<String, Object> returnMap = memService.loginUser(memberVo);
			
			return ResponseEntity.ok(returnMap);
		}
			
}
