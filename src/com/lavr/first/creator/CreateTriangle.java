package com.lavr.first.creator;

import com.lavr.first.entity.DegeneratedTriangleException;
import com.lavr.first.entity.NoTriangleException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.lavr.first.entity.Point;
import com.lavr.first.action.PointAction;
import com.lavr.first.entity.Triangle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



/**
 * Created by 123 on 27.09.2016.
 */
public class CreateTriangle {
    static final Logger LOG = LogManager.getLogger();
    static final String FILE_NAME = "files\\Coordinates.txt";
    static final String DELIMITER = "\\s+|,\\s*";


    List<Triangle> listOfTriangles=new ArrayList();

    public List<Triangle> createListOfTriangles() {
        try {
            Stream<String> lines = Files.lines(Paths.get(FILE_NAME));
            List<String> list ;
            list = lines.collect(Collectors.toList());
            for (String string : list) {
                String point[] = string.split(DELIMITER);
                Point a = new Point(Integer.valueOf(point[0]), Integer.valueOf(point[1]));
                Point b = new Point(Integer.valueOf(point[2]), Integer.valueOf(point[3]));
                Point c = new Point(Integer.valueOf(point[4]), Integer.valueOf(point[5]));
                try {
                    PointAction.checkExistence(a, b, c);
                    Triangle triangle = new Triangle(a, b, c);
                    listOfTriangles.add(triangle);
                } catch (NoTriangleException e) {
                    LOG.error(e.getMessage());
                } catch (DegeneratedTriangleException e) {
                    LOG.error(e.getMessage());
                }
            }
        } catch (IOException e) {
            LOG.error("Wrong file. Can't take coordinates.");
        }
        return listOfTriangles;
    }
}

