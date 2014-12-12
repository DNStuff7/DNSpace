package com.exadel.user.base;

import lombok.Data;

public @Data class User implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private int userID;
	private String firstName;
	private String lastName;
	private String email;
}