package com.baoan.app;

import java.util.Collection;

/**
 * Editor: intellij@Ubuntu
 * User: baoan
 * Date: 11/14/13
 * Time: 9:54 PM
 */
class Algorithm {
    static int binarySearch(Collection collection, Comparable object) throws NotComparableClassException {
        if ( null == collection || collection.isEmpty() ) {
            return -1;
        }
        Object[] array = collection.toArray();
        int size = collection.size();
        int i = 0;
        int j = size - 1;

        while ( i <= j ) {
            int mid = (j + i)/2;
            if ( !(array[mid] instanceof Comparable) ) {
                throw new NotComparableClassException(array[mid].getClass().getName());
            }
            Comparable compare = (Comparable) array[mid];
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
}
