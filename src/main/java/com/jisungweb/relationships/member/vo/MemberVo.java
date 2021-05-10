package com.jisungweb.relationships.member.vo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class MemberVo {
	
	@ApiModelProperty(example ="고유번호")
	 private String userSeq;
	
	@ApiModelProperty(example ="유저아이디")
	 private String userId;
	 
	@ApiModelProperty(example ="유저명")
	 private String userName; 
	 
	@ApiModelProperty(example ="유저폰넘버")
	 private String phoneNumber; 
	 
	@ApiModelProperty(example ="유저비밀번호")
	 private String userPassword;
	 
	@ApiModelProperty(example ="유저이메일")
	 private String userEmail;
	 
	@ApiModelProperty(example ="유저key")
	 private String userKey;
	 
}
