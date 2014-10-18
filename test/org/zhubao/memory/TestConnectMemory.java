/**
 * 
 */
package org.zhubao.memory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.rubyeye.xmemcached.KeyIterator;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.utils.AddrUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;




/**
 * @author jason.zhu
 * @date 2014-10-17
 * @email jasonzhu@augmentum.com.cn
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestConnectMemory {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private MemcachedClient memcachedClient;

	private long start = 0;
	private long end = 0;
	@Before
	public void setUp(){
	  start = System.currentTimeMillis();
		System.out.println("Start time : " + start);
	}
	
	@After
	public void destroy(){
	   end = System.currentTimeMillis();
		System.out.println("End Time : " + end);
		System.out.println("Total cost (ms): " + (end - start) );
		System.out.println("Total cost (s): " + (end - start) / 1000);
	}
	
	@Test
	public void testConnectSql() throws Exception {
		for (int i = 101; i < 600; i++) {
			String uuid = UUID.randomUUID().toString();
			jdbcTemplate
					.execute("INSERT INTO User(userId,username,password,emailAddress,age) VALUES("
							+ "'"
							+ uuid
							+ "','jason"
							+ i
							+ "','123456','tester@qq.com'," + i + ")");
		}
	}

	@Test
	public void testBatchUpdate() {
		String sql = "INSERT INTO User(userId,username,password,emailAddress,age) VALUES(?,?,?,?,?)";
		BatchPreparedStatementSetter setter = new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i)
					throws SQLException {
				String uuid = UUID.randomUUID().toString();
				ps.setString(1, uuid);
				ps.setString(2, "Jason" + i);
				ps.setString(3, "123456");
				ps.setString(4, "tester@qq.com");
				ps.setInt(5, i);
			}

			public int getBatchSize() {
				return 50;
			}
		};
		for (int i = 0; i < 10; i++) {
			jdbcTemplate.batchUpdate(sql, setter);
		}
	}

	@Test
	public void testMemoryCachedInsert() throws Exception{
		for(int i = 101; i < 600 ; i++){
			memcachedClient.set("user" + i, 0, "Jason" + i);
		}
		
		for(int i = 101; i < 600 ; i++){
			String user = memcachedClient.get("user" + i);
			System.out.println(user);
		}
		
	}
	
	@Test
	public void getUserFromCache() throws Exception{
		Map map = memcachedClient.get("203fa10a9b8abe755b0dfa5508010dc70abd26ed");
		List list2 = memcachedClient.get("6ee748ce986fd1aebc37b000fc5f3b2a93f10d52"); 
		
		Map list3 = memcachedClient.get("6b6dbaef1da254af4d5bbed1135ccd98ad1a1036"); 
		
		
		System.out.println(map);
		System.out.println(list2);
		System.out.println(list3);
	}
	
	@Test
	public void getMemcahceKeys() throws Exception{
		KeyIterator it = memcachedClient.getKeyIterator(AddrUtil.getOneAddress("127.0.0.1:11211"));
		while(it.hasNext()){
			String key = it.next();
			System.out.println("key : " + key);
		}
	}
}
