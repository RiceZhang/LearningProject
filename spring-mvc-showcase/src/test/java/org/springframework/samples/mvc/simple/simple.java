package org.springframework.samples.mvc.simple;

import org.junit.Test;
import org.springframework.http.MediaType;

/**
 * Created by R on 2016/4/23.
 */

public class SimpleControllerRevisitedTests {

    @Test
    public void simple() throws Exception {
        standaloneSetup(new SimpleControllerRevisited()).build()
                .perform(get("/simple/revisited").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain"))
                .andExpect(content().string("Hello world revisited!"));
    }

}
