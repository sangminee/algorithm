package boj.tree;

import java.io.*;
import java.util.*;

// 트리 -> 그래프
// 1. 인접 리스트로 구현
// 2. 정점 x가 Parent를 안다면 자신의 자식 Children을 찾을 수 있음
// - Root 부터 차례대로 문제 해결
// - Root를 시작으로 하는 그래프 탐색 문제
// - 탐색 알고리즘 -> BFS or DFS

public class Main_11725_트리의부모찾기 { // https://www.acmicpc.net/problem/11725 (실버2)

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;

    // 2번 노드부터 부모 노드 번호를 출력

    static int[] value;

    static void dfs(int x){  // x : start
        for(int y : adj[x]){   // 6, 4
            if(!visited[y]) {
                value[y] = x;
                visited[x] = true;
                dfs(y);
            }
        }
    }

    static void dfs(int x, int parent){
        for(int y : adj[x]){
            if( y == parent) continue;
            value[y] = x;
            dfs(y, x);
        }
    }

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine()); // 노드의 개수 = 정점의 개수

        adj = new ArrayList[N+1];
        for(int i=0; i<N+1; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=1; i<=N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        visited = new boolean[N+1];
        value = new int[N+1];
        dfs(1);

        // 결과
        for(int i=2; i<=N; i++){
            sb.append(value[i]).append("\n");
        }
        System.out.println(sb);
    }

}

