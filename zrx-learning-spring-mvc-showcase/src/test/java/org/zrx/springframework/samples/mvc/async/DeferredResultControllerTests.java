package org.zrx.springframework.samples.mvc.async;

import org.junit.Before;
import org.springframework.test.web.servlet.MockMvc;
import org.zrx.springframework.samples.mvc.AbstractContextControllerTests;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Fynction:    测试延迟结果集合
 * Author:      zhangrixiong
 * DateTime:    2016/8/22 23:34
 */
public class DeferredResultControllerTests  extends AbstractContextControllerTests {

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }
}
