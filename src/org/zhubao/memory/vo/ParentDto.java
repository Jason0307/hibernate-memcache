/**
 * 
 */
package org.zhubao.memory.vo;

import java.util.Arrays;

/**
 * @author jason.zhu
 * @date   2014-10-20
 * @email jasonzhu@augmentum.com.cn
 */
public class ParentDto {

	private String name;
	private int age;
	private String[][] childInfo;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String[][] getChildInfo() {
		return childInfo;
	}
	public void setChildInfo(String[][] childInfo) {
		this.childInfo = childInfo;
	}
	@Override
	public String toString() {
		return "ParentDto [name=" + name + ", age=" + age + ", childInfo="
				+ Arrays.toString(childInfo) + "]";
	}
	
}
