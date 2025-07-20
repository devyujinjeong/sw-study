package com.dbwls.section03.sync;

public class Application {
    public static void main(String[] args) {
        /* 여러 개의 스레드가 하나의 공유 자원을 사용할 때 동기화 처리를 할 수 있다. */

        /* 공유 자원 인스턴스 */
        Buffer buffer = new Buffer();

        /* 동일한 버퍼 인스턴스를 공유하는 생산자와 소비자 스레드 생성 */
        Thread t1 = new Producer(buffer);
        Thread t2 = new Consumer(buffer);

        t1.start();
        t2.start();
    }
}