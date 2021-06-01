package com.jisungweb.relationships.member.vo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

   private Long userSeq;

   private String username;

   private String password;

   private String userRoll;

   private boolean activated;

   public Object map(Object object) {
		return null;
   }

}
