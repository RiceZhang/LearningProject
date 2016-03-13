package algorithms.sort.insert_sort.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 插入排序：java
 *  思想：两两比较，两两交换知直到a[0]
 * @author R
 *
 */
public class InsertSort {
	
	// This class should not be instantiated.
	private InsertSort() {
	}
	
	// 排序实现 ： 泛型 T 实现 做一个限制：T 必须是Comparable类或其子类
	public static <T> void insertSort(Comparable<T>[] a) {
	    	int i,j;
		    for(i = 1; i< a.length; i++) {
               for(j = i-1;j>=0 && less(a[j+1], a[j]); j--) { // a[j+1] < a[j] 就交换
            	     exch(a, j, j+1);
               } 
	    	}
		    assert isSorted(a);
	}
	
	/***************************************************************************
	 * Helper sorting functions.
	 ***************************************************************************/
	// 必须是Comparable 或Comparable的子类才可以比较
    private static <T> boolean less(Comparable<T> v, Comparable<T> w) {
        return v.compareTo((T) w) < 0;
    }
	
    // exchange a[i] and a[j]
    private static  void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
   
	/***************************************************************************
	 * Check if array is sorted - useful for debugging.
	 ***************************************************************************/	
    private static <T> boolean isSorted(Comparable<T>[] a) {
    	return isSorted(a, 0, a.length - 1);
    }

    private static <T> boolean isSorted(Comparable<T>[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
	
    // print array to standard output
    private static <T> void show(T[] a) {
        for (int i = 0; i < a.length; i++) {
        	System.out.print(a[i]+" ");
        }
        System.out.println("");
    }
    
	/***************************************************************************
	 *  Hellper getting test data functions.
	 * @throws IOException 
	 ***************************************************************************/
    
    // 获取要测试的数据,以字符为单位获取数据
    private static List getData(String filePath) throws IOException {
        
    	String currentClassPath =  InsertSort.class.getResource("").getPath();
        
    	String encoding="UTF-8";
    	
    	File file=new File(currentClassPath + filePath);
    	
    	if(!file.isFile() || !file.exists())
    		throw new NoSuchFieldError("ERROR: 文件路劲有误，请检查该文件是否存在？");
    	
    	//List<Integer> list = readFile(file,encoding);
    	List<Integer> list = readLine(file,encoding);
    	
    	
//        for (Integer i : list){
//            System.out.print(i);
//            System.out.print(" ");
//        }
//       System.out.println();
    	return list;
	}
    
    // 按空格读取测试数据data.txt文件
    private static List  readFile(File file, String encoding) throws IOException {
		InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
		BufferedReader bufferedReader = new BufferedReader(read);

		int lineTxt = 0;
		String string = "";
		List list = new ArrayList();

		while ((lineTxt = bufferedReader.read()) != -1) {
			if (((char) lineTxt) != '\r') {
				System.out.print((char) lineTxt);
				string = string + String.valueOf((char) lineTxt);
				if ((char) lineTxt == ' ') {
					list.add(Integer.parseInt(string.toString().trim()));
					string = "";
				}
			}
		}
		if (((char) lineTxt) != '\r') {
			System.out.print((char) lineTxt);
			list.add(Integer.parseInt(string.trim().toString()));
		}
		read.close();
		return list;
    }
    
    // 按行读取测试数据dataLine.txt文件
    private  static List readLine(File file, String encoding) throws IOException {
    	List list=new ArrayList();
    	InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
    	BufferedReader bufferedReader = new BufferedReader(read);
    	String lineTxt = null;
    	while((lineTxt = bufferedReader.readLine()) != null){
    		if(!"".equals(lineTxt.toString().trim())){
    		   list.add(Integer.parseInt(lineTxt.toString().trim()));
    		}
    	}
		read.close();
		return list;
    }
    
    
    // 随机产生测试数据文件
    private static void createTestDataRandom(String filePath,int start,int end,int much) throws IOException {
    	
    	// 当前类的路径
    	String currentClassPath =  InsertSort.class.getResource("").getPath().replace("bin", "src");
    	String encoding="UTF-8";
    	File file=new File(currentClassPath + filePath);
    	if(file.exists()) file.delete();
    	if(!file.exists()){
    	     System.out.println("文件不存在！，自动新建一个文件");	
    	     file.createNewFile();
    	}
    	
        // 写入数据
    	writeFileLine(file,start,end,much);
    	
    }
    
    // 一行一行 写入文件信息
    /**
     * 
     * @param file
     * @param bound -- 绑定数具的范围[0,bound) 
     * @param much  -- 产生多少个数
     * @throws IOException
     */
    private static void writeFileLine(File file, int start,int end, int much) throws IOException {
    
    	FileWriter fw=new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		
		Random rand = new Random();
		
		for (int i=0;i<much;i++) {
			bw.write(rand.nextInt(end) + start + "\t\n");
		}
		bw.close();
		fw.close();
    }
    
    
    /*********************************************************************
     * Unit Test
     * @param args
     * @throws IOException 
     ********************************************************************/
	public static void main(String[] args) throws IOException {
		
		// [10,1000) 中随机的50个数
		// InsertSort.createTestDataRandom("data_int100.txt",10,1000,50);
		
		List list=InsertSort.getData("data_int100.txt");
		Integer[] arry = (Integer[]) list.toArray(new Integer[list.size()]); ;
		System.out.println("before:");
		InsertSort.show(arry);
		InsertSort.insertSort(arry);
		System.out.println("after:");
		InsertSort.show(arry);

	}
}
