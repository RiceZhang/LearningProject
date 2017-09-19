package com.zrx.junit4.parameterized;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * 单元测试 —— 参数测试 构造方法
 * 
 * @author Administrato
 * @date 2017年9月9日
 */
@RunWith(Parameterized.class)
public class FibonacciTest {

    @Parameters
    public static Collection<Object[]> data() {
        /* 数组第一个 为 参数， 第二个为 期望结果 */
        return Arrays.asList(new Object[][] {{0, 0}, {1, 1}, {2, 1}, {3, 2}, {4, 3}, {5, 5}, {6, 8}});
    }

    private int fInput;

    private int fExpected;

    public FibonacciTest(int input, int expected) {
        fInput = input;
        fExpected = expected;
    }

    @Test
    public void test() {
        Assert.assertEquals(fExpected, Fibonacci.compute(fInput));
    }
}
