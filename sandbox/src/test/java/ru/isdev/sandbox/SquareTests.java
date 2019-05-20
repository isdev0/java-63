package ru.isdev.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTests {

    @Test
    public void testArea(){
        Square square = new Square(7);
        Assert.assertEquals(square.area(),48.0);
    }
}
