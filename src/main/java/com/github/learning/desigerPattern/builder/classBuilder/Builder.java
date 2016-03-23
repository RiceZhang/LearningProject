package com.github.learning.desigerPattern.builder.classBuilder;

/**
 * Class Case : Builder
 * 构建器模式：构建者
 * @author: zhangrx
 * @date: 2016/3/23 0:26
 */
abstract public class Builder {

    public abstract void buildPart1();

    public abstract void buildPart2();

    public abstract Product retrieveResult();
}
