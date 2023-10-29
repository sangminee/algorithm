package 코테스터디.탐색;

import java.io.*;
import java.util.*;

/**
 * [DFS]
 * 문제 분석
 *  - DFS가 탐색한 모든 노드의 집합
 *
 * result : 연결 요소의 개수
 * */
public class Main_11724_연결요소의개수 { // https://www.acmicpc.net/problem/11724

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점 개수
        int m = Integer.parseInt(st.nextToken()); // 간선 개수

        // 인접 리스트 구현
        graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++){
            graph[i] = new ArrayList<>(); // 초기화
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        // 방문 배열 구현
        visited = new boolean[n+1];

        int count = 0;
        // 임의의 시작 점에서 DFS 수행 (주로 1)
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
    }

    static void dfs(int node){
        if(visited[node]){
            return;
        }
        visited[node] = true;
        for(int i : graph[node]){
            if(!visited[i]){
                dfs(i);
            }
        }

//        for(int i=0; i<graph[node].size(); i++){
//            int num = graph[i].get(i);
//            if(!visited[num]) {
//                visited[num] = true;
//                dfs(num);
//            }
//        }
    }
}
