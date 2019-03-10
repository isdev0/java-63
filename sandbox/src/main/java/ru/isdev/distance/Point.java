package ru.isdev.distance;

public class Point {

    public int x;
    public int y;

    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }

    public double distance(Point distancePoint){
        return Math.sqrt( Math.pow(distancePoint.x - this.x,2) + Math.pow(distancePoint.y - this.y,2) );
    }

}
