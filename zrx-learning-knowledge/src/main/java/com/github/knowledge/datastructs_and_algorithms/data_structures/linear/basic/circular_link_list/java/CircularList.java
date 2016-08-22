package com.github.knowledge.datastructs_and_algorithms.data_structures.linear.basic.circular_link_list.java;

import java.util.NoSuchElementException;



/**
 * 循环链表：java
 *     循环链表与单链表最重要的区别是：
 *     尾结点的指针，不再是p->next = null;
 *     而是：p->next=head。判空：head==head->next;rear==rear->next;
 * @author R
 *
 */
public class CircularList<T> {
    
	private Node head; // 头
	private Node rear; // 尾

	private class Node {
		private T val;
		private Node next;
		
		public Node(T val) {
			this.val = val;
			this.next=null;
		}
		
        public T getVal() {
        	return this.val;
        }
		public void dispalyNode() {
			System.out.print("-->val:" + this.getVal());
		}
	}
	
	/**
	 * 构造空的循环链表
	 */
	public CircularList() {
		this.head = new Node(null);
		rear = head;
		rear.next=head;
	}
	
	/**
	 * 判断空的循环链表
	 * @return
	 */
	public boolean isEmpty() {
		return (head == head.next);
	}
	

	public boolean isContain(Object o) {
		return false;
	}
	
	public int size() {
        Node curr = head;
        int size = 0;
        while(curr.next != head) {
        	size++; curr = curr.next;
        }
		return size;
	}
	
	public T get(int index) {
		if(index <= 0) {
        	//获取第1个
			return head.next.val;
        }
        if(index > 0 && index <= size()) {
        	Node curr = head;
        	int j=0;
        	while(curr.next != head) {
        		if(j == index) break; 	
        		curr = curr.next;
        		j++;
        	}
        	return curr.val;
        }
        else {
        	return rear.val;
        }
	}
	
	// 在循环链表的头添加新的结点
	public void insertFirst(T val) {
        Node x = new Node(val);
        if(isEmpty()) {
        	rear = x;
        }
        x.next = head.next;
        head.next = x; 
        rear.next = head;
	}
	
	// 在循环链表的尾添加新的结点
	public void insertLast(T val) {
       Node x = new Node(val);
       if(isEmpty()) {
    	   head.next = x;
       }
       rear.next = x;
       rear = x;
       rear.next = head;
	}
	
	// 在索引后插入
    public void insertByIndex(int index, T val) {
		Node curr = head;
		int j = 0;
		while (curr.next != head) {
			if (j == index)
				break;
			curr = curr.next;
			j++;
		}
		Node x = new Node(val);
	    x.next = curr.next;
		curr.next = x;
    }
	
    // 删除循环表中的所有的数据元素
    public void removeAll() {
        Node curr = head;
        while(curr.next != head) {        	
        	curr =curr.next;
            head.next = curr.next;
        }
        rear = head;
        rear.next = head;
    }
    
    
    // 删除指定位置的元素，并返回删除值
    public T remove(int index) {
    	if(index <=0 || index > size()) 
    		throw new NoSuchElementException("called remove() but index not a userful pars");
    	Node curr = head.next;
    	Node prev = head;
    	int j = 0;
    	while(curr != head) {    		
    		j++;
    		if(j == index) {
    			prev.next = curr.next;
    			curr.next = null;
    			break;
    		}
    		prev = curr;
    		curr = curr.next;
    	}
    	return curr.getVal();
    }
	
    // 删除表头元素，并返回删除值
    public T removeHead() {
    	if (isEmpty()) 
    		throw new NoSuchElementException("called removeHead() but is Empty");
    	Node curr = head.next;
    	head.next = curr.next;// 删除头与尾无关，只要改变head.next指向就可以    	
    	return curr.getVal();
    }
    
    // 删除表尾元素，并返回删除值
    public T removeRear() {
    	if (isEmpty()) 
    		throw new NoSuchElementException("called removeRear() but is Empty");
    	Node prev = head;
    	while(prev.next != rear){
    		prev = prev.next;
    	}
    	T e = prev.next.getVal();
    	prev.next = rear.next;
    	rear = prev;
    	return e;
    }
    
    // 修改指定位置的元素，并将原来的数据返回
    public T set(int index, T val) {

    	if(index <= 0 ) {
        	return  head.next.val;
        } 
    	if(index > size()) {
    		return rear.val;
    	}
    	else {
    		Node curr = head;
    		int j=0;
    		T e = null;
    		while(curr.next != head) {
    			curr = curr.next;
    			j++;
    			if(j == index) {
    				e = curr.val;
    				curr.val = val;
    			    break;
    			}    			
    		}
    		return e;
    	}  
    }
    
    
    // 重写toString() 方法
//    public String toString() {
//    	return null;
//    }
    
    
    public void display() {
		 System.out.println("遍历循环链表");
		 if(isEmpty()) System.out.println("空链表");
		 Node curr = this.head;
		 while(curr.next != head) {
			 curr = curr.next;
			 curr.dispalyNode();
		 }
		 System.out.println(" ");
    }
    
    /**
     * 单元测试
     * @param args
     */
    public static void main(String[] args) {
    	CircularList<Integer> theList = new CircularList<Integer>();
        System.out.println(theList.isEmpty());
    	theList.insertFirst(3);
    	theList.insertFirst(4);
    	theList.insertFirst(7);
    	System.out.println(theList.isEmpty());
    	theList.insertLast(12);
    	theList.insertLast(15);
    	theList.display();
    	theList.insertByIndex(2, 45);
    	theList.display();
    	theList.remove(2);
    	theList.display();
    	System.out.println("获取最后一个："+theList.get(100));
    	theList.display();
    	//theList.removeAll();
    	theList.display();
    	System.out.println(theList.isEmpty());
    	System.out.println(theList.size());
    	theList.set(1, 9);
    	System.out.println(theList.get(1));
    	
    }
}
