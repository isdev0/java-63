package ru.isdev.distance;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void testDistance(){

        Point point1 = new Point(1,1);
        Point point2 = new Point(5,1);

        Assert.assertEquals(point1.distance(point2),4.0);
    }

}
