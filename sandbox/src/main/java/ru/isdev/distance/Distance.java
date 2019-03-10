package ru.isdev.distance;

public class Distance {

    public static void main(String arg[]){

        Point p1 = new Point(1,1);
        Point p2 = new Point(12,5);

        System.out.println("Distance between points p1(" + p1.x + "," + p1.y + ") and p2(" + p2.x + "," + p2.y + ") = " + p1.distance(p2) );

    }

}
