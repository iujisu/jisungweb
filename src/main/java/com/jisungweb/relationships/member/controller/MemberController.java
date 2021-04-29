package com.jisungweb.relationships.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jisungweb.relationships.member.service.MemberService;
import com.jisungweb.relationships.member.vo.MemberVo;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/api")
@Slf4j
public class MemberController {

		@Autowired
		private   MemberService memService;
		@GetMapping("/hello")
		@ApiOperation(value="사용자 정보 등록",notes = "사용자 정보 등록을 한다")
		public String hello() {
			return "<h1>member/hello spring boot</h1>";
		}

		@PostMapping("/memberadd")
		public ResponseEntity<Map<String, String>> memberAdd(@RequestBody MemberVo memberVo) {
			System.out.println("====MemberController.insertUser====");
			System.out.println("getUserId==>>>"+memberVo.getUserId());
			memService.insertUser(memberVo);
			
			Map<String, String> map = new HashMap<String, String>();

			return ResponseEntity.ok(map);
		}
			
}
