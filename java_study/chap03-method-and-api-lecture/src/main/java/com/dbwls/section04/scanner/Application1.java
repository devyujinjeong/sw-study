package com.dbwls.section04.scanner;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        /* java.util.Scanner */
        /* 1. Scanner 객체 생성 */
        Scanner sc = new Scanner(System.in);

        /* 2. 자료형 별 값 입력 받기 */
        /* 2-1. 문자열 */
        System.out.print("이름 입력 : ");
        String name = sc.nextLine();
        System.out.println("name : " + name);

        /* 2-2. 정수 */
        System.out.print("나이 입력 : ");
        int age = sc.nextInt();
        System.out.println("age : " + age);
    }
}


