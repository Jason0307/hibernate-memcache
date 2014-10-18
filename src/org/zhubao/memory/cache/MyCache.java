package org.zhubao.memory.cache;

import java.util.Date;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

public class MyCache {
	public static void main(String[] args) throws InterruptedException {
		MemCachedClient client=new MemCachedClient();
		String [] addr ={"127.0.0.1:11211"};
		Integer [] weights = {3};
		SockIOPool pool = SockIOPool.getInstance();
		pool.setServers(addr);
		pool.setWeights(weights);
		pool.setInitConn(5);
		pool.setMinConn(5);
		pool.setMaxConn(200);
		pool.setMaxIdle(1000*30*30);
		pool.setMaintSleep(30);
		pool.setNagle(false);
		pool.setSocketTO(30);
		pool.setSocketConnectTO(0);
		pool.initialize();
		
		
		client.set("test2","test2");
		Date date=new Date(6000);
		client.set("test1","test1", date);
		System.out.println("Before expired : " + client.get("test1"));
		Thread.sleep(5000);
		String str =(String)client.get("test1");
		System.out.println("After expired : " + str);
		UserModel user = new UserModel(1001,"Jason");
		client.add("1001", user);
		
		UserModel userBean = (UserModel) client.get("1001");
		System.out.println(userBean);
		
	}
}
