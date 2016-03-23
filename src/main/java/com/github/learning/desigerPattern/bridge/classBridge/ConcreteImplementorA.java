package com.github.learning.desigerPattern.bridge.classBridge;

/**
 * Class Case : Bridge
 * 桥接模式：对抽象父类的方法实现A
 * @author: zhangrx
 * @date: 2016/3/23 0:18
 */
public class ConcreteImplementorA  extends Implementor {

    @Override
    public void operationImp() {
        // A 类业务 实现 抽象父类
    }

}
