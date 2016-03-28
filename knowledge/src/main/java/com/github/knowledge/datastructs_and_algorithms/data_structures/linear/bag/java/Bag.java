package com.github.knowledge.datastructs_and_algorithms.data_structures.linear.bag.java;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 包：java
 * @author R
 *
 */
public class Bag<E> implements Iterable<E> {
   
	private Node<E> first;    // beginning of bag
    private int N;            // number of elements in bag
    
    // helper linked list class
    private static class Node<E> {
        private E item;
        private Node<E> next;
    }
    
    /**
     *  初始化一个空  Bag
     */
    public Bag() {
        first = null;
        N = 0;
    }
    
    /**
     * 判断 Bag 是否为空
     * @return
     */
    public boolean isEmpty() {
    	return false;
    }
    
    /**
     * 获取 Bag 的大小
     * @return
     */
    public int size() {
    	return N;
    }
    
    /**
     * 添加 Item 到 Bag 中
     * @param item
     */
	public void add(E item) {
		Node<E> oldfirst = first;
		first = new Node<E>();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
    
    
    /**
     * 重载迭代方法 iterator()
     */
	@Override
	public Iterator<E> iterator() {
		return new ListIterator<E>(first);  
	}

	// 内部类：
	private class ListIterator<E> implements Iterator<E> {
		
		private Node<E> current;
		
        public ListIterator(Node<E> first) {
            current = first;
        }
		@Override
		public boolean hasNext() {
			return current != null;     
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
		
		@Override
		public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E item = current.item;
            current = current.next; 
            return item;
		}
	}
	
	/**
	 * Unit tests the <tt>Queue</tt> data type.
	 */
	public static void main(String[] args) {
		Bag<String> bag = new Bag<String>();
		bag.add("A");
		bag.add("B");
		bag.add("C");
		bag.add("D");
        for (String s : bag) {
           System.out.println(s);
        }
	}
}
