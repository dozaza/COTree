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
        * Binary Search an element by using the node
        *
     */
    static Node binarySearch(List<Node> list, Node node) {
        return binarySearch(list, node.getKey());
    }


    /*
        *
        * Binary Search an element by using the node key
        *
     */
    static Node binarySearch(List<Node> list, Comparable key) {
        if ( null == list || list.isEmpty() ) {
            return null;
        }

        int size = list.size();
        int i = 0;
        int j = size - 1;

        while ( i <= j ) {
            int mid = (j + i)/2;
            Node midNode = list.get(mid);
            if ( 0 == key.compareTo(midNode.getKey()) ) {
                return midNode;
            }
            else if ( key.compareTo(midNode.getKey()) < 0 ) {
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

        int size = list.size();
        int i = 0;
        int j  = size - 1;

        while ( j-i > 1 ) {
            int mid = (j + i)/2;
            Node midNode = list.get(mid);
            if ( node.compareTo(midNode) < 0 ) {
                j = mid;
            }
            else {
                i = mid;
            }
        }
        if ( node.compareTo(list.get(i)) < 0 ) {
            list.add(i, node);
        }
        else if ( node.compareTo(list.get(j)) > 0 ) {
            list.add(j + 1, node);
        }
        else if ( node.compareTo(list.get(i)) > 0 && node.compareTo(list.get(j)) < 0 )  {
            list.add(j, node);
        }
    }
}
