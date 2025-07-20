package com.dbwls.section01.creation.subsection02.staticfactorymethod;

public class Car {
    private String model;

    // 생성자를 외부에서 호출하지 못하게 만들었음
    private Car(String model) {
        this.model = model;
    }

    public static Car createCar(String model) {
        return new Car(model);
    }

    public void showModel() {
        System.out.println("model: " + model);
    }

    // createCar를 호출해서 생성자로 객체를 생성할 수 있음
    public static void main(String[] args) {
        Car car = Car.createCar("Tesla");
        car.showModel();

        /* Java API 예제*/
        Integer.valueOf(10);
    }
}
