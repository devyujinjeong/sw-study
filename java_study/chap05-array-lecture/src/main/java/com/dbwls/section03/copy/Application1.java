package com.dbwls.section03.copy;

import java.util.Arrays;

public class Application1 {
    public static void main(String[] args) {
        /* 얕은 복사에 대해 이해할 수 있다. */

        /* 원본 배열 */
        int[] origin = {1, 2, 3, 4, 5};

        /* 얕은 복사 */
        int[] copy = origin;

        /* hashCode 확인 */
        System.out.println(origin.hashCode()); // 918221580
        System.out.println(copy.hashCode()); // 918221580

        System.out.println(Arrays.toString(origin));
        System.out.println(Arrays.toString(copy));

        origin[2] = 100;

        // origin의 값이 변경되면, copy의 값도 변경되어서 출력된다.
        System.out.println(Arrays.toString(origin));
        System.out.println(Arrays.toString(copy));

    }
}