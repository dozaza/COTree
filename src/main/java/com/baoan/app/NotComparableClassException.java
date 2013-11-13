package com.baoan.app;

/**
 * Editor: intellij@Ubuntu
 * User: baoan
 * Date: 11/13/13
 * Time: 10:01 PM
 */
class NotComparableClassException extends Throwable {

    String className = null;

    NotComparableClassException(String className) {
        this.className = className;
    }

    @Override
    public String getMessage() {
        return "The class " + className + "doesn't implement interface Comparable";
    }

}
