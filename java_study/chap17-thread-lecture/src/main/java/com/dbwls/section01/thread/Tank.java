package com.dbwls.section01.thread;

public class Tank extends Thread {
    @Override
    public void run() {
        /* Tank 스레드로 수행할 작업 내용을 작성하는 메소드 */
        for(int i = 0; i < 1000; i++) {
            System.out.println("Tank Shooting...");

            /* 현재 스레드를 지연 시키는 메소드로 전달 인자로 밀리세컨초를 전달한다. */
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}