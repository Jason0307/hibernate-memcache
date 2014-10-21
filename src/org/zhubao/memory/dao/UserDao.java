/**
 * 
 */
package org.zhubao.memory.dao;

import java.util.List;

import org.zhubao.memory.model.User;

/**
 * @author jason.zhu
 * @date   2014-10-21
 * @email jasonzhu@augmentum.com.cn
 */
public interface UserDao {

	/**
	 * Test cache performence
	 * @return
	 */
	List<User> getUsers();
}
