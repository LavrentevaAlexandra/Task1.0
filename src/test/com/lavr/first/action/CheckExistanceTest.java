package test.com.lavr.first.action;

import com.lavr.first.action.PointAction;
import com.lavr.first.entity.DegeneratedTriangleException;
import com.lavr.first.entity.NoTriangleException;
import com.lavr.first.entity.Point;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 123 on 25.09.2016.
 */
public class CheckExistanceTest {
    boolean actual;

    @Test(expected = NoTriangleException.class)
    public void checkExistenceDegeneratedTest() throws NoTriangleException, DegeneratedTriangleException {
        actual= PointAction.checkExistence(new Point(0,0),new Point(0,1),new Point(0,3));
        Assert.assertFalse(actual);
    }

    @Test(expected = DegeneratedTriangleException.class)
    public void checkNoExistenceTest() throws NoTriangleException, DegeneratedTriangleException {
        actual=PointAction.checkExistence(new Point(10,10),new Point(10,10),new Point(10,10));
        Assert.assertFalse(actual);
    }

    @Test
    public void checkExistenceTest() throws NoTriangleException, DegeneratedTriangleException {
        actual=PointAction.checkExistence(new Point(1,2),new Point(3,4),new Point(5,2));
        Assert.assertTrue(actual);
    }
}
