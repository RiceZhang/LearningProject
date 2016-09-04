package com.github.knowledge.datastructs_and_algorithms.algorithms.sort.bucket_sort.java;

/**
 * 桶排序(稳定)：java
 * 最优复杂度接近O(n) 
 * @author R
 *
 */
public class BucketSort {
	
    /**
     * 桶排序：
     * @param a     --数组
     * @param max   -- 数组a中最大值的范围，如例程中max中的最大值为9，
     *                 则桶的最大下标应为9，则数组大小为10，可以看出是
     *                 一个以空间换时间的算法。
     */
	public static void bucketSort(int[] a, int max) {
		int[] buckets;
		
		if (a==null || max<1) return ;
		
		// 创建一个容量为max的数组buckets，并且将buckets中的所有数据都初始化为0。
		buckets = new int[max];
		

		// 1. 计数
		for(int i = 0; i < a.length; i++)
		{
			buckets[a[i]]++; 
			//System.out.println("func"+buckets[a[i]]+ "boo"+a[i]);
		} 
			
		// 2. 排序
		for (int i = 0, j = 0; i < max; i++) {
			while( (buckets[i]--) >0 ) {
				a[j++] = i;
			}
		}
		
		buckets = null;
			
	}
	
	public static void main(String[] args) {
		int i;
		int a[] = {8,2,3,4,3,6,6,3,9};

		System.out.printf("before sort:");
		for (i=0; i<a.length; i++)
			System.out.printf("%d ", a[i]);
		System.out.printf("\n");

		bucketSort(a, 10); // 桶排序

		System.out.printf("after  sort:");
		for (i=0; i<a.length; i++)
			System.out.printf("%d ", a[i]);
		System.out.printf("\n");
	}
	
}
