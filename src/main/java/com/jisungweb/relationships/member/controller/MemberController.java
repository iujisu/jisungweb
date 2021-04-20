package com.jisungweb.relationships.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

		@GetMapping("/test/hello")
		public String hello() {
			return "<h1>hello spring boot</h1>";
		}
	
}
