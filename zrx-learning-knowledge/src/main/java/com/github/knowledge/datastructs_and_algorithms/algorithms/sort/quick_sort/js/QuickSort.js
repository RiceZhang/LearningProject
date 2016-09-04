/**
 * 快速排序：JavaScript
 * 
 * @author R 
 */

//快速排序  
function sortQuick(array) {  
	  var low=0,high=array.length-1;  
	  var sort=function(low,high){  
	    if(low==high) {  
	       return;  
	    }  
	    var key=array[low];  
	    var tmplow=low;  
	    var tmphigh=high;  
	    while(low<high) {  
	      while(low<high&&key<=array[high]){  
	        --high;  
	      }  
	      array[low]=array[high];  
	      while(low<high&&array[low]<=key)  
	      {  
	         ++low;  
	      }  
	      array[high]=array[low];  
	      if(low==tmplow){  
	        sort(++low,tmphigh);  
	        return;  
	      }  
	    };  
	    array[low]=key;  
	    sort(tmplow,low-1);  
	    sort(high+1,tmphigh);  
	  };  
	  sort(low,high);  
	  sort();  
	  return array;  
}  