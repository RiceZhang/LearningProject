package org.zrx.springframework.samples.mvc.response;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Fynction:    R on 2016/9/3.
 * Author:      zhangrixiong
 * DateTime:    2016/9/3 0:58
 */
public class ResponseControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = standaloneSetup(new ResponseController()).build();
    }

    @Test
    public void responseBody() throws Exception {
        this.mockMvc.perform(get("/response/annotation"))
                .andExpect(status().isOk())
                .andExpect(content().string("The String ResponseBody"));
    }


}