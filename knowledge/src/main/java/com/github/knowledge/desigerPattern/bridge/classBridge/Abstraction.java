package com.github.knowledge.desigerPattern.bridge.classBridge;

/**
 * Class Case : Bridge
 * 桥接模式：抽象类聚合 Implementor
 * @author: zhangrx
 * @date: 2016/3/23 0:12
 */
abstract public class Abstraction {

    public void operation() {
        imp.operationImp();
    }

    /**
     * @link aggregation
     * @directed
     * @supplierRole impl*/
    private Implementor imp;

}
