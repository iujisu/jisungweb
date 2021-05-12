package com.jisungweb.relationships.member.vo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class MemberVo {
	
	@ApiModelProperty(value ="고유번호")
	 private String userSeq;
	
	@ApiModelProperty(value ="유저아이디")
	 private String userId;
	 
	@ApiModelProperty(value ="유저명")
	 private String userName; 
	 
	@ApiModelProperty(value ="유저폰넘버")
	 private String phoneNumber; 
	 
	@ApiModelProperty(value ="유저비밀번호")
	 private String userPassword;
	 
	@ApiModelProperty(value ="유저이메일")
	 private String userEmail;
	 
	@ApiModelProperty(value="유저key")
	 private String userKey;
	
	@ApiModelProperty(value ="유저key")
	 private String userImagePath;
	
	 
}
