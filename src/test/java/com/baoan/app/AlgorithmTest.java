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
class NonComparableObject {

}

public class AlgorithmTest {



    @Test(expected = NotComparableClassException.class)
    public void testSort() throws NotComparableClassException {
        List<TestObject> mockList = new ArrayList<>();
        List<TestObject> mockList2 = new ArrayList<>();
        List<TestObject> mockList3 = new ArrayList<>();
        List<TestObject> mockList4 = null;
        List<Object> mockList5 = new ArrayList<>();
        List<NonComparableObject> mockList6 = new ArrayList<>();

        for ( int i = 0; i < 10; i++ ) {
            mockList.add(new TestObject(i));
            mockList6.add(new NonComparableObject());
        }
        mockList2.add(new TestObject(1));
        mockList5.add(new Object());

        /*
        Assert.assertEquals(2, Algorithm.binarySearch(mockList, new TestObject(2)));
        Assert.assertEquals(9, Algorithm.binarySearch(mockList, new TestObject(9)));
        Assert.assertEquals(1, Algorithm.binarySearch(mockList, new TestObject(1)));
        Assert.assertEquals(-1, Algorithm.binarySearch(mockList, new TestObject(11)));

        Assert.assertEquals(0, Algorithm.binarySearch(mockList2, new TestObject(1)));
        Assert.assertEquals(-1, Algorithm.binarySearch(mockList3, new TestObject(1)));
        Assert.assertEquals(-1, Algorithm.binarySearch(mockList4, new TestObject(1)));

        Algorithm.binarySearch(mockList6, new TestObject(1));

        Algorithm.binarySearch(mockList5, new TestObject(1));
        */
    }

    @Test(expected = NotComparableClassException.class)
    public void testAddElement() throws NotComparableClassException {
        List<TestObject> mockList = new ArrayList<>();
        List<TestObject> mockList2 = new ArrayList<>();
        List<TestObject> mockList3 = new ArrayList<>();
        List<TestObject> mockList4 = new ArrayList<>();
        List<TestObject> result = new ArrayList<>();
        List<TestObject> result2 = new ArrayList<>();
        List<TestObject> result3 = new ArrayList<>();
        List<TestObject> result4 = new ArrayList<>();

        List<Object> mockList5 = new ArrayList<>();
        List<NonComparableObject> mockList6 = new ArrayList<>();

        for ( int i = 0; i < 10; i++ ) {
            mockList.add(new TestObject(i*2));
            mockList2.add(new TestObject(i*2));
            mockList3.add(new TestObject(i*2));
            mockList4.add(new TestObject(i*2));
            result.add(new TestObject(i*2));
            result2.add(new TestObject(i*2));
            result3.add(new TestObject(i*2));
            result4.add(new TestObject(i*2));
            mockList6.add(new NonComparableObject());
        }
        result.add(2, new TestObject(3));
        result2.add(4, new TestObject(7));
        result3.add(10, new TestObject(20));
        result4.add(0, new TestObject(-2));

        /*
        Algorithm.addElement(mockList, new TestObject(3));
        Algorithm.addElement(mockList2, new TestObject(7));
        Algorithm.addElement(mockList3, new TestObject(20));
        Algorithm.addElement(mockList4, new TestObject(-2));
        */

        Assert.assertArrayEquals(result.toArray(), mockList.toArray());
        Assert.assertArrayEquals(result2.toArray(), mockList2.toArray());
        Assert.assertArrayEquals(result3.toArray(), mockList3.toArray());
        Assert.assertArrayEquals(result4.toArray(), mockList4.toArray());

        //Algorithm.addElement(mockList6, new TestObject(1));
    }

}
