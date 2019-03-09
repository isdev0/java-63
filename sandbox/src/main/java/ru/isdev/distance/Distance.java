package ru.isdev.distance;

public class Distance {

    public static void main(String arg[]){

        Point p1 = new Point(1,1);
        Point p2 = new Point(15,5);

        System.out.println("Distance between points p1(" + p1.x + "," + p1.y + ") and p2(" + p2.x + "," + p2.y + ") = " + distance(p1,p2) );

    }

    public static double distance(Point p1, Point p2){
        return Math.sqrt( Math.pow(p2.x - p1.x,2) + Math.pow(p2.y - p1.y,2) );
    }

}
