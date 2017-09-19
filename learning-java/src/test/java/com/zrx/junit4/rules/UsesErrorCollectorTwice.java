package com.zrx.junit4.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

/**
 * 解析：
 * 
 * @author Administrato
 * @date 2017年9月9日
 */
public class UsesErrorCollectorTwice {
    @Rule
    public final ErrorCollector collector = new ErrorCollector();

    @Test
    public void example() {
        collector.addError(new Throwable("first thing went wrong"));
        collector.addError(new Throwable("second thing went wrong"));
    }
}
