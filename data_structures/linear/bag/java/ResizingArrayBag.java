package data_structures.linear.bag.java;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayBag<E> implements Iterable<E> {
   
	private E[] a;         // array of items
    private int N;            // number of elements on stack
	
	/**
	 * Initializes an empty bag.
	 */
	@SuppressWarnings("unchecked")
	public ResizingArrayBag() {
		a = (E[]) new Object[2];
		N = 0;
	}
    
    /**
     * Is this bag empty?
     * @return true if this bag is empty; false otherwise
     */
    public boolean isEmpty() {
        return N == 0;
    }
	
    
    /**
     * Returns the number of items in this bag.
     * @return the number of items in this bag
     */
    public int size() {
        return N;
    }
    
    // resize the underlying array holding the elements
    @SuppressWarnings("unchecked")
	private void resize(int capacity) {
        assert capacity >= N;
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;
    }
    
    /**
     * Adds the item to this bag.
     * @param item the item to add to this bag
     */
    public void add(E item) {
        if (N == a.length) resize(2*a.length);    // double size of array if necessary
        a[N++] = item;                            // add item
    }
    
    /**
     * Returns an iterator that iterates over the items in the bag in arbitrary order.
     * @return an iterator that iterates over the items in the bag in arbitrary order
     */
	@Override
	public Iterator<E> iterator() {
		return new ArrayIterator();
	}

    // an iterator, doesn't implement remove() since it's optional
    private class ArrayIterator implements Iterator<E> {
        private int i = 0;
        public boolean hasNext()  { return i < N;                               }
        public void remove()      { throw new UnsupportedOperationException();  }

        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i++];
        }
    }
    
    
    
	/**
	 * Unit tests the <tt>Queue</tt> data type.
	 */
	public static void main(String[] args) {
         
	}
	
	
}
