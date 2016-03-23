package com.github.learning.desigerPattern.builder.classBuilder;

/**
 * Class Case : Builder
 * @author: zhangrx
 * @date: 2016/3/23 0:28
 */
public class Director {
    /**
     * @link aggregation
     * @directed
     * @clientRole builder*/
    private Builder builder;

    public Director(Builder builder)
    {
        this.builder = builder;
    }

    public void construct()
    {
        builder = new ConcreteBuilder();

        builder.buildPart1();

        builder.buildPart2();

        builder.retrieveResult();

        //continue with other code
    }
}
