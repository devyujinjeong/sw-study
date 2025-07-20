package com.dbwls.section02.enumtype;

public enum FoodsEnum {
    /* 내부적으로 작성 순서대로 0부터 값이 자동으로 부여된다. */
    MEAL_AN_BUTTER_KIMCHI_STEW(0),
    MEAL_MINT_SEAWEED_SOUP(1),
    MEAL_BUNGEOPPANG_SUSHI(2),
    DRINK_RADISH_KIMCHI_LATTE(3),
    DRINK_WOOLUCK_SMOOTHIE(4),
    DRINK_RAW_CUTTLEFISH_SHAKE(5);

    private final int value;
    private final int var = 10;
    FoodsEnum(int value) {
        this.value = value;
    }

    public void printVar() {
        System.out.println("var : " + var);
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}