package test.com.lavr.first.action;

import com.lavr.first.action.PointAction;
import com.lavr.first.action.TriangleAction;
import com.lavr.first.entity.DegeneratedTriangleException;
import com.lavr.first.entity.NoTriangleException;
import com.lavr.first.entity.Point;
import com.lavr.first.entity.Triangle;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import org.junit.runners.Parameterized.Parameters;

/**
 * Created by 123 on 21.09.2016.
 */
@RunWith(Parameterized.class)
public class TriangleActionTest {
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    private boolean expected;

    public TriangleActionTest(Point firstPoint, Point secondPoint, Point thirdPoint, boolean expected) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
        this.expected=expected;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> pointsValues() {
        return Arrays.asList(new Object[][] {
              {new Point(2,1),new Point(1,2),new Point(3,2),true },
              {new Point(0,0),new Point(0,3),new Point(3,0),true },
              {new Point(1,1),new Point(1,4),new Point(-3,1),true},
              {new Point(1,2),new Point(4,6),new Point(5,2),false},

        });
    }

    @Test
    public void checkRightTriangleTest(){
        boolean actual;
        actual=TriangleAction.checkRightTriangle(new Triangle(this.firstPoint,this.secondPoint,this.thirdPoint));
        Assert.assertEquals(this.expected,actual);
    }
}
