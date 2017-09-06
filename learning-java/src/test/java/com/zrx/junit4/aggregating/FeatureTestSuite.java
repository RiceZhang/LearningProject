package com.zrx.junit4.aggregating;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 聚合测试
 * 
 * <p>
 * Aggregating tests in suites
 * </p>
 * 
 * @author Administrato
 * @date 2017年9月6日
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TestFeatureLogin.class, TestFeatureLogout.class, TestFeatureNavigate.class
})

public class FeatureTestSuite {
    // the class remains empty,
    // used only as a holder for the above annotations
}
