package com.github.learning.desigerPattern.chainofresp.classChainofresp;

/**
 * @author: zhangrx
 * @date: 2016/3/23 23:14
 */
abstract public class Handler {

    /**
     * @link aggregation
     * @supplierCardinality 0..1
     */
    protected Handler successor;

    public abstract void handleRequest();

    public void setSuccessor(Handler successor)
    {
        this.successor = successor;
    }

    public Handler getSuccessor()
    {
        return successor;
    }

}
