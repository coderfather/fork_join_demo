package com.ybb.demo.merge;

/**
 * 
 * @ClassName: MergeTask
 * @Description: 实现归并排序的算法
 * @author admin
 * @date 2019年5月16日
 *
 */
public class MergeMain {

	/**
	 * 
	* @Title: merge
	* @Description: 用于合并两个已经排好顺序的数组
	*              （如左右两边数组均剩一个此方法就为比较大小的方法）
	* @param @param arys 源数组
	* @param @param left 左下边
	* @param @param mid 中间下标
	* @param @param right 又下标
	* @return void    返回类型
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public <T extends Comparable<T>> void merge(T[] arys,int left,int mid,int right) {
		//得到左数组的大小
		int leftSize = mid -left + 1;
		//得到右数组的大小
		int rightSize = right -mid;
		//声明左右数组用于暂存数据
		T[] leftArys = (T[]) new Comparable[leftSize]; 
		for (int i = 0; i < leftArys.length;i++) {
			leftArys[i] = arys[left+i];
		}
		T[] rightArys = (T[]) new Comparable[rightSize];
		for (int i = 0; i < rightArys.length;i++) {
			rightArys[i] = arys[mid+i+1];
		}
		//左数组和右数组进行比较合并，比较完毕后覆盖原数组（arys）
		int l = 0,r=0,temp=left;
		while(l < leftSize && r < rightSize) {
			if( leftArys[l].compareTo(rightArys[r]) < 0) {
				arys[temp++] = leftArys[l++];
			}else {
				arys[temp++] = rightArys[r++];
			}
		}
		//有可能上述操作进行完后，剩下数据未比较，所以将剩下的数据覆盖原数组
		while(l<leftSize) {
			arys[temp++] =leftArys[l++]; 
		}
		while(r<rightSize) {
			arys[temp++] = rightArys[r++];		
		}
	}
	
	/**
	 * 
	* @Title: merge
	* @Description: 排序的主方法，递归的方式，左下标与右下标相差1调用merge方法即可实现排序
	* @param @param arys    源数组
	* @param @param left    左下标
	* @param @param right   右下标
	* @return void    返回类型
	* @throws
	 */
	public <T extends Comparable<T>> void sort(T[] arys,int left,int right) {
		//当left < right递归执行
		if(left < right) {
			//得出mid值
			int mid = (left + right)/2;
			//递归左边数组
			sort(arys, left, mid);
			//递归右边数组
			sort(arys, mid+1,right);
			merge(arys, left, mid, right);
		}
		
	}
	

}
