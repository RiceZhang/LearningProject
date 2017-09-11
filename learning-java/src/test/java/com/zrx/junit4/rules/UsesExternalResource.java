package com.zrx.junit4.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

/**
 * 解析：
 * 
 * @author Administrato
 * @date 2017年9月9日
 */
public class UsesExternalResource {

    Server myServer = new Server();

    @Rule
    public final ExternalResource resource = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            myServer.connect();// 执行测试前
        };

        @Override
        protected void after() {
            myServer.disconnect();// 执行测试后
        };
    };

    @Test
    public void testFoo() {
        new Client().run(myServer);
    }
}


class Client {
    public static void run(Server server) {

    }
}

class Server {
    public void connect() {

    }

    public void disconnect() {

    }
}
