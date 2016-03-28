package com.github.knowledge.datastructs_and_algorithms.data_structures.linear.basic.single_link_list.java;
/**
 * 数据结构： 线性表——单向链表
 * 在使用单链表结点时，必须完成3步：
 * 1：创建一个新的节点；
 * @author R
 *
 */
public class SingleLink<T> {
	 //表头
     private Node mHead;
     //节点个数
     private int mCount;
     
     //单向链表“节点”对应的结构体
     private class Node {
    	 private Node next;
    	 private T value;
    	 
    	 public Node(T value){
    		 this.value = value;
    		 
    	 }//end Node constructor
    	 
     }//end class Node
     
     /*
      * 单向链表 ： 构造函数
      */
     public SingleLink() {
	
	    //创建“表头”。注意表头没有存储数据！
    	 this.mHead = null;
    	 
    	// 初始化“节点个数”为0
    	 this.mCount = 0;
	}
     
     public void insertFirst(T obj){  
    	 Node newNode = new Node(obj);
    	 newNode.next = this.mHead;
    	 this.mHead = newNode;
    	 this.mCount++;
     }
     public T deleteFirst() throws Exception{ 
    	 if(this.mHead== null) throw new Exception("empty!");   
    	 Node temp = this.mHead;
    	 this.mHead = this.mHead.next;
    	 this.mCount--;
    	 return (T) temp.value;
     }

     public T find(T obj) throws Exception{
    	 if(this.mHead == null)  
    		 throw new Exception("LinkedList is empty!");  
    	 Node curr = this.mHead;
    	 T e =null;
    	 while(curr != null){
    		 if(curr.value.equals(obj)) e= curr.value; 
    		 curr = curr.next;
    	 }
    	 return e;	 
     }
     
     public void remove(Object obj) throws Exception{ 
    	 if(this.mHead == null)  throw new Exception("LinkedList is empty!");   
    	 
    	 if(this.mHead.value.equals(obj)) 
    	 { this.mHead = this.mHead.next;}
    	 else{
    		Node prev = this.mHead;
    		Node curr = this.mHead.next;
    		while(curr != null){ 
    			if( curr.value.equals(obj) ) { prev.next = curr.next;this.mCount--;}
    		    prev = curr;		
    			curr = curr.next;
    		}
    	 }
     }
     public  boolean isEmpty(){ 
    	 return (this.mHead==null);
     }
     
     public void display(){
    	 if(this.mHead == null){
    		 System.out.println("empty");  
    	 }
    	 Node curr = this.mHead;
    	 while(curr != null){
    		 System.out.print(curr.value.toString() + " -> ");  
    		 curr = curr.next;
    	 }
    	 System.out.print("\n");  
     }
     
     // 测试
     public static void main(String[] args) throws Exception{
    	 SingleLink<Integer> slink = new SingleLink<Integer>();
    	 slink.insertFirst(5);
    	 slink.insertFirst(3);  
    	 slink.insertFirst(13);
    	 slink.insertFirst(8); 
    	 slink.insertFirst(9);  
    	 slink.insertFirst(19);  
    	 slink.display();
    	 slink.deleteFirst();
    	 slink.display();
     }
     
}
