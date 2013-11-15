package com.baoan.app;

import java.util.List;

/**
 * Editor: intellij@Ubuntu
 * User: baoan
 * Date: 11/14/13
 * Time: 9:54 PM
 */
class Algorithm {
    static int binarySearch(List list, Comparable object) throws NotComparableClassException {
        if ( null == list || list.isEmpty() ) {
            return -1;
        }

        int size = list.size();
        int i = 0;
        int j = size - 1;

        while ( i <= j ) {
            int mid = (j + i)/2;
            Object midObject = list.get(mid);
            if ( !(midObject instanceof Comparable) ) {
                System.out.println(midObject.getClass().getName());
                throw new NotComparableClassException(midObject.getClass().getName());
            }

            Comparable compare = (Comparable) midObject;
            if ( 0 == object.compareTo(compare) ) {
                return mid;
            }
            else if ( object.compareTo(compare) < 0 ) {
                j = mid - 1;
            }
            else {
                i = mid + 1;
            }
        }
        return -1;
    }

    static void addElement(List list, Comparable object) throws NotComparableClassException {
        if ( null == list ) {
            throw new NullPointerException("The collection is null");
        }
        if ( list.isEmpty() ) {
            list.add(object);
        }

        int size = list.size();
        int i = 0;
        int j  = size - 1;

        while ( j-i > 1 ) {
            int mid = (j + i)/2;
            Object midObject = list.get(mid);
            if ( !(midObject instanceof Comparable) ) {
                System.out.println(midObject.getClass().getName());
                throw new NotComparableClassException(midObject.getClass().getName());
            }

            Comparable compare = (Comparable) midObject;
            if ( object.compareTo(compare) < 0 ) {
                j = mid;
            }
            else {
                i = mid;
            }
        }
        if ( object.compareTo(list.get(i)) < 0 ) {
            list.add(i, object);
        }
        else if ( object.compareTo(list.get(j)) > 0 ) {
            list.add(j + 1, object);
        }
        else if ( object.compareTo(list.get(i)) > 0 && object.compareTo(list.get(j)) < 0 )  {
            list.add(j, object);
        }
    }
}
