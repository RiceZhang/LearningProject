package com.zrx.junit4.rules.customrules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class IdentityRule implements TestRule {

    @Override
    public Statement apply(Statement base, Description description) {
        return base;
    }

}
