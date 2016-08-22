package com.github.knowledge.datastructs_and_algorithms.data_structures.linear.queue.basic.java;

/*
 *                                           
 *               ------ -------         ------- -------
 *   first --> | Item |  next | ---->  | Item  |  null |  <-- last
 *              ------ -------          ------- -------
 */            
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 队列(FIFO)：java 
 *    思想：具有先进先出功能的 <tt>双端队列 </tt>
 *    一个通用的队列,使用一个单链表实现。
 *    
 * 实现方式： 内部静态类作为结点
 * 
 * @author R
 * @param <E>   -- 泛型
 */
public class Queue<E> implements Iterable<E>  {
   
	private Node<E> first;    // 队列的开始标识
    private Node<E> last;     // 队列的结束标识
    private int N;            // 队列中的元素数量
    

    // 结点：静态实现 ，带泛型 E
    private static class Node<E> {
        private E item;
        private Node<E> next;       
    }

	/**
	 * 初始化一个空队列
	 */
	public Queue() {
		first = null;
		last = null;
		N = 0;
	}
	
	/**
	 * 判断<tt>Queue</tt> 是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return first == null;
	}
	
	/**
	 * 返回<tt>Queue</tt>的 size
	 * @return
	 */
	public int size() {
		return N;  	
	}
	
	/**
	 *  返回一个最近添加到队列的元素
	 * @return
	 */
	public E peek() {
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		return first.item;
	}
	
	/**
	 *  添加 Item 到队列
	 * @param item
	 */
	public void enqueue(E item) {
		Node<E> oldlast = last;
		last = new Node<E>();
		last.item = item;
		last.next = null;
		if (isEmpty())
			first = last;
		else
			oldlast.next = last;
		N++;
	}
	
    /**
     * 移除 并 返回 最近添加到队列的 Item 元素	
     */
 	public E dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        E item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
	}
 	
 	/**
 	 *   重写Object的toString() 方法
 	 */
 	public String toString() {
        StringBuilder s = new StringBuilder();
        for (E item : this)
            s.append(item + " ");
        return s.toString();
 	}
 	
	@Override
	public Iterator<E> iterator() {
        return new ListIterator<E>(first); 
	}
	
    /**
     *  an iterator, doesn't implement remove() since it's optional
     * @author R
     * @param <E>
     */
    private class ListIterator<E> implements Iterator<E> {
    	
    	private Node<E>  current;
    	
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
    	   Queue<String> q = new Queue<String>();
    	   q.enqueue("A");
    	   q.enqueue("C");
    	   System.out.println(q.size());
    	   System.out.println(q.dequeue());
    	   System.out.println(q.size());
    }
}
