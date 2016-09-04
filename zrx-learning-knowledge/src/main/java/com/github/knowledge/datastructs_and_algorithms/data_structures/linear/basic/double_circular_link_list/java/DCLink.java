package com.github.knowledge.datastructs_and_algorithms.data_structures.linear.basic.double_circular_link_list.java;


/**
 * 双向循环链表: java
 * @author R
 *
 */
public class DCLink<T> {
 
    private Node head;  // 头部
	
    
	// 单结点
	private class Node {
		private Node prev;
		private Node next;
		private T val;
		public Node(T val) {
			this.val = val;
			prev = null;
			next = null;
		}
		public Node(T val, Node prev, Node next) {
		    this.val = val;
		    this.prev = prev;
		    this.next = next;
		}
		
		public void displayNode() {
			System.out.print("-->val:" + val);
		}
	}
	
	/**
	 * 构造一个空的双向循环链表
	 */
	public DCLink() {
	    head = new Node(null);
	    head.next = head;
	    head.prev = head; // 判断空为 curr.next ! = head 或 curr.prev != head 
	}
	
	// 获取链表的结点数
	public int size() {
		return getSize();
	}
	private int getSize() {
		Node curr = head;
		int j=0;
		while(curr.next.val != null){
			curr = curr.next;
			j++;
		}
		return j;
	}
	
	// 判断链表是否为空 
	public boolean isEmpty() {
		return (head.next == head);
	}
	
	// 将节点插入到第index位置之前
	public void insert(int index, T val) {
		Node x= new Node(val);
		Node curr ;
		if (index == 0) {
           curr = head;
           x.next = curr.next;
           x.prev = curr;
           
           curr.prev = x;
           curr.next = x;
		}
		else {
			// 添加到curr 前
			curr = getNode(index);
		    x.next = curr;       // 新结点的后结点
		    x.prev = curr.prev;  // 新结点的前结点
		    
		    curr.prev.next = x;  // 前结点
		    curr.prev = x;       // old结点前结点
		}
	    return;
	}
	private Node getNode(int index) {
		int mCount = size();
		if (index<0 || index >= mCount)
			throw new IndexOutOfBoundsException();
		
		// 正向查找
		if (index <= mCount/2) {
			Node curr = head.next;
			int j=0;
			while(j < index) {
				curr = curr.next;
				j++;
			}
			return curr;
		}
		
		// 反向查找
		Node rcurr = head.prev;
		int rindex = mCount - index -1;
		int k=0;
		while(k < index) {
			rcurr = rcurr.prev;
			k++;
		}
		return rcurr;
	}
	
	// 添加数据到表头
	public void insertFirst(T val) {
		insert(0,val);
	}
	
	// 添加数据到末尾
	public void appendLast(T val) {
		Node x = new Node(val, head.prev, head);
		head.prev.next = x;
		head.prev = x;
	}
	
	public void display() {
		Node curr = head;
		while(curr.next.val != null) {
			curr = curr.next;
			curr.displayNode();
		}
		System.out.println(" ");
	}
	
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
		theList.getNode(3);
		
	}
}
