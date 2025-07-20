package com.dbwls.section04.dp;

public class D_Padovan {

    static Integer[] dp = new Integer[101];
    public static int solution(int n){
        // 초기값 설정
        dp[1] = dp[2] = dp[3] = 1;

        /* 1. 탑다운 방식 (재귀 호출) */

        return padovan(n);

        /* 2. 바텀업 방식*/
//        for(int i=4; i<n+1; i++){
//            dp[i] = dp[i-2] + dp[i-3];
//        }
//
//        return dp[n];
    }

    private static int padovan(int n){
        if(n == 1 || n == 2 || n == 3) return 1;

        if(dp[n] == null){
            dp[n] = padovan(n-2) + padovan(n-3);
        }

        return dp[n];
    }

}
