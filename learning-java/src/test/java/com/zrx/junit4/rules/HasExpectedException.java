package com.zrx.junit4.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class HasExpectedException {
    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void throwsNothing() {

    }

    @Test
    public void throwsNullPointerException() {
        thrown.expect(NullPointerException.class);
        throw new NullPointerException();
    }

    @Test
    public void throwsNullPointerExceptionWithMessage() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("happened?");
        throw new NullPointerException("What happened?");
    }
}
