package com.dbwls.section03.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C_MeetingRoomScheduler {
    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));

        // 회의의 개수와 시간 입력하기
        int n = Integer.parseInt(br.readLine());
        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            meetings[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }

        int count = 0;
        int endTime = 0;
        // 종료 시간을 기준으로 회의실 정렬하기
        // 종료시간 시간 기준으로 정렬한 다음에, 시작 시간 기준으로 정렬하기
        Arrays.sort(meetings, (o1,o2) ->  (o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]));

        for(int i=0; i<n; i++){
            if(meetings[i][0] >= endTime){
                endTime = meetings[i][1];
                count++;
            }                        
        }

        return count;
    }
}