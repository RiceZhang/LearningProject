package com.github.knowledge.datastructs_and_algorithms.algorithms.sort.bubble_sort.java;

/**
 * 冒泡排序：Java
 * 算法分析：
 *    优点：简单，稳定
 *    缺点：算法的效率与输入有关，如果对一个有序的输入进行
 * @author R
 * 
 */
public class BubbleSort {
	
	/**
	 * 冒泡排序 : 找最大的，冒泡,升序
	 * 
	 * @param a  --待排序的数组
	 * @param n  --数组的长度
	 */
	public static void bubbleSort1(int[] a, int n) {
		int i,j;
		for(i=n-1; i>0; i--){
			for(j=0;j<i;j++){
				 if(a[j] > a[j+1] ){   //如果前一个比后一个大，则交换
					 int tmp = a[j];
					 a[j] = a[j+1];
					 a[j+1] = tmp;
				 }
			}
		}
	}
	/**
	 * 冒泡排序:改进版
	 * @param a
	 * @param n
	 */
	public static void bubbleSort2(int[] a, int n) {
		int i,j;
		int flag; 				// 标记

		for (i=n-1; i>0; i--) {
			flag = 0;			// 初始化标记为0
			for (j=0; j<i; j++) {
				if (a[j] > a[j+1]) {
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
					flag = 1;	// 若发生交换，则设标记为1
				}
			}

			if (flag==0)  break;  // 若没发生交换，则说明数列已有序。
				
		}
	}
	

	/**
	 * 冒泡排序:找最小的，冒泡:升序 
	 * @param a
	 * @param n
	 */
	public static void bubbleSort3 (int[] a, int n) {
		int i,j;
		for(i=0;i<n;i++){
			for(j=i+1;j<n;j++){ //交换
				if(a[i] > a[j]) {
					int tmp=a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
			}
		}
	}
	
	/**
	 * 冒泡排序:找最小的，冒泡:升序 （改进）
	 * @param a
	 * @param n
	 */
	public static void bubbleSort4 (int[] a, int n) {
		int i,j;
		int flag; 				// 标记
		for(i=0;i<n;i++){
			flag = 0;			// 初始化标记为0
			for(j=i+1;j<n;j++){ //交换
				if(a[i] > a[j]) {
					int tmp=a[i];
					a[i] = a[j];
					a[j] = tmp;
					flag=1;
				}
			}
			if (flag==0)  break;  // 若没发生交换，则说明数列已有序。
		}
	}
	
	public static void main(String[] args) {
		int i;
		int[] a = {20,40,30,10,60,50};
		System.out.printf("before sort:" + a.length+"\n");
		for (i=0; i<a.length; i++)
			System.out.printf("%d ", a[i]);
		System.out.printf("\n");
		
		bubbleSort3(a, a.length);
		
		System.out.printf("after  sort:" + a.length+"\n");
		for (i=0; i<a.length; i++)
			System.out.printf("%d ", a[i]);
		System.out.printf("\n");
	}
	
}
