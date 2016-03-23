package com.github.learning.desigerPattern.factoryMethod.case01.controller;

import com.github.learning.desigerPattern.factoryMethod.case01.domain.Product;
import com.github.learning.desigerPattern.factoryMethod.case01.service.Creator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 结合springIOC 使用 工厂方法
 * @author: zhangrx
 * @date: 2016/3/22 21:39
 */
public class Client {

    @Resource(name="concreteCreator1")
    private Creator creator1;
    @Resource(name="concreteCreator2")
    private  Creator creator2;

    private Product prod1, prod2;

    @RequestMapping("/collect")
    @ResponseBody
    public void action(HttpServletRequest request)
    {
        //creator1 = new ConcreteCreator1();
        prod1 = creator1.factory();
        //creator2 = new ConcreteCreator2();
        prod2 = creator2.factory();
    }
}
