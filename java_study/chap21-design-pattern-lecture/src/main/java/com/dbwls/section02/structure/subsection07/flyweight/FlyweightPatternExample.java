package com.dbwls.section02.structure.subsection07.flyweight;

import java.util.HashMap;
import java.util.Map;

// 플라이웨이트 객체 (공유되는 객체)
class Character {
    private final char symbol; // 변경되지 않는 내부 상태 (Intrinsic State)

    public Character(char symbol) {
        this.symbol = symbol;
    }

    public void display(String font) { // 외부 상태 (Extrinsic State)
        System.out.println("Character: " + symbol + ", Font: " + font);
    }
}

// 플라이웨이트 팩토리 (객체를 캐싱하여 재사용)
class CharacterFactory {
    private static final Map<java.lang.Character, Character> characters = new HashMap<>();

    public static Character getCharacter(char symbol) {
        characters.putIfAbsent(symbol, new Character(symbol)); // 이미 존재하는 경우 기존 객체 반환
        return characters.get(symbol);
    }
}

// 클라이언트 코드
public class FlyweightPatternExample {
    public static void main(String[] args) {
        Character a1 = CharacterFactory.getCharacter('A');
        Character a2 = CharacterFactory.getCharacter('A');
        Character b = CharacterFactory.getCharacter('B');

        // 동일한 객체를 공유하므로 a1과 a2는 같은 객체
        a1.display("Arial");
        a2.display("Times New Roman");
        b.display("Verdana");

        System.out.println("a1과 a2는 같은 객체인가? " + (a1 == a2)); // true (공유된 객체)
    }
}
