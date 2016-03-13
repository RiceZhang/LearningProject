package data_structures.linear.basic.first_last_list.java;
/**
 * 双端链表：java
 *    对单向链表的改进：多加了一个未指针tail
 * @author R
 *
 */
public class FirstLastList<T> {
    
	private Node head; //头指针
	private Node tail; //尾指针
	
	/**
	 * @author R
	 * @param <T>
	 */
	private class Node {
       private Node next;
       private T val;
       
       public Node(T val) {
    	   this.val = val;
    	   this.next = null;
       }
       
       public void dispalyNode() {
    	   System.out.print("val:" + this.val);
       }
	}
	
	/**
	 * 构造空循环链表的 构造函数
	 */
	public FirstLastList() {
		this.head = null;
		this.tail = null;
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public void insertFirst(T val) {
		Node newNode = new Node(val);
		if (isEmpty()) 
			this.tail = newNode;
		newNode.next = this.head;  // 赋值 newNode.next --> old firstNode;
		this.head = newNode;       //指向新加的结点为头结点
	}
	
	public void insertLast(T val) {
		Node newNode = new Node(val);
		if (isEmpty())  this.head = newNode;
		else 			this.tail.next = newNode; // 连接新结点
		
		this.tail = newNode; //重新定位tail
	}
	
	
	public void dispalyList() {
		 System.out.println("遍历循环链表或双端队表");
		 Node curr = this.head;
		 while(curr != null) {
			 curr.dispalyNode();
			 curr = curr.next;
		 }
		 System.out.println(" ");
	}
	
	/**
	 * 单元测试
	 * @param args
	 */
	public static void main(String[] args) {
		FirstLastList<Integer> theList = new FirstLastList<Integer>();
		theList.insertFirst(4);
		theList.insertFirst(6);
		theList.insertLast(9);
		theList.insertFirst(10);
		theList.dispalyList();
	}
}
