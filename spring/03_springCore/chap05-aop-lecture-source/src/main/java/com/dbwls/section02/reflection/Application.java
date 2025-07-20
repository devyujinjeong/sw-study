package com.dbwls.section02.reflection;

import org.springframework.context.ApplicationContext;

import java.lang.reflect.*;

public class Application {
    public static void main(String[] args) {
        // Class라는 메타정보(클래스의 이름, 생성자 정보, 필드 정보, 메소드 정보)를 가지고 있음.
        // 밑에는 이에 접근하는 방법들이 나옴
        Class class1 = Account.class;
        System.out.println("class1 : " + class1);

        Class class2 = new Account().getClass();
        System.out.println("class2 : " + class2);

        try {
            Class class3 = Class.forName("com.dbwls.section02.reflection.Account");
            System.out.println("class3 : " + class3);

            double[] arr = {0.1, 0.2};
            System.out.println(arr);
            Class class4 = Class.forName("[D");
            Class class5 = double[].class;
            System.out.println("class4 : " + class4);
            System.out.println("class5 : " + class5);

            // 원시 자료형은 Class 정보가 존재하지 않는다.
            double d = 1.0;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        /* 클래스의 메타 정보를 이용해 여러 가지 정보를 반환 받는 메소드를 제공한다.
        * 상속 된 부모 클래스 반환 */
        Class superclass = class1.getSuperclass();
        System.out.println("superclass : " + superclass);

        /* 필드 반환 */
        Field[] fields = class1.getDeclaredFields();
        for(Field field : fields){
            // 접근 제어자가, 타입, 이름
            System.out.println("modifier : " + Modifier.toString(field.getModifiers()));
            System.out.println("type : " + field.getType() );
            System.out.println("name : " + field.getName() );
        }

        /* 생성자 반환 */
        Constructor[] constructors = class1.getConstructors();
        for(Constructor constructor : constructors){
            System.out.println("name : " + constructor.getName());
            Class[] params = constructor.getParameterTypes();
            for(Class param : params){
                System.out.println("paramType : " + param.getTypeName());
            }
        }

        /* 특정 생성자를 활용해서 객체를 생성하기 */
        try {
            Account acc = (Account) constructors[0].newInstance(
                    "20", "110-234-567890", "1234", 1000
            );

            System.out.println(acc.getBalance());

            /* 메소드 반환 */
            Method[] methods = class1.getMethods();
            Method getBalanceMethod = null;
            for(Method method : methods){
                System.out.println(Modifier.toString(method.getModifiers()) + " ");
                System.out.println(method.getReturnType().getSimpleName() + " ");
                System.out.println(method.getName());

                if("getBalance".equals(method.getName())){
                    getBalanceMethod = method;
                }
            }

            System.out.println(getBalanceMethod.invoke(constructors[2].newInstance()));
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
