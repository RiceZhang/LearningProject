数据结构：线性表
==================
>一般对线性表的操作可以包含如下几种：
```java
// 建立一个空的线性表。
public  linklist()
// 将collection c 中的数据依次建立一个线性表。
public linklist(collection c)  
//  返回线性表的第一个元素　　
public object getfirst()  
// 返回线性表的最后一个元素　
public object getlast()
// 删除线性表的第一个元素，并返回删除的值
public object removefirst()
// 删除线性表的最后一个元素，并返回删除的值
public object removelast()
// 在线性表头添加一个元素
public void addfirst(object o)
// 在线性表尾添加一个元素
public void addlast(object o)
// 在线性表中是否存在o元素，如果存在，则返回true 否则 返回 false
public boolean contains(object o)
// 返回在线性表中的元素个数
public int size()
// 添加到线性表的尾部，并返回true
public boolean add(object o)
// 把第一次出现的元素删除，成功返回true,否则返回false
public boolean remove(object o)
// 将collection  中的元素依次插入到尾部
public addAll(collection c)
// 在index中依次插入collection 中的元素，在合并成一个链表
public addAll( int index, collection c)
// 删除所有的元素
public void clear()
// 返回线性表中的第index位置的元素
public object get(int index)
// 在index位置修改一个元素
public object set(int index,object element)
// 在index位置添加一个元素
public void add(int index,object element)
// 删除index位置的元素，并返回删除的值
public object remove(int index)
// 获取元素第一次出现位置的的索引，若不存在返回-1
public int indexOf(object o)
// 获取元素最后一次出现位置的的索引，若不存在返回-1
public int lastindexOf(object o)
// 返回线性表中index位置开始的内容
public listiterator(int index)
```
#线性表——顺序存储
> 算法分析

#线性表——非顺序存储
> 算法分析

