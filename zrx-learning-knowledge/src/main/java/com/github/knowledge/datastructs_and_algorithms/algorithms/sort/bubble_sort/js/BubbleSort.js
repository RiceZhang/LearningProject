/**
 * 冒泡排序:JavaScript
 * 
 *  @author R 
 */

//冒泡排序  
function sortBubble(array){  
  var len=array.length,i,j,tmp;  
  for(i=len-1;i>=1;i--){  
    for(j=0;j<=i-1;j++){  
      if(array[j]>array[j+1]){  
         d=array[j+1];  
         array[j+1]=array[j];  
         array[j]=d;  
      }  
    }  
  }  
  return array;  
}  