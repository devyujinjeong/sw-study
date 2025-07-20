package com.dbwls.section02.extend;

import com.dbwls.section02.extend.Mammal;
import com.dbwls.section02.extend.Reptile;

public class MethodFarm {
    /* 메소드 매개변수로 전달 받는 타입 객체 */
    public <T> void animalType(T t1, T t2) {}
    public <T extends Mammal> void mammalType(T t) {}
    public <T extends Reptile> void reptileType(T t) {}
}