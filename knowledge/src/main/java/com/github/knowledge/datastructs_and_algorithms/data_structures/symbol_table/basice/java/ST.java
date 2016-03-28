package com.github.knowledge.datastructs_and_algorithms.data_structures.symbol_table.basice.java;


import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeMap;

/**
 * 符号表：ST
 * 依赖： TreeMap -- 排序二叉树的符号表，算法是红黑树实现
 * 
 * @author R
 *
 * @param <K>
 *         -- 泛型键
 * @param <V>
 *         -- 泛型值
 */
public class ST<K extends Comparable<K>, V> implements Iterable<K> {

	private TreeMap<K, V> st;
	
    /**
     * Intitalize an empty symbol table
     */
	public ST() {
	   st = new TreeMap<K, V>();
	}
	
    /**
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table;
     *         <tt>null</tt> if the key is not in the symbol table
     * @throws NullPointerException if <tt>key</tt> is <tt>null</tt>
     */
	public V get(K key) {
		if (key == null) 
			throw new NullPointerException("called get() with null key");
		return st.get(key);
	}
	
    /**
     * Inserts the key-value pair into the symbol table, overwriting the old value
     * with the new value if the key is already in the symbol table.
     * If the value is <tt>null</tt>, this effectively deletes the key from the symbol table.
     *
     * @param  key the key
     * @param  val the value
     * @throws NullPointerException if <tt>key</tt> is <tt>null</tt>
     */
	public void put(K key, V val) {
		if (key == null) 
			throw new NullPointerException("called put() with null key");
		if (val == null) st.remove(key);
		else 			 st.put(key, val);
	}
	
	/**
     * Removes the key and associated value from this symbol table.
     * (if the key is in this symbol table).
	 * @param key
	 */
	public void delete(K key) {
		if (key == null) 
			throw new NullPointerException("called delete() with null key");
		st.remove(key);
	}
	
	/**
	 *  Returns true if this symbol table contain the given key.
	 *  
	 * @param key
	 * @return
	 */
	public boolean contains(K key) {
		if (key == null) 
			throw new NullPointerException("called contains() with null key");
		return st.containsKey(key);
	}
	
    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
	public int size() {
		return st.size();
	}
	
    /**
     * Returns true if this symbol table is empty.
     *
     * @return <tt>true</tt> if this symbol table is empty and <tt>false</tt> otherwise
     */
	public boolean isEmpty() {
		return size() == 0;
	}
	
    /**
     * Returns all keys in this symbol table.
     * <p>
     * To iterate over all of the keys in the symbol table named <tt>st</tt>,
     * use the foreach notation: <tt>for (Key key : st.keys())</tt>.
     *
     * @return all keys in the symbol table
     */
	public Iterable<K> keys() {
	   return st.keySet();	
	}
	
    /**
     * Returns all of the keys in this symbol table.
     */
	@Override
	public Iterator<K> iterator() {
		return st.keySet().iterator();
	}

	/**
	 * Returns the smallest key in this symbol table.
	 * @return
	 */
	public K min() {
		if (isEmpty()) 
			throw new NoSuchElementException("called min() with empty symbol table");
		return st.firstKey();
	}
	
	/**
	 * Returns the largest key in this symbol table.
	 * 
	 * @return
	 */
	public K max() {
		if (isEmpty()) 
			throw new NoSuchElementException("called max() with empty symbol table");
		return st.lastKey();
	}
	
	/**
	 * Returns the smallest key in this symbol table greater than or equal to <tt>key</tt>.
	 * 
	 * @param key
	 * @return
	 */
	public K ceiling(K key) {
		if (key == null) 
			throw new NullPointerException("called ceiling() with null key");
		K k = st.ceilingKey(key); // TreeMap API 取小于或等于以key为键的集合的最大值
		if (k == null) throw new NoSuchElementException("");
		return k;
	}
	
	/**
	 * Returns the largest key in this symbol table less than or equal to <tt>key</tt>
	 * 
	 * @param key
	 * @return
	 */
	public K floor(K key) {
		if (key == null) 
			throw new NullPointerException("called floor() with null key");
		K k = st.floorKey(key); // TreeMap API 大于或等于以key为键的集合的最小值
		if (k == null) 
			throw new NoSuchElementException("all keys are greater than");
		return k;
	}
	
	/**
	 * Unit tests the <tt>ST</tt> data type.
	 * @param args
	 */
	public static void main(String[] args) {
		ST<String, Integer> st = new ST<String, Integer>();
		for (int i=0; i< 20; i++)
		        st.put("A"+i, i);
		
		for (String s : st.keys())
			System.out.println(s + " " + st.get(s));
		
	}
}
