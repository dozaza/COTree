package com.baoan.app;

import java.util.LinkedList;
import java.util.List;

/**
 * Editor: intellij@Ubuntu
 * User: baoan
 * Date: 11/13/13
 * Time: 9:57 PM
 */
class Node<T> {
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

    void addChild(T child) {
        if ( null == children ) {
            children = new LinkedList<T>();
        }
        //TODO: need to use binary search to find position
        children.add(child);
    }

    void addChildren(List<T> children) {
        if ( null == children ) {
            children = new LinkedList<T>();
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

