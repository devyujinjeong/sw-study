package com.dbwls.section03.sync;

public class Buffer {

    private int data;
    private boolean empty = false;

    public synchronized void getData(){

        if(empty){
            System.out.println("getData wait");
            try {
                /* 실행 중인 스레드를 일시 정지 시킨다. 다른 스레드에서 notify()가 호출 되면 깨어나게 된다. */
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("소비자 : " + data + " 번 상품을 소비하였습니다.");
        empty = true;

        /* 대기 중인 스레드를 하나 깨워서 다시 실행 대기 상태로 전환 시킨다. */
        notify();
    }

    public synchronized void setData(int data){

        if(!empty) {
            System.out.println("setData wait");
            try {
                /* 실행 중인 스레드를 일시 정지 시킨다. 다른 스레드에서 notify()가 호출 되면 깨어나게 된다. */
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        this.data = data;
        System.out.println("생산자 : " + data + " 번 상품을 생산하였습니다.");
        empty = false;

        /* 대기 중인 스레드를 하나 깨워서 다시 실행 대기 상태로 전환 시킨다. */
        notify();
    }
}