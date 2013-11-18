package com.baoan.app;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 * Editor: intellij@Ubuntu
 * User: baoan
 * Date: 11/13/13
 * Time: 9:57 PM
 */
public abstract class Node implements Comparable{
    // Not serialized by gson
    private transient Comparable key = null;

    private List<Node> children = null;
    private Node parent = null;
    private boolean leaf = true;


    /*
        *
        * Constructor, create the primitive data of a Node
        * Parent of this Node is initialized with null
        *
     */
    public Node(Comparable key) {
        this.key = key;
    }

    /*
        *
        * Constructor, create the primitive data of a Node
        * Parent is defined by the parameter
        *
     */
    public Node(Comparable key, Node parent) {
        this.key = key;
        this.parent = parent;
    }

    /*
        *
        * Comparison with any Object
        *
     */
    @Override
    public abstract boolean equals(Object o);


    /*
        *
        * convert node to String
        *
     */
    @Override
    public abstract String toString();

    /*
        *
        * Comparison with the key of node
        *
     */
    @Override
    public final int compareTo(Object o) {
        if ( o instanceof Node ) {
            return key.compareTo(((Node) o).getKey());
        }
        else if ( o instanceof Comparable ) {
            return key.compareTo(o);
        }
        throw new ClassCastException(o.getClass().getName() + " does not implement interface Comparable" );
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
        leaf = false;
        return child;
    }

    /*
        *
        * Add several children into the children list
        *
     */
    public void addChildren(List<Node> children) throws NotComparableClassException {
        if ( null == children ) {
            children = new ArrayList<>();
        }
        for ( Node child : children ) {
            addChild(child);
        }
        leaf = false;
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
        * Getter of Key
        * Key is the unique and comparable symbol of a node
        *
     */
    public abstract Comparable getKey();

    /*
        *
        * Abstract method needed to be override by sub-class
        * Key is used to specify a Node when doing search
        *
     */
    //public abstract Object getKey();
}

