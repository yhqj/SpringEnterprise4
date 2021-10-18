package chapter4.reflect;

public class PrivateCar {
    private String color;

    protected void drive() {
        System.out.println("drive private car,the car color is" + color);
    }
}
