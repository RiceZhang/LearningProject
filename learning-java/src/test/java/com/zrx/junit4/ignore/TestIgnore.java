package com.zrx.junit4.ignore;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class TestIgnore {

    @Ignore("Test is ignored as a demonstration")
    @Test
    public void testSame() {
        Assert.assertThat(1, Matchers.is(1));
    }

}
