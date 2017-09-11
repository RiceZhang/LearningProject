package com.zrx.junit4.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runners.model.TestTimedOutException;

public class HasGlobalTimeout {

    public static String log;

    @Rule
    public final TestRule globalTimeout = Timeout.millis(20);

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Test()
    public void testInfiniteLoop1() {
        log += "ran1";
        thrown.expect(TestTimedOutException.class);
        for (;;) {}
    }


    @Test(expected = TestTimedOutException.class)
    public void testInfiniteLoop2() {
        log += "ran2";
        thrown.expect(TestTimedOutException.class); // 如果只是 @Test(expected =
                                                    // TestTimedOutException.class) 取代
                                                    // thrown.expect(TestTimedOutException.class)
                                                    // 是会测试失败的
        for (;;) {}
    }
}
