package org.zrx.springframework.samples.mvc.redirect;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Fynction:    R on 2016/9/2.
 * @author:      zhangrixiong
 * @dateTime:    2016/9/2 0:55
 */
public class RedirectControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = standaloneSetup(new RedirectController(new DefaultFormattingConversionService()))
                .alwaysExpect(status().isTemporaryRedirect()).build();
    }

    @Test
    public void uriTemplate() throws Exception {
        this.mockMvc.perform(get("/redirect/uriTemplate"))
                .andExpect(redirectedUrl("/redirect/a123?date=12%2F31%2F11"));
    }

    @Test
    public void uriComponentsBuilder() throws Exception {
        this.mockMvc.perform(get("/redirect/uriComponentsBuilder"))
                .andExpect(redirectedUrl("/redirect/a123?date=12/31/11"));
    }
}