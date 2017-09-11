package com.zrx.junit4.rules;

import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Verifier;

public class UsesVerifier {
    
    private static String sequence;
    
    @Rule
    public final Verifier collector = new Verifier() {
        @Override
        protected void verify() {
            sequence += "verify ";
        }
    };

    @Test
    public void example() {
        sequence += "test ";
    }

    @Test
    public void verifierRunsAfterTest() {
        sequence = "";
        Assert.assertThat(testResult(UsesVerifier.class), isSuccessful(null));
        Assert.assertEquals("test verify ", sequence);
    }

    private Matcher isSuccessful(Object object) {
        return null;
    }

    public String testResult(Class<UsesVerifier> class1) {
        // do some thing
        return null;
    }



}
