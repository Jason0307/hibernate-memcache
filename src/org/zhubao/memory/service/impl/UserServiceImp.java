/**
 * 
 */
package org.zhubao.memory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhubao.memory.dao.UserDao;
import org.zhubao.memory.model.User;
import org.zhubao.memory.service.UserService;

/**
 * @author jason.zhu
 * @date   2014-10-21
 * @email jasonzhu@augmentum.com.cn
 */
@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}
	
	
}
