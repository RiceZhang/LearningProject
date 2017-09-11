package com.zrx.junit4.rules;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * 测试使用 规则 链
 * 
 * @author Administrato
 * @date 2017年9月9日
 */
public class UseRuleChain {
    @Rule
    public final TestRule chain = RuleChain.outerRule(new LoggingRule("outer rule")).around(new LoggingRule("middle rule"))
                    .around(new LoggingRule("inner rule"));

    @Test
    public void example() {
        assertTrue(true);
    }
}


/**
 * 自定义规则 {@link Rule}
 * 
 * @author Administrato
 * @date 2017年9月9日
 */
class LoggingRule implements TestRule {

    public LoggingRule(String string) {
        // TODO Auto-generated constructor stub
    }

    @Override
    public Statement apply(Statement base, Description description) {
        // TODO Auto-generated method stub
        return null;
    }

}
