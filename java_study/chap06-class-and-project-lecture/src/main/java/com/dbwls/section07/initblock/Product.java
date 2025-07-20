package com.dbwls.section07.initblock;

// 지금 brand가 static 변수(클래스 변수)로 선언되어 있음
// 이게 처음에 명시적 초기화로 "삼송"이 됐다가 초기화 블록을 통해 "헬지"로 초기화가 됐음
// 그럼 이제 brand는 초기화를 더이상 못하는거 아닌가? 근데 왜 지금 인스턴ㅅ 초기화 블록에서 저러고 있ㅇㅁ?
public class Product {
    /* 1. JVM 기본 값 : 아무것도 처리하지 않았을 경우 기본 값으로 나옴
     * 2. 명시적 초기화 : 변수 선언과 동시에 값을 넣어주는 것 */
    private String name = "갤럭시";
    private int price = 1000000;
    // 상품들이 모두 공유한다고 생각하고 static으로 선언
    private static String brand = "삼송";

    /* 3. 초기화 블록 */
    /* 인스턴스 초기화 블록 */
    {
        name = "사이언";
        price = 800000;
        brand = "사과";
        System.out.println("인스턴스 초기화 블럭 동작함");
    }
    /* static 초기화 블록 */
    static {
        brand = "헬지";

//        name = "아이뽕";
//        price = 1500000;
        System.out.println("static 초기화 블럭 동작함");
    }

    /* 4. 생성자 초기화 */
    public Product() {
        System.out.println("기본 생성자 동작함");
    }

    public Product(String name, int price, String brand) {
        this.name = name;
        this.price = price;
        Product.brand = brand;
        System.out.println("매개변수 생성자 동작함");
    }

    public String getInformation () {
        return this.name + " " + this.price + " " + Product.brand;
    }
}