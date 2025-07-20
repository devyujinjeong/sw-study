package com.dbwls.practice;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        try{
           int result = a/b;
            System.out.println(result);
        }catch(ArithmeticException e){
            System.out.println("0으로는 나눌 수 없습니다.");
            e.printStackTrace();
        }finally {
            System.out.println("입력한 숫자 : " + a + " , " + b);
        }
    }
}
