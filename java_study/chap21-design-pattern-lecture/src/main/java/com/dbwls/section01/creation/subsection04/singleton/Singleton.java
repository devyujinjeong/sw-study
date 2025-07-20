package com.dbwls.section01.creation.subsection04.singleton;

public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("싱글톤 객체입니다.");
    }

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        singleton1.showMessage();
        System.out.println(singleton1 == singleton2); // true

        /* Java API 예시 */
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.freeMemory());
    }
}
