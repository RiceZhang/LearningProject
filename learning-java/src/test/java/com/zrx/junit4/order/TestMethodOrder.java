package com.zrx.junit4.order;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


/**
 * <p>
 * 从4.11版本开始,JUnit将默认使用一个确定的,但不可预测的顺序( MethodSorters.DEFAULT )。
 * </p>
 * <p>
 * 要改变测试执行的顺序只需要在测试类(class)上使用 @FixMethodOrder 注解,并指定一个可用的MethodSorter即可:
 * <p>
 * @FixMethodOrder(MethodSorters.JVM) : 保留测试方法的执行顺序为JVM返回的顺序。每次测试的执行顺序有可能会所不同。
 * </p>
 * <p>
 * @FixMethodOrder(MethodSorters.NAME_ASCENDING) :根据测试方法的方法名排序,按照词典排序规则(ASC,从小到大,递增)。
 * </p>
 * 
 * @author Administrato
 * @date 2017年9月6日
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMethodOrder {

    @Test
    public void testC() {
        System.out.println("third");
    }

    @Test
    public void testB() {
        System.out.println("second");
    }

    @Test
    public void testA() {
        System.out.println("first");
    }
}
