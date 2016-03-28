package com.github.knowledge.desigerPattern.factoryMethod.case01.service;

import com.github.knowledge.desigerPattern.factoryMethod.case01.domain.Product;

/**
 * @author: zhangrx
 * @date: 2016/3/22 21:48
 */
public interface Creator {

    /**
     * 业务方法1
     * @return
     */
    public Product factory();


}
