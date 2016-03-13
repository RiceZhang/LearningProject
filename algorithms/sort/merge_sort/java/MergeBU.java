package algorithms.sort.merge_sort.java;

/**
 * 归并排序：java
 * @author R
 *
 */
public class MergeBU {
	
    // This class should not be instantiated.
    private MergeBU() { }
    
    // stably merge a[lo..mid] with a[mid+1..hi] using aux[lo..hi]
    private static <T> void merge(Comparable<T>[] a, Comparable<T>[] aux, int lo, int mid, int hi) {

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k]; 
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];  // this copying is unneccessary
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }

    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static  <T> void sort(Comparable<T>[] a) {
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for (int n = 1; n < N; n = n+n) {
            for (int i = 0; i < N-n; i += n+n) {
                int lo = i;
                int m  = i+n-1;
                int hi = Math.min(i+n+n-1, N-1);
                merge(a, aux, lo, m, hi);
            }
        }
        assert isSorted(a);
    }

  /***********************************************************************
    *  Helper sorting functions.
    ***************************************************************************/
    
    // is v < w ?
    private static  boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

   // exchange a[i] and a[j]
    private static  void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


   /***************************************************************************
    *  Check if array is sorted - useful for debugging.
    ***************************************************************************/
    private static <T> boolean isSorted(Comparable<T>[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    // print array to standard output
    private static <T> void show(Comparable<T>[] a) {
        for (int i = 0; i < a.length; i++) {
        	 System.out.print(a[i] + "\t");
        }
        System.out.println("");
    }

    /**
     * Reads in a sequence of strings from standard input; bottom-up
     * mergesorts them; and prints them to standard output in ascending order. 
     */
    public static void main(String[] args) {
    	Comparable[] a = {11,22,33,10,88,37,99,4};
        MergeBU.sort(a);
        show(a);
    }
}
