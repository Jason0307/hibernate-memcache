package org.zhubao.memory.xmemcached;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.utils.AddrUtil;

public class TestConn2Mem {
        public static void main(String[] args) throws Exception {
                MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("127.0.0.1:11211"));
                MemcachedClient memcachedClient = builder.build();
                memcachedClient.set("hello", 0, "hello,memcached!");
                String value = memcachedClient.get("hello");
                System.out.println("hello=" + value);
                memcachedClient.delete("hello");
                System.out.println("hello has been deleted...");
                value = memcachedClient.get("hello");
                System.out.println("hello=" + value);
                memcachedClient.shutdown();
        }
}