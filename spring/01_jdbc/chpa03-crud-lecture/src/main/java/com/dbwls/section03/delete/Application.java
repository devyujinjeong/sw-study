package com.dbwls.section03.delete;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("삭제할 메뉴 코드 입력 : ");
        int menuCode = sc.nextInt();

        MenuService menuService = new MenuService();
        menuService.removeMenu(menuCode);
    }
}
