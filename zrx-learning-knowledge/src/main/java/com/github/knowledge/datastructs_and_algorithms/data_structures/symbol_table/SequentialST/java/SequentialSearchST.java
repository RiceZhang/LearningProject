package com.github.knowledge.datastructs_and_algorithms.data_structures.symbol_table.SequentialST.java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 椤哄簭缁撴瀯鐨勭鍙疯〃
 * @author R
 *
 * @param <K>
 * @param <V>
 */
public class SequentialSearchST<K, V> {
    private int N;           // number of key-value pairs
    private Node first;      // the linked list of key-value pairs
    
    // 鍐呴儴绫伙細杩炴帴鐨勯『搴忚〃鐨勮妭鐐�
    private class Node {
        private K key;
        private V val;
        private Node next;

        public Node(K key, V val, Node next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }
    
    /**
     * 鍒濆鍖栦竴涓┖鐨勬湁搴忕鍙疯〃
     */
    public SequentialSearchST() {
	}
    
    /**
     * 
     * @return
     */
    public int size() {
    	return N;
    }
    
    /**
     * 
     * @return
     */
    public boolean isEmpty() {
    	return size() == 0;
    }
    
    /**
     * 
     * @param key
     * @return
     */
    public boolean contains(K key) {
    	return get(key) != null;
    }
    
    /**
     * 
     * @param key
     * @return
     */
    public V get(K key) {
    	for (Node x = first; x != null; x = x.next) {
    		if (key.equals(x.key)) return x.val;
    	}
    	return null;
    }
    
    /**
     * 
     * @param key
     * @param val
     */
    public void put(K key, V val) {
    	if (val == null) {
    		delete(key);
    		return;
    	}
        
    	for (Node x = first; x != null; x = x.next) {
    		if (key.equals(x.val)) {
    			x.val = val;
    			return;
    		}
    	}
    	
    	first = new Node(key, val, first);
    	N++;
    }
    
    /**
     * 
     * @param key
     */
    public void delete(K key) {
    	first = delete(first, key);
    }
    private Node delete(Node x, K key) {
    	if (x == null) return null;
    	if (key.equals(x.key)) {
    		N--;
    		return x.next;
    	}
    	x.next = delete(x.next, key);
    	return x;
    }
    
    /**
     * 
     * @return
     */
    public Iterable<K> keys() {
        Queue<K> queue = new LinkedList<K>();
        for (Node x = first; x != null; x = x.next)
            queue.offer(x.key);
        return queue;
    }
    
    
    /**
     * 鍗曞厓娴嬭瘯
     * @param args
     */
    public static void main(String[] args) {
    	SequentialSearchST<String,Integer> st = new SequentialSearchST<String,Integer>();
    	for (int i = 0; i<20; i++) {
    		st.put("A"+i, i);
    	}
    	
    	for (String s : st.keys())
    		System.out.println(s + " " + st.get(s));
    }
}

/**********************************************
 *             blog:
 *                  
 *
 **********************************************/