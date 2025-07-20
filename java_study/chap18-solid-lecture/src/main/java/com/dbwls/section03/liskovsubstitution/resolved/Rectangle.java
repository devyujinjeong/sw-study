package com.dbwls.section03.liskovsubstitution.resolved;

public class Rectangle implements Shape{
    // 값을 더 이상 변경하고 싶지 않음 -> final 붙이기
    // 생성자 쪽에서 반드시 초기화 할 수 있게 작성하기
    private final int width;
    private final int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getArea() {
        return width * height;
    }
}
