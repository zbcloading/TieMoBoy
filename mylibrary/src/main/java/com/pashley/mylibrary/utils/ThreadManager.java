package com.pashley.mylibrary.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadManager {

	private ExecutorService executor;
	
	private static ThreadManager instance = new ThreadManager();
	
	private ThreadManager(){
		executor = Executors.newFixedThreadPool(2);
	}
	
	public static ThreadManager getInstance(){
		return instance;
	}
	
	public void execute(Runnable r){
		executor.execute(r);
	}
	
	public void execute(Thread t){
		executor.execute(t);
	}
	
	public void close(){
		executor = null;
	}
	
	public static void main(String[] args){
		
//		for(int i=0;i<10;i++){
//			ThreadManager.getInstance().execute(new Runnable(){
//
//				@Override
//				public void run() {
//					try {
//						System.out.println(Thread.currentThread().getName());
//						Thread.sleep(60*1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//				}
//				
//			
//			});
//		}
		
		System.out.println("dsss");
		
	}
	
}
