package com.lavr.first.entity;

import com.lavr.first.action.PointAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by 123 on 21.09.2016.
 */
public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point one, Point two, Point three) {
        this.first = one;
        this.second = two;
        this.third = three;
    }

    public Point getFirst() {
        return first;
    }

    public void setFirst(Point first) {
        this.first = first;
    }

    public Point getSecond() {
        return second;
    }

    public void setSecond(Point second) {
        this.second = second;
    }

    public Point getThird() {
        return third;
    }

    public void setThird(Point third) {
        this.third = third;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}
