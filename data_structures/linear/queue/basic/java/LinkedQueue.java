package data_structures.linear.queue.basic.java;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 队列FIFO: java 
 * @author R
 * @param <E>
 */
public class LinkedQueue<E> implements Iterable<E> {

	private int N;      // 在队列中元素的数量
	private Node first; // 队列的开始
	private Node last;  // 队列的结束
	
	// 结点 ：非静态实现
	private class Node {
		private E item;
		private Node next;
	}
	
    /**
     * 初始化一个空链表
     */
    public LinkedQueue() {
        first = null;
        last  = null;
        N = 0;
        assert check();
    }
    
    
    public boolean isEmpty() {
    	return first == null;
    }
    
    public int size() {
    	return N; 
    }
    
    /**
     * 返回一个最近添加到队列的元素
     * @return
     */
    public E peek() {
		if (isEmpty())
			throw new NoSuchElementException("Queue underflow");
		return first.item;
    }
    
    /**
     * 添加  Item 到队列 
     * @param item
     */
    public void enqueue(E item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        N++;
        assert check();
    }
    
    /**
     * 删除 并返回  最新 添加的 Item 
     * @return
     */
    public E dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        E item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = null;   // to avoid loitering
        assert check();
        return item;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (E item : this)
            s.append(item + " ");
        return s.toString();
    }

    // 检查内部不变量
    private boolean check() {
		if (N < 0) {
			return false;
		} else if (N == 0) {
			if (first != null)
				return false;
			if (last != null)
				return false;
		} else if (N == 1) {
			if (first == null || last == null)
				return false;
			if (first != last)
				return false;
			if (first.next != null)
				return false;
		} else {
			if (first == null || last == null)
				return false;
			if (first == last)
				return false;
			if (first.next == null)
				return false;
			if (last.next != null)
				return false;

			// check internal consistency of instance variable N
			int numberOfNodes = 0;
			for (Node x = first; x != null && numberOfNodes <= N; x = x.next) {
				numberOfNodes++;
			}
			if (numberOfNodes != N)
				return false;

			// check internal consistency of instance variable last
			Node lastNode = first;
			while (lastNode.next != null) {
				lastNode = lastNode.next;
			}
			if (last != lastNode)
				return false;
		}

		return true;
    }
    
	@Override
	public Iterator<E> iterator() {
		return new ListIterator();  
	}

	/**
	 * 内部类：List迭代器实现
	 * @author R
	 */
	private class ListIterator implements Iterator<E> {
		
		private Node current = first;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
		
		@Override
		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();
			E item = current.item;
			current = current.next;
			return item;
		}
          
	}
	
    /**
     * Unit tests the <tt>Queue</tt> data type.
     */
	public static void main(String[] args) {
	   LinkedQueue<String> q = new LinkedQueue<String>();
  	   q.enqueue("A");
  	   q.enqueue("C");
  	   q.enqueue("D");
       for(int i=0; q.size()>0;i++) {
    	   System.out.println(q.dequeue());    	      
       }
	}
}
