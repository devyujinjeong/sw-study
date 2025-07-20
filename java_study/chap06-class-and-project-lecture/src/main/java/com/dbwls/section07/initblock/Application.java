package com.dbwls.section07.initblock;

public class Application {
    public static void main(String[] args) {
        /* 초기화 블럭의 동작 순서를 이해하고 이를 활용하여 인스턴스를 생성할 수 있다. */
        /* static 초기화는 딱 한 번 출력됨 */
        // 삼송(명시적) -> 헬지(static 초기화 블록) -> 사과(인스턴스 초기화 블록)
        Product product = new Product();
        System.out.println(product.getInformation());

        // 삼송(명시적) -> 헬지(static 초기화 블록) -> 사과(인스턴스 초기화 블록) -> 샤우미(대륙폰)
        System.out.println("===============================");
        Product product2 = new Product("대륙폰", 500000, "샤우미");
        System.out.println(product2.getInformation());
    }
}
