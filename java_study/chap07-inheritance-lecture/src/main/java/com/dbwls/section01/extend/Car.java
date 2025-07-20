package com.dbwls.section01.extend;

// 부모 클래스
public class Car {
    // 필드
    private boolean runningStatus;

    // 생성자
    public Car() {
        // 컴파일러가 자동으로 생성해주는 구문이다.
        // 여기에서는 Object() 클래스의 생성자를 가리킨다.
        super();
        System.out.println("Car 클래스 기본 생성자 호출");
    }

    // 메소드
    public void run() {
        runningStatus = true;
        System.out.println("자동차가 달립니다.");
    }

    // 메소드
    public void stop() {
        runningStatus = false;
        System.out.println("자동차가 멈춥니다.");
    }

    // 접근 제어자 : public > protected > default > private
    protected boolean isRunning() {
        return runningStatus;
    }

    // 메소드
    public void soundHorn() {
        if(isRunning()) {
            System.out.println("빵!빵!");
        } else {
            System.out.println("주행 중이 아닌 상태에서는 경적을 울릴 수 없습니다.");
        }
    }
}