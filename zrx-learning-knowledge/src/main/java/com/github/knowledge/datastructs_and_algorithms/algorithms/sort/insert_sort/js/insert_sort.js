/**
 * 直接插入排序：java
 * 
 * @author R
 *
 */

//插入排序  
function sortInsert(array){  
  var i=1,j,len=array.length,key;  
  for(;i<len;i++){  
    j=i;  
    key=array[j];  
    while(--j>-1){  
      if(array[j]>key){  
        array[j+1]=array[j];  
      }  
      else  
      {  
         break;  
      }  
    }  
    array[j+1]=key;  
  }  
  return array;  
}  