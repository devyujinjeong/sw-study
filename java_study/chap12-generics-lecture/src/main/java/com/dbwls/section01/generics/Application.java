package com.dbwls.section01.generics;

public class Application {
    public static void main(String[] args) {
        /* 제네릭 프로그래밍
        * 데이터 형식에 의존 없이 여러 다른 데이터 타입을 가질 수 있는 기술 => 재사용성
        * 1. 컴파일 시 타입 검사를 통한 타입 안정성 확보
        * 2. 반환 값 타입 변환 코드 생략
        * */

        /* 타입을 integer로 생성 */
        GenericTest<Integer> gt1 = new GenericTest<>();
        gt1.setValue(10);
//        gt1.setValue("정유진");
        Integer num = gt1.getValue();

        /* 타입을 String으로 생성 */
        GenericTest<String> gt2 = new GenericTest<>();
        gt2.setValue("정유진");
        String name = gt2.getValue();

        /* 제네릭 없이 생성 */
        GenericTest gt3 = new GenericTest();
        gt3.setValue(10);
        gt3.setValue("정유진");
        String str2 = (String)gt3.getValue();

        /* 근데 T가 아니라 Object 타입으로 선언해서 사용해도 되는거 아닌가?!
        * 내 의도와 다르게 다른 자료형이 들어와도 제한해주지 않는다.
        * 또한 내가 쓰고 싶은 타입을 사용할 때는 반드시 다운 캐스팅을 사용해야 사용할 수 있다. */
    }
}
