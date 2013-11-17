package com.baoan.app;

/**
 * Editor: intellij@Ubuntu
 * User: baoan
 * Date: 11/17/13
 * Time: 5:59 PM
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

    @Override
    public boolean equals(Object o) {
        if ( o == this ) {
            return true;
        }
        if ( null == o ) {
            return false;
        }
        TestObject object = (TestObject) o;
        if ( data == object.data ) {
            return true;
        }
        return false;
    }

    int getData() {
        return data;
    }

    void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
