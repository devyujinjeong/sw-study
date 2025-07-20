package com.dbwls.section02.superkeyword;

import java.util.Date;

public class Product {
    // 팔드가 다 private으로 선언되어 있기 때문에,
    // 자식 클래스는 직접 접근하지 못한다. 
    private String code;
    private String brand;
    private String name;
    private int price;
    private Date manufacturingDate;

    // 생성자
    public Product() {
    }

    public Product(String code, String brand, String name, int price, Date manufacturingDate) {
        this.code = code;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.manufacturingDate = manufacturingDate;
    }

    // getter/setter 메소드
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(Date manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    // 정보를 가져오는 메솓,
    public String getInformation() {
        return code + " " + brand + " " + name + " " + price + " " + manufacturingDate;
    }
}