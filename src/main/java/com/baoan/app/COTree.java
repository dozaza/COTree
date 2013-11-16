package com.baoan.app;

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
    public void addNode(Node<Comparable> parent, Node<Comparable> node) {
    }

    /*
        *
        * Recursively find a Node
        *
     */
    private Node find(T t) {
        Node node = null;
        return node;
    }
}
