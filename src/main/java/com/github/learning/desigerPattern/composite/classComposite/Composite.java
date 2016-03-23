package com.github.learning.desigerPattern.composite.classComposite;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author: zhangrx
 * @date: 2016/3/23 23:36
 */
public class Composite implements Component {

    @Override
    public Composite getComposite() {
        return this;
    }

    @Override
    public void sampleOperation() {
        java.util.Enumeration enumeration = components();
        while (enumeration.hasMoreElements())
        {
            ((Component)enumeration.nextElement()).sampleOperation();
        }
    }


    public void add(Component component)
    {
        componentVector.addElement(component);
    }

    public void remove(Component component)
    {
        componentVector.removeElement(component);
    }

    public Enumeration components()
    {
        return componentVector.elements();
    }

    /**
     * @associates <{Component}>
     * @link aggregation
     * @supplierCardinality 0..*
     */
    private Vector componentVector = new java.util.Vector();

}
