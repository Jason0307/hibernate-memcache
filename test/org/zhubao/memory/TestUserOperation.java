/**
 * 
 */
package org.zhubao.memory;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
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
@ContextConfiguration("classpath:testContext.xml")
public class TestUserOperation {
	
	@Autowired
	private SessionFactory sessionFactory;
	private long start = 0;
	private long end = 0;
	
	@Before
	public void setUp() {
		start = System.currentTimeMillis();
		System.out.println("Start time : " + start);
	}

	@After
	public void destroy() {
		end = System.currentTimeMillis();
		System.out.println("End Time : " + end);
		System.out.println("Total cost (ms): " + (end - start));
		System.out.println("Total cost (s): " + (end - start) / 1000);
	}
	
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
	
	@Test
	public void updateUser(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		User user = (User) session.get(User.class, "40284e8a492214b901492214bb830000");
		user.setUsername("Jason");
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
