package com.dbwls.practice;

public class Test1 {
    public static void main(String[] args) {
        Product product = new Product();

        // 객체의 필드와 메소드는 heap영역에 저장되고,
        // 기본값으로 초기화 된다.
        System.out.println(product.getName()); // null 값 출력
        System.out.println(product.getPrice()); // 0 값 출력

        product.setName("블라우스");
        product.setPrice(-15000);

        System.out.println(product.getName());
        System.out.println(product.getPrice());

    }
}
