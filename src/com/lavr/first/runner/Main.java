package com.lavr.first.runner;

import com.lavr.first.action.TriangleAction;
import com.lavr.first.creator.CreateTriangle;
import com.lavr.first.entity.Triangle;

import java.util.List;

/**
 * Created by 123 on 27.09.2016.
 */
public class Main {

    public static void main(String[] args) {
        CreateTriangle ct=new CreateTriangle();
        List<Triangle> triangleList=ct.createListOfTriangles();
        TriangleAction action=new TriangleAction();
        action.showResult(triangleList);
    }
}
