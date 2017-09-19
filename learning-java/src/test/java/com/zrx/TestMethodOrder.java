package com.zrx;

import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import org.junit.runners.model.TestTimedOutException;

/**
 * @author 张日雄
 * @date 2017-09-10 21:50
 * @since 1.0
 */
@FixMethodOrder(MethodSorters.DEFAULT)
public class TestMethodOrder {

    @Test(timeout = 1000,expected = TestTimedOutException.class)
    public void testA() {
        System.out.println("first");
        for (;;){}// 必然会抛出超时异常
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test(timeout = 1000)
    public void testB() {
        thrown.expect(TestTimedOutException.class);
        for(;;){}
    }

}
