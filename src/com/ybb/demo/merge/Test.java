package com.ybb.demo.merge;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Test {
	
	public static void main(String[] args) throws InterruptedException {
		//模拟数组
		Integer[] arys = new Integer[10000];
		Random random = new Random();
		for (int i = 0; i < arys.length; i++) {
			arys[i] = random.nextInt(100);
		}
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		MergerTask<Integer> task = new MergerTask<Integer>(arys,0,arys.length-1);
		forkJoinPool.invoke(task);
		for (Integer integer : arys) {
			System.out.print("\t"+integer);
		}
	}
	
}
