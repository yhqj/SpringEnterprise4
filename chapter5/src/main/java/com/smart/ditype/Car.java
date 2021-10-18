package com.smart.ditype;

public class Car {
    private int maxSpeed;
    private String brand;
    private double price;

    public Car(int maxSpeed, String brand, double price) {
        this.maxSpeed = maxSpeed;
        this.brand = brand;
        this.price = price;
    }

    public Car() {
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
