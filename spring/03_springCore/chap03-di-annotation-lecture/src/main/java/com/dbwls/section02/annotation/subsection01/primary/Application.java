package com.dbwls.section02.annotation.subsection01.primary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext("com.dbwls.section02");

        // 포켓몬 구현 클래스가 여러 개라 무엇을 가져올지 모른다.
        // 이 때, @Primary이 붙어있는 구현 클래스를 가져온다.
        PokemonService pokemonService = applicationContext.getBean(
                "pokemonServicePrimary", PokemonService.class
        );
        pokemonService.pokemonAttack();


    }
}