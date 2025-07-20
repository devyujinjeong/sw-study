package com.dbwls.practice;

public class Clothes {
    private String name;
    private int price;
    private String brand;

    public Clothes(String a, int price, String brand) {
        this.name = a;
        price = price;
        this.brand = brand;
    }

    public String getInformation(){
        return this.name + "," + this.price + "," + this.brand;
    }
}
