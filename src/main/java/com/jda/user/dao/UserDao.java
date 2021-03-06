package com.jda.user.dao;

import com.jda.user.model.Login;
import com.jda.user.model.User;

public interface UserDao {
	  void register(User user);
	  User validateUser(Login login);
	  User validateUserName(String username);
	  void saveToken(String token, String username);
	  User getUserbyToken(String token) ;
	  void newPassword(String password,String token);
	User findUserByEmail(String username);
	String generator(String password) ;
	}


