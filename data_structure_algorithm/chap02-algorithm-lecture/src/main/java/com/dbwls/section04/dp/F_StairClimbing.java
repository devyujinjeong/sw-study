package com.dbwls.section04.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class F_StairClimbing {
    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));

        int n = Integer.parseInt(br.readLine());

        int[] stairs = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1; i<n+1; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];

        for(int i=3; i<n+1; i++){
            dp[i] = Math.max(dp[i-2], stairs[i-3]+stairs[i-1]) + stairs[i];
        }

        return dp[n];
    }
}
