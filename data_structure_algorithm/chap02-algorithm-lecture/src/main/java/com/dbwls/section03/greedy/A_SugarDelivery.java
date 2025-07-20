package com.dbwls.section03.greedy;

public class A_SugarDelivery {
    public static int solution(int n) {
        int answer = 0;

        // 그리디 알고리즘인 이유
        // : 설탕을 최대한 5키로 포대에 많이 담아야 최선의 선택을 할 수 있다.
        // 즉, 5키로에 최대한 많이 담는다는 최선의 선택을 계속해서 하는 것이다.
        while(n%5>0){
            n-=3;
            answer++;
        }

        if(n<0) return -1;
        else {
            answer+=n/5;
            return answer;
        }
    }
}
