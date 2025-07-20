package com.dbwls.section08.objectarray;

public class Car {
    private String modelName;
    private int maxSpeed;

    // 생성자
    public Car(String modelName, int maxSpeed) {
        this.modelName = modelName;
        this.maxSpeed = maxSpeed;
    }

    // 메소드
    public void driveMaxSpeed() {
        System.out.println(modelName + "이(가) 최고 시속 "
                + maxSpeed + "km/h로 달려갑니다.");
    }
}