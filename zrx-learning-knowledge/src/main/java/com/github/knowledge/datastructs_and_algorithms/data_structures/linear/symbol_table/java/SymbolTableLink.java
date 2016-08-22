package com.github.knowledge.datastructs_and_algorithms.data_structures.linear.symbol_table.java;

/**
 * 符号表：java
 * 特殊的链表 —— 符号表（一般用树结构来做）:
 * 我们实现遵循的原则：
 *   1：每一个键只对应着一个值（表中不允许存在重复的键）
 *   2：当用例代码向表中存入的键值对和表中已有的键（即关联的值）冲突时，新的值会替换旧的值
 * 
 * @author R
 *
 */
public class SymbolTableLink<K, V> {
    
	private Node head;
	
	// 结点内部类
	private class Node {
	     private K key;
	     private V val;
	     private Node next;
	     
	     public Node(K key, V val) {
			this.key = key;
			this.val = val;
			this.next = null;
		}
	     
	}
	
	public SymbolTableLink() {
	  head=new Node(null,null);
	}
	
	public void put(K key, V val) {
		
	}
	
	public void get(K key) {
		
	}
	
	public void delete(K key) {
		
	}
	
	public void contains() {
		
	}
	
	public void isEmpty() {
		
	}
	
	public int size() {
		return 0;
	}
	
	/*****************************************
	 * 单元测试
	 *****************************************/
	public static void main(String[] args) {

	}
}
