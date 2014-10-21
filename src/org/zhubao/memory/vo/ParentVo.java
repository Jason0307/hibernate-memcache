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
public class ParentVo {

	private String name;
	private int age;
	private List<ChildVo> childVos;
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
	public List<ChildVo> getChildVos() {
		return childVos;
	}
	public void setChildVos(List<ChildVo> childVos) {
		this.childVos = childVos;
	}
	
	
}
