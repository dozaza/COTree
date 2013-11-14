package com.baoan.app;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Editor: intellij@Ubuntu
 * User: baoan
 * Date: 11/14/13
 * Time: 10:31 PM
 */
class TestObject implements Comparable<TestObject> {
    private int data = 0;

    public TestObject(int data) {
        this.data = data;
    }

    @Override
    public int compareTo(TestObject o) {
        if ( data == o.data ) {
            return 0;
        }
        else if ( data > o.data ) {
            return 1;
        }
        else {
            return -1;
        }
    }

    int getData() {
        return data;
    }

    void setData(int data) {
        this.data = data;
    }
}

public class AlgorithmTest {
    List<TestObject> mockList = new ArrayList<>();
    List<TestObject> mockList2 = new ArrayList<>();
    List<TestObject> mockList3 = new ArrayList<>();
    List<TestObject> mockList4 = null;
    List<Object> mockList5 = new ArrayList<>();

    @Test(expected = NotComparableClassException.class)
    public void testSort() throws NotComparableClassException {
        for ( int i = 0; i < 10; i++ ) {
            mockList.add(new TestObject(i));
        }

        mockList2.add(new TestObject(1));

        mockList5.add(new Object());

        Assert.assertEquals(2, Algorithm.binarySearch(mockList, new TestObject(2)));
        Assert.assertEquals(9, Algorithm.binarySearch(mockList, new TestObject(9)));
        Assert.assertEquals(1, Algorithm.binarySearch(mockList, new TestObject(1)));
        Assert.assertEquals(-1, Algorithm.binarySearch(mockList, new TestObject(11)));

        Assert.assertEquals(0, Algorithm.binarySearch(mockList2, new TestObject(1)));
        Assert.assertEquals(-1, Algorithm.binarySearch(mockList3, new TestObject(1)));
        Assert.assertEquals(-1, Algorithm.binarySearch(mockList4, new TestObject(1)));

        Assert.assertEquals(-1, Algorithm.binarySearch(mockList5, new TestObject(1)));
    }

}
