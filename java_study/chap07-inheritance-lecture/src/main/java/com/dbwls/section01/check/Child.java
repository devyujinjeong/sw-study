package com.dbwls.section01.check;

public class Child extends Parent {
    String name = "이순신";

    public void getName(){
        System.out.println(this.name); // 자식 클래스가 가지고 있는 이름
        System.out.println(super.name); // 부모 클래스가 가지고 있는 이름
    }
}
