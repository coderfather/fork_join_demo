package com.ybb.demo.merge;

import java.util.concurrent.RecursiveAction;

/**
 * 
* @ClassName: MergerTask
* @Description: ForkJoin线程池排序的任务类
* @author admin
* @date 2019年5月16日
*
 */
public class MergerTask<T extends Comparable<T>> extends RecursiveAction{
   
	private int left;
	private int right;
	private T[] arys;
	//阈值
	private int threshold=100;
	private MergeMain mergeMain = new MergeMain();
	
	public MergerTask(T[] arys,int left, int right) {
		this.arys = arys;
		this.left = left;
		this.right = right;
	}



	@Override
	public void compute() {
		if(right - left < threshold) {
			mergeMain.sort(arys, left, right);
		}else {
			int mid = (right +left)/2;
			MergerTask leftTask = new MergerTask<>(arys, left, mid);
			MergerTask rightTask = new MergerTask<>(arys, mid+1, right);
			invokeAll(leftTask, rightTask);
			mergeMain.merge(arys, left, mid, right);
		}
		
	}

}
