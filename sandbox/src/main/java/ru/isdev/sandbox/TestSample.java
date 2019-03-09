package ru.isdev.sandbox;

public class TestSample {

    public static void main(String[] args) {

        hello("woolf");

        Square square = new Square(15);
        System.out.println("The area of square with a side " + square.l + " = " + square.area() );

        Rectangle rectangle = new Rectangle(123,131);
        System.out.println("The area of rectangle with a side " + rectangle.a + " and " + rectangle.b + " = " + rectangle.area() );

    }

    public static void hello(String userName){
        System.out.println("Hello, " + userName + "!");
    }

}
