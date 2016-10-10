package com.lavr.first.action;

import com.lavr.first.entity.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


/**
 * Created by 123 on 21.09.2016.
 */
public class TriangleAction {
    static final Logger LOG = LogManager.getLogger();

    public double countPerimeter(Triangle triangle){
        PointAction act=new PointAction();
        double firstSide=act.countSide(triangle.getFirst(),triangle.getSecond());
        double secondSide=act.countSide(triangle.getSecond(),triangle.getThird());
        double thirdSide=act.countSide(triangle.getThird(),triangle.getFirst());

        return firstSide+secondSide+thirdSide;
    }

    public double countSquare(Triangle triangle){
        double halfPerimeter=countPerimeter(triangle)/2.0;
        PointAction act=new PointAction();
        double firstSide=act.countSide(triangle.getFirst(),triangle.getSecond());
        double secondSide=act.countSide(triangle.getSecond(),triangle.getThird());
        double thirdSide=act.countSide(triangle.getFirst(),triangle.getThird());

        return Math.sqrt((halfPerimeter-firstSide)*(halfPerimeter-secondSide)*(halfPerimeter-thirdSide)*halfPerimeter);
    }

    static public boolean checkRightTriangle(Triangle triangle){
        PointAction act=new PointAction();
        double firstVectorX=act.countVectCoordX(triangle.getFirst(),triangle.getSecond());
        double firstVectorY=act.countVectCoordY(triangle.getFirst(),triangle.getSecond());
        double secondVectorX=act.countVectCoordX(triangle.getSecond(),triangle.getThird());
        double secondVectorY=act.countVectCoordY(triangle.getSecond(),triangle.getThird());
        double thirdVectorX=act.countVectCoordX(triangle.getFirst(),triangle.getThird());
        double thirdVectorY=act.countVectCoordY(triangle.getFirst(),triangle.getThird());

        if(act.scalarMult(firstVectorX,firstVectorY,secondVectorX,secondVectorY)==0 ||
                act.scalarMult(firstVectorX,firstVectorY,thirdVectorX,thirdVectorY)==0 ||
                act.scalarMult(secondVectorX,secondVectorY,thirdVectorX,thirdVectorY)==0 ){
            return true;
        }
            else return false;
    }

    public void showResult(List<Triangle> triangleList){
        for (Triangle triangle:triangleList) {
             LOG.info("Perimeter of triangle "+triangle+countPerimeter(triangle));
             LOG.info("Square of triangle "+triangle+countSquare(triangle));
        }
    }
}

