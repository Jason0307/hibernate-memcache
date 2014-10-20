/**
 * 
 */
package org.zhubao.memory.cache;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jason.zhu
 * @date   2014-10-15
 * @email jasonzhu@augmentum.com.cn
 */
public class UserModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long userId;
	private String username;
	
	
	
	/**
	 * 
	 */
	public UserModel() {
		super();
	}
	/**
	 * @param userId
	 * @param username
	 */
	public UserModel(long userId, String username) {
		super();
		this.userId = userId;
		this.username = username;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + "]";
	}
	
	public static void main(String[] args) {
		Date date = new Date(1413771665000L);
		System.out.println(date);
	}
	
	
	
}
