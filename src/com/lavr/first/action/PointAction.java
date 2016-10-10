package com.lavr.first.action;

import com.lavr.first.entity.DegeneratedTriangleException;
import com.lavr.first.entity.Point;
import com.lavr.first.entity.NoTriangleException;

/**
 * Created by 123 on 21.09.2016.
 */
public class PointAction {

    public double countSide(Point p1,Point p2){
        return Math.hypot(p1.getX()-p2.getX(),p1.getY()-p2.getY());
    }
    public int countVectCoordX(Point p1,Point p2){
       return p2.getX()-p1.getX();
    }
    public int countVectCoordY(Point p1,Point p2){
        return p2.getY()-p1.getY();
    }
    public double scalarMult(double x1,double y1, double x2,double y2){
        return x1*x2+y1*y2;
    }

    public static boolean checkExistence(Point firstPoint,Point secondPoint,Point thirdPoint )throws NoTriangleException,DegeneratedTriangleException {  // returns true if points make triangle
        PointAction action=new PointAction();
        double firstSide=action.countSide(firstPoint,secondPoint);
        double secondSide=action.countSide(secondPoint,thirdPoint);
        double thirdSide=action.countSide(firstPoint,thirdPoint);

        if(action.checkDegeneracy(firstPoint, secondPoint, thirdPoint))
            throw new DegeneratedTriangleException("Such triangle would be degenerated :"+firstPoint+secondPoint+thirdPoint);

        if(firstSide+secondSide>thirdSide && secondSide+thirdSide>firstSide && firstSide+thirdSide>secondSide){
            return true;
        }else
            throw new NoTriangleException("These points can't make a triangle : "+firstPoint+secondPoint+thirdPoint);
    }

    public boolean checkDegeneracy(Point one,Point two, Point three){  //returns true if triangle is degenerated
        return one.equals(two)||one.equals(three)||two.equals(three);
    }
}