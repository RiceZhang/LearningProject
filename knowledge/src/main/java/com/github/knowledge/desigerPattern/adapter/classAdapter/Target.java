package com.github.knowledge.desigerPattern.adapter.classAdapter;

/**
 * Class Case : Adapter
 * 适配器接口，供给调用客户使用
 * @author: zhangrx
 * @date: 2016/3/22 23:58
 */
public interface Target {

    /**
     * Class Adaptee contains operation sampleOperation1.
     */
    void sampleOperation1();

    /**
     * Class Adaptee doesn't contain operation sampleOperation2.
     */
    void sampleOperation2();

}
