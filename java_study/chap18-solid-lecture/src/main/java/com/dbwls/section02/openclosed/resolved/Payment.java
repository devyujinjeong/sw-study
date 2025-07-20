package com.dbwls.section02.openclosed.resolved;

/* 모든 결제 상황에 사용할 수 있는 상위 타입 인터페이스 선언 */
// 결제라는 가장 상위의 인터페이스 이기 때문에,
// 새로운 결제 수단이 추가 됐을 때, 이 인터페이스를 구현하는 새로운 클래스를 생성하기만 하면 된다.
public interface Payment {
    /* 결제 과정을 진행하는 추상 메소드 : public abstract가 생략됨 */
    void process();
}
