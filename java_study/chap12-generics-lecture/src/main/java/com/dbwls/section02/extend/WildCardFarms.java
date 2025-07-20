package com.dbwls.section02.extend;

public class WildCardFarms {
    /* 타입변수가 선언 된 RabbitFarm 객체를 생성할 때 보다 유연하게 wildCard를 활용해본다. */
    public void anyType(RabbitFarm<?> farm){
        farm.getRabbit().cry();
    }

    /* 토끼농장의 토끼는 Bunny이거나 그 후손 타입으로 만들어진 토끼농장만 매개변수로 사용 가능 */
    public void extendsType(RabbitFarm<? extends Bunny> farm) {
        farm.getRabbit().cry();
    }

    /* 토끼농장의 토끼는 Bunny이거나 그 부모 타입으로 만들어진 토끼농장만 매개변수로 사용 가능 */
    public void superType(RabbitFarm<? super Bunny> farm) {
        farm.getRabbit().cry();
    }
}
