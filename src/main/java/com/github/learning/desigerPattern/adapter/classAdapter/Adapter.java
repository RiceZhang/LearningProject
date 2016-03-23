package com.github.learning.desigerPattern.adapter.classAdapter;

/**
 * Class Case : Adapter
 * 适配器，重新调整被适配者的代码，经典的案例场景就是日志，拦截器授权认证
 * @author: zhangrx
 * @date: 2016/3/23 0:04
 */
public class Adapter extends Adaptee implements Target{

    /**
     * Class Adaptee doesn't contain operation sampleOperation2.
     */
    @Override
    public void sampleOperation2() {
        // 从新写代码，调整被适配者的代码
        System.out.println("执行方法前的日志");
        this.sampleOperation1();
        System.out.println("执行方法后的日志");
    }

}
