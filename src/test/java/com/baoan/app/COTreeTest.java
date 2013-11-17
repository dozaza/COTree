package com.baoan.app;

import org.junit.Test;

/**
 * Editor: intellij@Ubuntu
 * User: baoan
 * Date: 11/17/13
 * Time: 5:58 PM
 */
public class COTreeTest {

    @Test
    public void printTest() throws NotComparableClassException {
        COTree tree = new COTree();
        Node root = tree.addRoot(new TestObject(0));
        tree.print();
        System.out.println();

        Node node2 = tree.addNode(root, new Node(new TestObject(2)));
        Node node1 = tree.addNode(root, new Node(new TestObject(1)));
        Node node3 = tree.addNode(node1, new Node(new TestObject(3)));
        Node node4 = tree.addNode(node1, new Node(new TestObject(4)));
        Node node5 = tree.addNode(node1, new Node(new TestObject(5)));

                tree.print();
        System.out.println();
    }
}
