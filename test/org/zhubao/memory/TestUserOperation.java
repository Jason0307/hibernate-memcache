/**
 * 
 */
package org.zhubao.memory;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zhubao.memory.model.User;

/**
 * @author jason.zhu
 * @date   2014-10-18
 * @email jasonzhu@augmentum.com.cn
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestUserOperation {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Test
	public void saveUser(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		User user = new User();
		user.setUsername("Jason Zhu");
		user.setPassword("123456");
		user.setEmailAddress("zrb0307@gmail.com");
		session.save(user);
		session.getTransaction().commit();
		//session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void getUsers(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM User");
		query.setCacheable(true);
		List<User> users = query.list();
		System.out.println(users);
		List<User> users2 = query.list();
		System.out.println(users2);
	}
	
	@Test
	public void getUserById(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM User WHERE userId=?");
		query.setString(0, "40284e8a492214b901492214bb830000");
		query.setCacheable(true);
		User user = (User) query.uniqueResult();
		System.out.println(user);
	}
}
