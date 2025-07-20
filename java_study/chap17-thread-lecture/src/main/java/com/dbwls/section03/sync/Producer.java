package com.dbwls.section03.sync;

/* 공유 데이터에 값을 생산하는 역할 */
public class Producer extends Thread {

    private final Buffer criticalData;

    public Producer(Buffer criticalData) {
        this.criticalData = criticalData;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 10; i++) {
            criticalData.setData(i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}