package com.jda.user.model;

public class User {
	  private String username;
	  private String password;
	  private String name;
	  private String mobile;
	  
	 
	  public String getUsername() {
	  return username;
	  }
	  public void setUsername(String username) {
	  this.username = username;
	  }
	  public String getPassword() {
	  return password;
	  }
	  public void setPassword(String password) {
	  this.password = password;
	  }
	  public String getName() {
		  return name;
	  }
	  public void setName(String  name) {
	  this.name= name;
	  }
	  public String getMobile() {
		  return mobile;
	  }
	  public void setMobile(String mobile) {
	  this.mobile = mobile;
	  }
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", name=" + name + ", mobile=" + mobile + "]";
	}
	  
	}
