package com.github.knowledge.desigerPattern.decorator.classDecorator;

/**
 * @author: zhangrx
 * @date: 2016/3/23 23:44
 */
public class Decorator implements Component {
    public Decorator(Component component)
    {
//        super();
        this.component = component;
    }

    public Decorator() {
    }

    public void sampleOperation()
    {
        component.sampleOperation();
    }

    /**
     * @link aggregation
     */
    private Component component;
}
