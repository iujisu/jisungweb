package com.jisungweb.relationships.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jisungweb.relationships.member.service.MemberService;
import com.jisungweb.relationships.member.vo.MemberVo;


@RestController
@RequestMapping("/member")
public class MemberController {

		@Autowired
		private   MemberService memService;

//		@GetMapping("/hello")
//		public String hello() {
//			return "<h1>member/hello spring boot</h1>";
//		}

		@PostMapping("/memberadd")
		public void memberAdd(@RequestBody MemberVo memberVo) throws Exception {
			System.out.println("====MemberController.insertUser====");
			System.out.println("==>>>"+memberVo.getId());
			memService.insertUser();
		}
			
}
