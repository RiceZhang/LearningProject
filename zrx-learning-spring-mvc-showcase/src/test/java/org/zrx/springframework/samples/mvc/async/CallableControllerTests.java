package org.zrx.springframework.samples.mvc.async;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.zrx.springframework.samples.mvc.AbstractContextControllerTests;

import static org.hamcrest.Matchers.instanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


/**
 * Function: 模拟 Spring-MVC 异步数据参试
 * Created by R on 2016/8/22.
 *
 * 参考资料：
 *     mockMVC: [](http://jinnianshilongnian.iteye.com/blog/2004660 "开涛博客")
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class CallableControllerTests extends AbstractContextControllerTests {

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    /**
     * 测试异步请求返回的 请求体 ( 代码整洁，就尽量减小写注释，但还是手痒了)
     * @throws Exception
     */
    @Test
    public void responseBody() throws Exception {
        // 采用mock 框架 发送模拟请求
        MvcResult mvcResult = this.mockMvc.perform(get("/async/callable/response-body"))
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult("Callable result"))
                .andReturn();

        // 采用mock 框架 测试返回的结果，包括1）状态吗status ，2）报文数据类型, 3)返回的结果
        this.mockMvc.perform(asyncDispatch(mvcResult))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))  //utf-8
                .andExpect(content().string("Callable result"));
    }

    /**
     * 异步请求视图结果（html jade（最近jade好像改名了） 或其他模版）
     * @throws Exception
     */
    @Test
    public void view() throws Exception {
        // Mock 异步请求 视图页面
        MvcResult mvcResult = this.mockMvc.perform(get("/async/callable/view"))
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult("views/html"))
                .andReturn();

        // 测试结果，并校验参数 'foo' , 'fruit'
        this.mockMvc.perform(asyncDispatch(mvcResult))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/views/views/html.jsp"))
                .andExpect(model().attribute("foo","bar"))
                .andExpect(model().attribute("fruit","apple"));
    }

    /**
     * 测试异常：
     * @throws Exception
     */
    @Test
    public void exception() throws Exception {
        // 发送请求
        MvcResult mvcResult = this.mockMvc.perform(get("/async/callable/exception"))
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult(instanceOf(IllegalStateException.class)))
                .andReturn();
        // 请求结果
        this.mockMvc.perform(asyncDispatch(mvcResult))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(content().string("Handled exception:Callable error"));

    }



}
