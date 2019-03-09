package ru.isdev.sandbox;

public class TestSample {

    public static void main(String[] args) {

        hello("woolf");

        double l = 12;
        System.out.println("The area od square with a side " + l + " = " + area(l) );

        double a = 123;
        double b = 321;
        System.out.println("The area of rectangle with a side " + a + " and " + b + " = " + area(a,b) );

    }

    public static void hello(String userName){
        System.out.println("Hello, " + userName + "!");
    }

    public static double area(double len){
        return len * len;
    }

    public static double area(double a, double b){
        return a * b;
    }

}
