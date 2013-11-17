package com.baoan.app;

import java.util.List;

/**
 * Editor: intellij@Ubuntu
 * User: baoan
 * Date: 11/16/13
 * Time: 6:04 PM
 */
public class COTree<T extends  Comparable> {
    private Node<T> root = null;
    private Node<T> lastTouch = null;

    /*
        *
        * Constructor, create a COTree whose root is null
        *
     */
    public COTree() {
        root = null;
        lastTouch = null;
    }

    /*
        *
        * Constructor , create a COTree and define its root
        *
     */
    public COTree(T t) throws NotComparableClassException {
        this.root = new Node<>(t);
        this.lastTouch = root;
    }

    /*
        *
        * Add a root into a COTree
        * Attention: if you add a new root to an existing COTree, all nodes will be lost
        *
     */
    public void addRoot(T t) throws NotComparableClassException {
        this.root = new Node<>(t);
        lastTouch = root;
    }

    /*
        *
        * Add a new child into a parent
        *
     */
    public void addNode(Node<T> parent, Node<T> node) throws NotComparableClassException {
        parent.addChild(node);
    }

    /*
        *
        * Add children into a parent
        *
     */
    public void addNodes(Node<T> parent, List<Node> nodes) throws NotComparableClassException {
        parent.addChildren(nodes);
    }

    /*
        *
        * Recursively find a Node
        *
     */
    public Node find(T t) {
        if ( null == root ) {
            return null;
        }
        return findImpl(root.getChildren(), t);
    }

    /*
        *
        * Implementation of find method.
        *
     */
    private Node findImpl(List<Node> children, T t) {
        if ( null == children || children.isEmpty() ) {
            return null;
        }
        Node result = Algorithm.binarySearch(children, t);
        if ( result != null ) {
            return result;
        }
        else {
            for ( Node child : children ) {
                Node result2 = findImpl(child.getChildren(), t);
                if ( result2 != null ) {
                    return result2;
                }
            }
        }
        return null;
    }
}
