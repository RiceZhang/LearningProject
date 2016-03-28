package com.github.knowledge.desigerPattern.chainofresp.classChainofresp;

/**
 * @author: zhangrx
 * @date: 2016/3/23 23:20
 */
public class ConcreteHandler extends Handler {

    @Override
    public void handleRequest() {
        if (getSuccessor() != null) {
            System.out.println("The request is passed to " + getSuccessor());
            getSuccessor().handleRequest();
        }
        else {
            System.out.println("The request is handled here.");
        }
    }
}
