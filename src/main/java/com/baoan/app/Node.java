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
    private List<Node> children = null;
    private Node parent = null;


    /*
        *
        * Constructor, create the primitive data of a Node
        * Parent of this Node is initialized with null
        *
     */
    public Node(T t) throws NotComparableClassException {
        if ( !(t instanceof Comparable) )  {
            throw new NotComparableClassException(t.getClass().getName());
        }
        this.t = t;
    }

    /*
        *
        * Constructor, create the primitive data of a Node
        * Parent is defined by the parameter
        *
     */
    public Node(T t, Node parent) throws NotComparableClassException {
        if ( !(t instanceof Comparable) )  {
            throw new NotComparableClassException(t.getClass().getName());
        }
        this.t = t;
        this.parent = parent;
    }

    /*
        *
        * Comparison with any Object
        *
     */
    @Override
    public boolean equals(Object o) {
        return null != o && (this == o || o instanceof Node && ((Node) o).t.equals(t));
    }

    /*
        *
        * Comparison with a primitive data
        *
     */
    public boolean equals(T t) {
        return this.t.equals(t);
    }

    /*
        *
        * convert node to String
        *
     */
    @Override
    public String toString() {
        return t.toString();
    }

    /*
        *
        * Getter of children list
        *
     */
    public List<Node> getChildren() {
        return children;
    }

    /*
        *
        * Add a new child into the list and ensure the order by algorithm
        *
     */
    public Node addChild(Node child) throws NotComparableClassException {
        if ( null == children ) {
            children = new ArrayList<>();
        }

        Algorithm.addElement(children, child);
        return this;
    }

    /*
        *
        * Add several children into the children list
        *
     */
    public Node addChildren(List<Node> children) throws NotComparableClassException {
        if ( null == children ) {
            children = new ArrayList<>();
        }
        for ( Node child : children ) {
            addChild(child);
        }
        return this;
    }


    /*
        *
        * Getter of Parent Node
        *
     */
    public Node getParent() {
        return parent;
    }

    /*
        *
        * Setter of Parent Node
        *
     */
    public void setParent(Node parent) {
        this.parent = parent;
    }

    /*
        *
        * Getter of primitive data
        *
     */
    public T getData() {
        return t;
    }

    /*
        *
        * Abstract method needed to be override by sub-class
        * Key is used to specify a Node when doing search
        *
     */
    //public abstract Object getKey();
}

