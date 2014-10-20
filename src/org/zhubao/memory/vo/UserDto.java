/**
 * 
 */
package org.zhubao.memory.vo;

import java.util.Date;
import java.util.List;

/**
 * @author jason.zhu
 * @date   2014-10-20
 * @email jasonzhu@augmentum.com.cn
 */
public class UserDto {

	private String userId;
	private String username;
	private List<Integer> items;
	private Date birthDate;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Integer> getItems() {
		return items;
	}
	public void setItems(List<Integer> items) {
		this.items = items;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
}
