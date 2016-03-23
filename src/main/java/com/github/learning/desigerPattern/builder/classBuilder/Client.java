package com.github.learning.desigerPattern.builder.classBuilder;

/**
 * Class Case : Builder
 * @author: zhangrx
 * @date: 2016/3/23 0:27
 */
public class Client {
    /**
     * @link aggregation
     * @directed
     */
    private Director director;

    private Builder builder = new ConcreteBuilder();

    public void requestBuild()
    {
        director = new Director(builder);
    }
}
