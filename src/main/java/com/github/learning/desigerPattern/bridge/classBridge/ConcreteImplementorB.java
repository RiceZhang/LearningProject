package com.github.learning.desigerPattern.bridge.classBridge;

/**
 * Class Case : Bridge
 * 桥接模式：对抽象父类的方法实现B
 * @author: zhangrx
 * @date: 2016/3/23 0:19
 */
public class ConcreteImplementorB extends Implementor {

    @Override
    public void operationImp() {
        // B 类业务 实现 抽象父类
    }
}
