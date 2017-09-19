package com.zrx.junit4.parameterized;

/**
 * 被测试方法类
 * 
 * @author zrx
 * @date 2017年9月9日
 */
public class Fibonacci {
    public static int compute(int n) {
        int result = 0;

        if (n <= 1) {
            result = n;
        } else {
            result = compute(n - 1) + compute(n - 2);
        }

        return result;
    }
}
