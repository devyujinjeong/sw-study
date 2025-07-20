package com.dbwls.section03.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example {
    // 부모 원소를 저장하는 배열
    static int[] parent;
    static StringBuilder sb = new StringBuilder();

    // 특정 노드의 부모 노드를 찾는 배열
    // 만약 parent[n] != n이라면 부모 노드가 있는 것이다.
    // 그런데 n이라는 것도 또 부모 노드가 있을 수 있으므로 다시 find()를 호출하는 것이다.
    static int find(int n){
        if(parent[n] != n){
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }

    // 두 개의 노드를 집합으로 묶어주기 (대표 원소 가져와서 묶어주기)
    // 앞의 원소를 대표 원소로 지정해서 묶어준다.
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    // 부모 노드가 같은지 확인하는 메소드
    static void checkSamePnode(int a, int b){
        if(find(a)==find(b)){
            sb.append("YES").append('\n');
        }else{
            sb.append("NO").append('\n');
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(c==0){
                union(a,b);
            }else{
                checkSamePnode(a,b);
            }
        }

        System.out.println(sb);
    }

}