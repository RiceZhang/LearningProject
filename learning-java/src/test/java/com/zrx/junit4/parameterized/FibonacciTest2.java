package com.zrx.junit4.parameterized;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * 单元测试 —— 参数测试 注解方法
 * 
 * @author Administrato
 * @date 2017年9月9日
 */
@RunWith(Parameterized.class)
public class FibonacciTest2 {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {{0, 0}, {1, 1}, {2, 1}, {3, 2}, {4, 3}, {5, 5}, {6, 8}});
    }

    @Parameter // first data value (0) is default
    public /* NOT private */ int fInput; // 数组第一个参数为输入参数

    @Parameter(1)
    public /* NOT private */ int fExpected; // 数组第一个参数为 预期参数

    @Test
    public void test() {
        Assert.assertEquals(fExpected, Fibonacci.compute(fInput));
    }
}
