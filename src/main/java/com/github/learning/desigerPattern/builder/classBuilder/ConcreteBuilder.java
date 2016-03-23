package com.github.learning.desigerPattern.builder.classBuilder;

/**
 * Class Case : Builder
 * 构建器模式：实现构建器
 * @author: zhangrx
 * @date: 2016/3/23 0:28
 */
public class ConcreteBuilder extends Builder {

    /**
     * @label Creates
     */
    private Product product = new Product() ;

    public void buildPart1()
    {
        //build the first part of the product
    }

    public void buildPart2()
    {
        //build the second part of the product
    }

    public Product retrieveResult()
    {
        return product;
    }

}
