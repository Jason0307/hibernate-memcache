/**
 * 
 */
package org.zhubao.memory.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zhubao.memory.dao.UserDao;
import org.zhubao.memory.model.User;

/**
 * @author jason.zhu
 * @date 2014-10-21
 * @email jasonzhu@augmentum.com.cn
 */
@Repository
public class UserDaoImp implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		Session session = getSession();
		Query query = session.createQuery("FROM User");
		query.setCacheable(true);
		users = query.list();
		return users;
	}

}
