package com.baoan.app;

import java.util.ArrayList;
import java.util.List;

/**
 * Editor: intellij@Ubuntu
 * User: baoan
 * Date: 11/13/13
 * Time: 9:57 PM
 */
class Node<T extends Comparable> {
    private T t = null;
    private List<T> children = null;
    private T parent = null;


    Node(T t) throws NotComparableClassException {
        if ( t instanceof Comparable) {
            this.t = t;
        }
        else {
            throw new NotComparableClassException(t.getClass().getName());
        }
    }

    List<T> getChildren() {
        return children;
    }

    void addChild(T child) throws NotComparableClassException {
        if ( null == children ) {
            children = new ArrayList<>();
        }

        Algorithm.addElement(children, child);
    }

    void addChildren(List<T> children) throws NotComparableClassException {
        if ( null == children ) {
            children = new ArrayList<>();
        }
        for ( T child : children ) {
            addChild(child);
        }
    }

    T getParent() {
        return parent;
    }

    void setParent(T parent) {
        this.parent = parent;
    }
}

