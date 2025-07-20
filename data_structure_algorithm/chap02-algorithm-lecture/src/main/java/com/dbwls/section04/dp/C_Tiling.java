package com.dbwls.section04.dp;

public class C_Tiling {
    public static int solution(int n){
        int[] dp = new int[n+1];

        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<n+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return 0;
    }
}
