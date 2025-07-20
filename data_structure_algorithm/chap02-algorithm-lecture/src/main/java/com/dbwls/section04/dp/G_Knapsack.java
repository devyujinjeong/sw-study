package com.dbwls.section04.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.StringTokenizer;

/* 0-1 Knapsack (분할 불가능 배낭 문제)
 * 동적 프로그래밍(DP)로 풀며, dp 배열에 누적 연산(최대 가치 갱신)을 통해 해를 구한다.
 * Greedy는 최적해를 보장하지 못한다.
 *
 * Fractional Knapsack (분할 가능 배낭 문제)
 * Greedy로 최적해 보장하므로 우선순위 큐(또는 정렬)로 value가 큰 순서대로 물건을 넣되,
 * 남은 용량만큼 쪼개서 넣는다.
 * */
public class G_Knapsack {
    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 물건의 개수
        int k = Integer.parseInt(st.nextToken());   // 가방 무게

        int[][] dp = new int[n+1][k+1]; // 최적의 가치값


        return 0;
    }

}