package com.zrx.junit4.rules.customrules;

import java.util.logging.Logger;

import org.junit.Rule;
import org.junit.Test;

public class MyLoggerTest {
    @Rule
    public final TestLogger logger = new TestLogger();

    @Test
    public void checkOutMyLogger() {
        final Logger log = logger.getLogger();
        log.warning("Your test is showing!");
    }
}
