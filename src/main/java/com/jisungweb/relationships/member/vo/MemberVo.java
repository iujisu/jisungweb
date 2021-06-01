package com.jisungweb.relationships.member.vo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
	
	@ApiModelProperty(value ="유저권한")
	 private String userRoll;
	
	@ApiModelProperty(value ="유저사용여부")
	 private String userActivated;
	
	
	
	 
}
