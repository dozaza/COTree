package com.baoan.app;

import java.util.List;

/**
 * Editor: intellij@Ubuntu
 * User: baoan
 * Date: 11/14/13
 * Time: 9:54 PM
 */
class Algorithm {
    /*
        *
        *  Binary Search an element in a java.util.List
        *  The object must inherit Comparable
        *
     */
    static Node binarySearch(List<Node> list, Node node) {
        return binarySearch(list, node.getData());
    }

    /*
        *
        * Binary Search an element by using the node data
        *
     */
    static Node binarySearch(List<Node> list, Comparable nodeData) {
        if ( null == list || list.isEmpty() ) {
            return null;
        }

        int size = list.size();
        int i = 0;
        int j = size - 1;

        while ( i <= j ) {
            int mid = (j + i)/2;
            Node midNode = list.get(mid);
            Comparable compare = midNode.getData();
            if ( 0 == nodeData.compareTo(compare) ) {
                return midNode;
            }
            else if ( nodeData.compareTo(compare) < 0 ) {
                j = mid - 1;
            }
            else {
                i = mid + 1;
            }
        }
        return null;
    }


    /*
        *
        * Add an element into a java.util.List by ensuring the increasing order.
        *
     */
    static void addElement(List<Node> list, Node node) {
        if ( null == list ) {
            throw new NullPointerException("The collection is null");
        }
        if ( list.isEmpty() ) {
            list.add(node);
        }

        Comparable nodeData = node.getData();

        int size = list.size();
        int i = 0;
        int j  = size - 1;

        while ( j-i > 1 ) {
            int mid = (j + i)/2;
            Node midNode = list.get(mid);
            Comparable compare = midNode.getData();
            if ( nodeData.compareTo(compare) < 0 ) {
                j = mid;
            }
            else {
                i = mid;
            }
        }
        if ( nodeData.compareTo(list.get(i).getData()) < 0 ) {
            list.add(i, node);
        }
        else if ( nodeData.compareTo(list.get(j).getData()) > 0 ) {
            list.add(j + 1, node);
        }
        else if ( nodeData.compareTo(list.get(i).getData()) > 0 && nodeData.compareTo(list.get(j).getData()) < 0 )  {
            list.add(j, node);
        }
    }
}
