package com.github.knowledge.datastructs_and_algorithms.algorithms.sort.insert_sort.java;

/**
 * 直接插入排序：java
 * 插入排序思想：
 * @author R
 *
 */
public class Insert {
	
	/**
	 * 直接插入排序
	 * @param a  -- 待排序的数组
	 * @param n  -- 数组的长度
	 */
	public static void insertSort(int[] a) {
		int i, j, t, h;
		for (i = 1; i < a.length; i++) {
			t = a[i];
			j = i - 1;
			while (j >= 0 && t < a[j]) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = t;

			System.out.print("第" + i + "步排序结果:"); // 输出每步排序的结果
			for (h = 0; h < a.length; h++) {
				System.out.print(" " + a[h]); // 输出
			}
			System.out.print("\n");
		}
	}
	
	/**
	 * 测试用例
	 * @param args
	 */
	public static void main(String[] args) {
		int i;
		int[] a = {20,40,30,10,60,50};

		System.out.printf("before sort:");
		for (i=0; i<a.length; i++)
			System.out.printf("%d ", a[i]);
		System.out.printf("\n");

		insertSort(a);

		System.out.printf("after  sort:");
		for (i=0; i<a.length; i++)
			System.out.printf("%d ", a[i]);
		System.out.printf("\n");
	}
	
}
