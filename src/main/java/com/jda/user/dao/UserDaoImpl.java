package com.jda.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.jda.user.model.Login;
import com.jda.user.model.User;

public class UserDaoImpl implements UserDao {
  @Autowired
  DataSource datasource;
  @Autowired
  JdbcTemplate jdbcTemplate;
  public void register(User user) {
    String sql = "insert into user values(?,?,?,?,?)";
    jdbcTemplate.update(sql, new Object[] { user.getName(),user.getUsername(), user.getPassword(), 
   user.getMobile(),"abc"});
    }
    public User validateUser(Login login) {
    String sql = "select * from user  where username='" + login.getUsername() + "' and password='" + login.getPassword()
    + "'";
    List<User> users = jdbcTemplate.query(sql, new UserMapper());
    return users.size() > 0 ? users.get(0) : null;
    }
    
    public User  validateUserName(String  username)
    {
   	 String sql = "select * from user where username ='"+username+"'" ;
   	 List<User> users = jdbcTemplate.query(sql, new UserMapper());
       return users.size() > 0 ? users.get(0) : null;
		
    }
    
    public void saveToken(String token, String username)
    {
   	 String sql = "update user set token = '"+token+"'  where username = '"+username+"'";
   	 jdbcTemplate.execute(sql);
   	 
    }
	
  class UserMapper implements RowMapper<User> {
  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User user = new User();
    user.setName(rs.getString("name"));
    user.setUsername(rs.getString("username"));
    user.setPassword(rs.getString("password"));
    
   
    
   
    user.setMobile(rs.getString("mobile"));
    user.setToken(rs.getString("token"));
    return user;
  }
}
}
