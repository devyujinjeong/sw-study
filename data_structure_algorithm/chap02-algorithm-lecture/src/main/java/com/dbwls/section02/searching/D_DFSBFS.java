package com.dbwls.section02.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D_DFSBFS {
    static int N, M, V;
    static int[][] array;
    static boolean[] visited;

    public static String solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // array와 visited 초기화하기
        array = new int[N+1][N+1];
        visited = new boolean[N + 1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            array[a][b] = array[b][a] = 1;
        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        DFS(V, sb1);
        sb1.append("\n");

        // BFS를 위해 visited 배열 초기화
        visited = new boolean[N + 1];
        BFS(V, sb2);

        return sb1.toString() + sb2.toString();
    }

    private static void DFS(int start, StringBuilder sb){
        visited[start] = true;
        sb.append(start).append(" ");
        for(int i=1; i< N+1; i++){
            // 연결 되어 있고, 아직 방문하지 않은 노드라면
            if(array[start][i]==1 && !visited[i]){
                DFS(i, sb);
            }
        }
    }

    private static void BFS(int start, StringBuilder sb){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        sb.append(start).append(" ");
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i=1; i<N+1; i++){
                if(array[cur][i] == 1 && !visited[i]){
                    visited[i] = true;
                    sb.append(i).append(" ");
                    q.offer(i);
                }
            }
        }
    }
}
