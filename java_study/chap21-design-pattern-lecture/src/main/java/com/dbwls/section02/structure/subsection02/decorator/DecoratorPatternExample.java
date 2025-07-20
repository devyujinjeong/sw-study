package com.dbwls.section02.structure.subsection02.decorator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// 기본 커피 인터페이스
interface Coffee {
    String getDescription();
    double cost();
}

// 가장 기본적인 커피 클래스
class SimpleCoffee implements Coffee {
    public String getDescription() {
        return "기본 커피";
    }

    public double cost() {
        return 2000.0;
    }
}

// 데코레이터 (추상 클래스)
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee; // 기존 커피 객체를 감싸는 역할

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDescription() {
        return coffee.getDescription();
    }

    public double cost() {
        return coffee.cost();
    }
}

// 우유 추가 데코레이터
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return super.getDescription() + ", 우유 추가";
    }

    public double cost() {
        return super.cost() + 500.0;
    }
}

// 설탕 추가 데코레이터
class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return super.getDescription() + ", 설탕 추가";
    }

    public double cost() {
        return super.cost() + 300.0;
    }
}

// 휘핑크림 추가 데코레이터
class WhipDecorator extends CoffeeDecorator {
    public WhipDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return super.getDescription() + ", 휘핑크림 추가";
    }

    public double cost() {
        return super.cost() + 700.0;
    }
}

// 클라이언트 코드
public class DecoratorPatternExample {
    public static void main(String[] args) throws IOException {
        // 기본 커피
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " 가격: " + coffee.cost() + "원");

        // 우유 추가
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " 가격: " + coffee.cost() + "원");

        // 설탕 추가
        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " 가격: " + coffee.cost() + "원");

        // 휘핑크림 추가
        coffee = new WhipDecorator(coffee);
        System.out.println(coffee.getDescription() + " 가격: " + coffee.cost() + "원");

        /* Java API 예제
        * BufferedReader : 데코레이터 역할을 하는 객체로 readLine 이라는 추가된 기능을 사용할 수 있다.
         */
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        br.readLine();
    }
}