package org.zrx.springframework.samples.mvc.response;

import org.junit.Before;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Function:    ResponseControllerTests
 * Author:      zhangrixiong
 * DateTime:    2016/8/23 15:38
 */
public class ResponseControllerTests {

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = standaloneSetup(new ResponseController()).build();
    }



}
