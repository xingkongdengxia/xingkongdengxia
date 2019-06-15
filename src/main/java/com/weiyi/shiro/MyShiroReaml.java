package com.weiyi.shiro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.AuthenticatingRealm;

public class MyShiroReaml extends AuthenticatingRealm{

	/**
	 * 获取认证消息		如果数据库有数据返回用户名和密码，没有返回null
	 * 
	 * AuthenticationInfo	通过SimpleAuthenticationInfo实现类，封装密码和用户名
	 * 
	 * 
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		SimpleAuthenticationInfo simpleAuthenticationInfo = null;
		
		//将token转化成UsernamePasswordToken
		UsernamePasswordToken passwordToken = (UsernamePasswordToken) token;
		//获取用户名
		String username = passwordToken.getUsername();
		//查询数据是否存在用户名密码
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/weiyidata?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Hongkong&rewriteBatchedStatements=true&allowPublicKeyRetrieval=true";
			String name = "xingxing";
			String password = "chen92649264";
			try {
				Connection connection = DriverManager.getConnection(url, name, password);
				
				PreparedStatement statement = connection.prepareStatement("SELECT * from weiyidata.weiyiuser where param_name = ?");
				statement.setString(1, username);
				
				ResultSet resultSet = statement.executeQuery();
				
				if(resultSet.next()){
					Object principal = username;
					
					Object credentials = resultSet.getString(3);
					
					String realmName = this.getName();
				
					simpleAuthenticationInfo = new SimpleAuthenticationInfo(principal, credentials, realmName);
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return simpleAuthenticationInfo;
	}

}
