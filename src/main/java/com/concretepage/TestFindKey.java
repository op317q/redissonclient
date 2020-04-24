package com.concretepage;

import java.util.Iterator;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RKeys;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class TestFindKey {
	
	
	RedissonClient getClient() {
		
		
		Config config = new Config(); 
		config.useSingleServer().setAddress("redis://127.0.0.1:6379"); 
		RedissonClient rdson = Redisson.create(config);
		
		return rdson;
	}
	
	void printKeyVal(RedissonClient client) {
		
		RKeys keys =client.getKeys();
		
		Iterable<String> allKeys= keys.getKeys();
		Iterator itr = allKeys.iterator();
		
		while(itr.hasNext()) {
			String obj= (String)itr.next();
			System.out.println("key=="+obj);
			
		 
			
		}
		client.shutdown();
		System.out.println("done");
		
	}
	
	public static void main(String[] args) {
		
		TestFindKey test =new TestFindKey();
		RedissonClient client = test.getClient();
		test.printKeyVal(client);
	}

}
