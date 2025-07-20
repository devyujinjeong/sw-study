package com.dbwls.section03.sync;

/* 공유 데이터에 값을 소비하는 역할 */
public class Consumer extends Thread {

    private final Buffer criticalData;

    public Consumer(Buffer criticalData) {
        this.criticalData = criticalData;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 10; i++) {
            criticalData.getData();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}