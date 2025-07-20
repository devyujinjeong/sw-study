package com.dbwls.section02.variable;

public class Application1 {
    public static void main(String[] args) {
        /*변술들 선언하고 값을 대입하여 사용할 수 있다.*/

        /*변수 선언*/
        /*선언 방법 : 자료형 변수명;*/

        /*정수형*/
        byte bnum;
        short snum;
        int inum;
        long lnum;

        /*실수형*/
        float fnum;
        double dnum;

        /*문자형*/
        char ch;

        /*논리형*/
        boolean isTrue;

        /*문자열은 기본 자료형이 아닌 참조 자료형임을 기억한다.*/
        String str;

        /*변수에 값 대임 (처음 대입하는 것을 초기화 한다고 한다.*/
        bnum = 1;
        snum = 2;
        inum = 4;
        lnum = 8L;
        fnum = (float)4.0;
        dnum = 8.0;

        /*선언과 동시에 초기화*/
        int point = 100;
        int bonus = 10;


        System.out.println("point = " + point);

        /* 대입연산자 왼족은 변수 공간, 대입연산자 오른쪽은 변수가 가진 값으로 해석*/
        point = point+100;

        System.out.println("point = " + point);


    /*메소드 내부에 작성한 변수는 지역변수 (local variable)
    지역변수는 초기화 되지 않으면 사용할 수 없다.*/
        System.out.println(bnum);
    }

    public static class Application2 {
        public static void main(String[] args) {
            /* 1-1. 동일한 범위 내에서 동일한 변수명을 가질 수 없다. */
            int age = 20;
            //int age = 20; 		   //동일한 변수명을 가지므로 에러 발생함

            /* 1-2. 예약어는 사용이 불가능하다. */
            //int true = 1;			//예약어 사용 불가
            //int for = 20;			//예약어 사용 불가

            /* 1-3. 변수명은 대소문자를 구분한다. */
            int Age = 20;			//위에서 만든 age와 다른 것으로 취급한다.
            int True = 10;     //예약어 True와 다른 것으로 취급한다.

            /* 1-4. 변수명은 숫자로 시작할 수 없다. */
            //int 1age = 20;		//숫자로 시작해서 에러 발생
            int age1 = 20;			//숫자가 처음에 시작하지 않으면 섞어서 사용도 가능함

            /* 1-5. 특수기호는 '_'와 '$'만 사용 가능하다. */
            //int sh@rp = 20;		//사용 가능한 특수문자 외에는 사용 불가능
            int _age = 20;				//언더스코어는 사용 가능함. 처음도 가능하고 중간이나 끝에도 가능함
            int $harp = 20;			//$도 사용 가능함. 처음도 가능하고 중간이나 끝에도 가능함

            /* 2-1. 변수명의 길이 제한은 없다. */
            int sadjfsadkjhfkjsadhfkjhsafkjhsdfjkhsafkjhsdjkfhsdajkfhdsakjfhsdakjfhasdjkfhsdafkjhfsdakj;

            /* 2-2. 변수명이 합성어로 이루어진 경우 첫 단어는 소문자, 두 번째 시작 단어는 대문자로 시작한다. */
            /* 자바에서는 클래스명만 유일하게 대문자로 시작한다. */
            int maxAge = 20;
            int minAge = 10;

            /* 2-3. 단어와 단어 사이의 연결을 언더스코어(_)로 하지 않는다. */
            String user_name;			//에러가 발생하지 않지만 이렇게 하면 안된다.
            String userName;			  //이게 올바른 표현이다.

            /* 2-4. 한글로 변수명을 짓는 것이 가능하지만, 권장하지 않는다. */
            int 나이;						  //가능하지만 권장하지 않음

            /* 2-5. 변수 안에 저장된 값이 어떤 의미를 가지는지 명확하게 표현하도록 한다. */
            String s;					    //변수가 어떤 의미인지 파악하기 힘들다.
            String name;				    //문자열 형태의 이름이 저장되겠구나 하는 의도가 파악이 된다.

            /* 2-6. 전형적인 변수 이름이 있다면 가급적 사용하도록 한다. */
            int sum = 0;
            int max = 10;
            int min = 0;
            int count = 1;

            /* 2-7. 명사형으로 작성할 수 있도록 한다. */
            String goHome;				    //가능하긴 하지만 가급적 명사형으로 짓는다.
            String home;

            /* 2-8. boolean 형은 의문문으로 가급적 긍정형태로 네이밍한다. */
            boolean isAlive = true;
            boolean isDead = false;	//부정형보다는 긍정형이 더 나은 방식이다.
        }
    }
}
