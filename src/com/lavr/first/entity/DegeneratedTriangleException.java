package com.lavr.first.entity;

/**
 * Created by 123 on 25.09.2016.
 */
public class DegeneratedTriangleException extends Exception {
    public DegeneratedTriangleException() {
    }

    public DegeneratedTriangleException(String message) {
        super(message);
    }

    public DegeneratedTriangleException(String message, Throwable cause) {
        super(message, cause);
    }

    public DegeneratedTriangleException(Throwable cause) {
        super(cause);
    }
}
