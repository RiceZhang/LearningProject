package com.github.learning.desigerPattern.factoryMethod.case01.test;

import com.github.learning.desigerPattern.factoryMethod.case01.domain.Product;
import com.github.learning.desigerPattern.factoryMethod.case01.service.Creator;
import com.github.learning.desigerPattern.factoryMethod.case01.service.impl.ConcreteCreator1;
import com.github.learning.desigerPattern.factoryMethod.case01.service.impl.ConcreteCreator2;

/**
 * @author: zhangrx
 * @date: 2016/3/22 21:38
 */
public class ClientTest {

    private static Creator creator1, creator2;
    private static Product prod1, prod2;

    public static void main(String[] args)
    {
        creator1 = new ConcreteCreator1();
        prod1 = creator1.factory();

        creator2 = new ConcreteCreator2();
        prod2 = creator2.factory();

    }
}
