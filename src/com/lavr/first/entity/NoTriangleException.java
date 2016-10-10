package com.lavr.first.entity;

/**
 * Created by 123 on 25.09.2016.
 */
public class NoTriangleException extends Exception {

    NoTriangleException(){}

    NoTriangleException(Throwable e){
        super(e);
    }

    public NoTriangleException(String message) {
        super(message);
    }

    public NoTriangleException(String message, Throwable cause) {
        super(message, cause);
    }
}
