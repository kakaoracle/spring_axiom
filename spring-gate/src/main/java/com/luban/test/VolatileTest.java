package com.luban.test;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class VolatileTest {
	private  static  volatile int race=0;
	private static void increase(){
		race++;
		System.out.println(Thread.currentThread().getName()+'-'+race);

	}

	public static void main(String[] args)  throws Exception {
		ConcurrentHashMap  map=new ConcurrentHashMap();
		Thread[] threads=new Thread[200];
		for(int i=0;i<200;i++){
			threads[i]=new Thread(new Runnable() {
				@Override
				public void run() {
					for(int i=0;i<1000;i++){
						race++;
						System.out.println(race);
					}
				}
			});
			threads[i].setName("thread"+i);
			threads[i].start();

		}

	}


}
