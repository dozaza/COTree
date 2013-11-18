package com.baoan.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

/**
 * Editor: intellij@Ubuntu
 * User: baoan
 * Date: 11/16/13
 * Time: 6:04 PM
 */
public class COTree {
    private Node root = null;
    private Node lastTouch = null;

    private final Gson gson;

    /*
        *
        * Constructor, create a COTree whose root is null
        *
     */
    public COTree() {
        GsonBuilder builder = new GsonBuilder();
        gson = builder.create();

        root = null;
        lastTouch = null;
    }

    /*
        *
        * Constructor , create a COTree and define its root
        *
     */
    public COTree(Node root) throws NotComparableClassException {
        GsonBuilder builder = new GsonBuilder();
        gson = builder.create();

        this.root = root;
        this.lastTouch = root;
    }

    /*
        *
        * Add a root into a COTree
        * Attention: if you add a new root to an existing COTree, all nodes will be lost
        * return the root
        *
     */
    public Node addRoot(Node root) throws NotComparableClassException {
        this.root = root;
        lastTouch = root;
        return lastTouch;
    }

    /*
        *
        * Add a new child into a parent
        * return the parent
        *
     */
    public Node addNode(Node parent, Node node) throws NotComparableClassException {
        return parent.addChild(node);
    }

    /*
        *
        * Add children into a parent
        * return the parent
        *
     */
    public void addNodes(Node parent, List<Node> nodes) throws NotComparableClassException {
        parent.addChildren(nodes);
    }

    /*
        *
        * Recursively find a Node
        *
     */
    public Node find(Comparable key) {
        if ( null == root ) {
            return null;
        }
        else if ( root.getKey().equals(key) ) {
            return root;
        }
        return findImpl(root.getChildren(), key);
    }

    /*
        *
        * Implementation of find method.
        *
     */
    private Node findImpl(List<Node> children, Comparable key) {
        if ( null == children || children.isEmpty() ) {
            return null;
        }
        Node result = Algorithm.binarySearch(children, key);
        if ( result != null ) {
            return result;
        }
        else {
            for ( Node child : children ) {
                Node result2 = findImpl(child.getChildren(), key);
                if ( result2 != null ) {
                    return result2;
                }
            }
        }
        return null;
    }

    /*
        *
        * Print the tree
        *
     */
    public void print() {
        //TODO: need to find a way
    }

    /*
        *
        * Covert to json string
        *
     */
    public String toJson() {
        return gson.toJson(root);
    }
}
