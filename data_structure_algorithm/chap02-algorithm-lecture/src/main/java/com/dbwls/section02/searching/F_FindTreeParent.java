package com.dbwls.section02.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class F_FindTreeParent {

    static int N;                       // 노드의 개수
    static List<Integer>[] list;        // 연결 노드 저장 배열 (희소 그래프이므로 리스트 사용)
    static int[] parent;                // 최종 결과 저장 배열
    static boolean[] visited;           // 방문 결과 저장 배열

    public static String solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];
        for(int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        /* N - 1 개 줄의 입력 처리 */
        StringTokenizer st;
        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        StringBuilder sb = new StringBuilder();

        /* DFS 결과 확인 */
        Arrays.fill(parent, 0);
        Arrays.fill(visited, false);
        bfs(1);
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append(" ");
        }

        return sb.toString();
    }

    private static void dfs(int parentNode) {
        visited[parentNode] = true;

        for (int childNode : list[parentNode]) {
            if (!visited[childNode]) {
                parent[childNode] = parentNode;
                dfs(childNode);
            }
        }
    }

    private static void bfs(int root) {
        Queue<Integer> q = new LinkedList<>();
        visited[root] = true;
        q.offer(root);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i : list[cur]) {
                if (!visited[i]) {
                    visited[i] = true;
                    parent[i] = cur;
                    q.offer(i);
                }
            }
        }
    }


}
