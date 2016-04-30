package org.springframework.samples.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by R on 2016/4/24.
 * 测试父类
 */
@WebAppConfiguration
@ContextConfiguration("file:/src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
//@ContextConfiguration(locations = { "classpath*:spring-context.xml" })
public class AbstractContextControllerTests {

    @Autowired
    protected WebApplicationContext wac;

}
