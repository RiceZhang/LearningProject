package com.zrx.junit4.rules;

import org.junit.ClassRule;
import org.junit.rules.ExternalResource;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({A.class, B.class, C.class})
public class UsesExternalResource2 {

    public static final Server myServer = new Server();

    @ClassRule
    public static final ExternalResource resource = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            myServer.connect(); // 连接数据库
        };
        @Override
        protected void after() {
            myServer.disconnect();// 断开数据库
        };
    };
}
class A {
}
class B {
}
class C {}
