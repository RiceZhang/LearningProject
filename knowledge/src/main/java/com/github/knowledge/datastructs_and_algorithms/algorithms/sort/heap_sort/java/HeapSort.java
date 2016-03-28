package com.github.knowledge.datastructs_and_algorithms.algorithms.sort.heap_sort.java;

/**
 * 推排序：java
 * 
 * @author R
 *
 */
public class HeapSort {
	
	/**
	 * (最大)堆的向下调整算法
	 * 
	 * @param a      -- 待排序的数组
	 * @param start  -- 被下调节点的起始位置(一般为0，表示从第1个开始)
	 * @param end    -- 截至范围(一般为数组中最后一个元素的索引)
	 */
	public static void maxHeapDown(int[] a, int start, int end) {
		
		int c = start;
		int m = 2*c + 1;
		int tmp = a[c];
		
		for(; m <= end; c = 1, m = 2*m + 1) {
			
			System.out.println("输出m:"+m+"父节点"+tmp);
			// 找最大的子节点
			if( m < end && a[m] < a[m+1])  m++;
			
			//结束循环标识：父节点比左右子节点都大
			if(tmp >= a[m]) 
				   break;
			else { 
				   a[c] = a[m];
				   a[m] = tmp;
				}
		}
	}
	/**
	 * 堆排序(从小到大)
	 * @param a   -- 待排序的数组
	 * @param n   -- 数组的长度
	 */
	public static void heapSortAsc(int[] a, int n) {
	    int i,tmp;
	    
	    for(i = n/2 - 1; i >= 0; i-- )
	    	    maxHeapDown(a, i, n-1);
	    
	    for(i = n - 1; i > 0; i--) {
	           tmp = a[0];
	           a[0] = a[i];
	           a[i] = tmp;
	           //调整
	           maxHeapDown(a, 0, i-1);
	    }
	    
	}
	
	
	
	/**
	 * 堆排序(从大到小)
	 * @param a  -- 待排序的数组
	 * @param n  -- 数组的长度
	 */
	public static void heapSortDesc(int[] a, int n) {
		int i, tmp;

		for (i = n / 2 - 1; i >= 0; i--)
			minHeapDown(a, i, n - 1);

		
		for (i = n - 1; i > 0; i--) {
			tmp = a[0];
			a[0] = a[i];
			a[i] = tmp;
			minHeapDown(a, 0, i - 1);
		}
	}
	/**
	 * 
	 * @param a
	 * @param start
	 * @param end
	 */
	public static void minHeapDown(int[] a, int start, int end) {
			
		    int c = start;			// 当前(current)节点的位置
			int m = 2*c + 1;		// 左(left)孩子的位置
			int tmp = a[c];			// 当前(current)节点的大小
	
			for (; m <= end; c=m, m=2*m+1) {
				// "l"是左孩子，"l+1"是右孩子
				if ( m < end && a[m] > a[m+1])
					m++;		// 左右两孩子中选择较小者
				if (tmp <= a[m])
					break;		// 调整结束
				else {			// 交换值
					a[c] = a[m];
					a[m]= tmp;
				}
			}
	}
	
	
	
	
	/**
	 * 测试用例
	 * @param args
	 */
	public static void main(String[] args) {
		int i;
		//int a[] = {20,30,90,40,70,110,60,10,100,50,80};
	    int a[]= {16,7,3,20,17,8};

		System.out.printf("before sort:");
		for (i=0; i<a.length; i++)
			System.out.printf("%d ", a[i]);
		System.out.printf("\n");

		//heapSortAsc(a, a.length);			// 升序排列
		heapSortDesc(a, a.length);		    // 降序排列

		System.out.printf("after  sort:");
		for (i=0; i<a.length; i++)
			System.out.printf("%d ", a[i]);
		System.out.printf("\n");
	}
	
}
