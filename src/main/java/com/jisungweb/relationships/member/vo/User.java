package com.jisungweb.relationships.member.vo;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

   private Long userId;

   private String username;

   private String password;

   private String nickname;

   private boolean activated;

public Object map(Object object) {
	// TODO Auto-generated method stub
	return null;
}

}
