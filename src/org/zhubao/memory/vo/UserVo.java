/**
 * 
 */
package org.zhubao.memory.vo;

import java.util.List;

/**
 * @author jason.zhu
 * @date   2014-10-20
 * @email jasonzhu@augmentum.com.cn
 */
public class UserVo {

	private String userId;
	private String name;
	private List<Integer> itemIds;
	private int gender;
	private String birthDate;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Integer> getItemIds() {
		return itemIds;
	}
	public void setItemIds(List<Integer> itemIds) {
		this.itemIds = itemIds;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", name=" + name + ", itemIds="
				+ itemIds + ", gender=" + gender + ", birthDate=" + birthDate
				+ "]";
	}
	
	
}
