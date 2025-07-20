package com.dbwls.section01.creation.subsection03.builder;

import java.util.stream.Stream;

public class Computer {
    private String CPU;
    private String RAM;
    private String storage;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
    }

    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    public void showSpecs() {
        System.out.println("CPU: " + CPU + ", RAM: " + RAM + ", storage: " + storage);
    }

    public static void main(String[] args) {
        // 만약 이 패턴을 모르고 생성자만 알고 있다면,
        // 우리는 모든 필드를 초기화 해주는 생성자1과
        // CPU와 RAM을 초기화 해주는 생성자2 2개를 다 만들어야 한다.
        Computer computer1 = new Computer.Builder()
                .setCPU("Intel i7")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .build();

        computer1.showSpecs();

        Computer computer2 = new Computer.Builder()
                .setCPU("Intel i7")
                .setRAM("16GB")
                .build();

        computer2.showSpecs();



        /* Java API */
        StringBuilder db = new StringBuilder("hello")
                .append("world")
                .append("!!");

        Stream<String> stream = Stream.<String>builder()
                .add("hello")
                .add("world")
                .build();
    }

}
