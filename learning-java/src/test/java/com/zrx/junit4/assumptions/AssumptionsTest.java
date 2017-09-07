package com.zrx.junit4.assumptions;

import java.io.File;

import org.hamcrest.Matchers;
import org.junit.Assume;
import org.junit.Test;


public class AssumptionsTest {

    @Test
    public void filenameIncludesUsername() {
        Assume.assumeThat(File.separatorChar, Matchers.is('/'));
    }

}
