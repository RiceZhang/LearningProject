package com.github.knowledge.datastructs_and_algorithms.data_structures.linear.basic.double_circular_link_list.java;

import com.github.learning.datastructs_and_algorithm.data_structures.linear.basic.double_circular_link_list.java.DCLink;

public class DCLinkTest {
	
	public static void main(String[] args) {
		
		DCLink<Integer> theList = new DCLink<Integer>();
		System.out.println("链表结点数：" + theList.size());
		System.out.println("判断为空：" + theList.isEmpty());
		theList.insertFirst(12);
		theList.display();
		System.out.println("链表结点数：" + theList.size());
		System.out.println("判断为空：" + theList.isEmpty());
		theList.appendLast(34);
		theList.appendLast(3);
		theList.appendLast(4);
		theList.display();
		System.out.println("链表结点数：" + theList.size());
		System.out.println("判断为空：" + theList.isEmpty());
		
	}
}
