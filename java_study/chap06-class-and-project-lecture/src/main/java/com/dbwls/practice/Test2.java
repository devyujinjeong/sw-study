package com.dbwls.practice;

public class Test2 {
    public static void main(String[] args) {
        Product[] products = new Product[3];

        products[0] = new Product("블라우스", 15000);
        products[1] = new Product("맨투맨", 10000);
        products[2] = new Product("후드티", 20000);

        for(Product top: products){
            System.out.println(top.getName() + " : " + top.getPrice());
        }




    }
}
