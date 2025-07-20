package com.dbwls.section02.extend.run;

import com.dbwls.section02.extend.*;

public class Application3 {
    public static void main(String[] args) {
        WildCardFarms wcf = new WildCardFarms();

        /* 매개변수 타입 제한이 없는 경우
        * : 어떤 타입의 토끼를 보융한 토끼 농장이든 인자로 전달 가능*/
        wcf.anyType(new RabbitFarm<>(new Rabbit()));
        wcf.anyType(new RabbitFarm<>(new Bunny()));
        wcf.anyType(new RabbitFarm<>(new DrunkenBunny()));

        /* 매개변수 타입이 바니이거나 바니 후손 토끼를 가진 토끼농장만 자로 전달 가능 */
        // wcf.extendsType(new RabbitFarm<>(new Rabbit()));
        wcf.extendsType(new RabbitFarm<>(new Bunny()));
        wcf.extendsType(new RabbitFarm<>(new DrunkenBunny()));

        /* 매개변수 타입이 바니이거나 바니 조상 토끼를 가진 토끼농장만 인자로 전달 가능 */
        wcf.superType(new RabbitFarm<>(new Rabbit()));
        wcf.superType(new RabbitFarm<>(new Bunny()));
        // 왜 오류가 나지 않을까?!
        wcf.superType(new RabbitFarm<>(new DrunkenBunny()));




    }
}
