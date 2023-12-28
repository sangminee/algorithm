package 코테스터디.week1;

import java.io.*;
import java.util.*;

/**
 *
 * [DFS]
 * - 깊이 우선 탐색
 * - stack (LIFO)
 *
 * [BFS]
 * - 너비 우선 탐색
 * - queue (FIFO) -> 선입선출
 *
 * */
public class B1260_DFS와BFS { // https://www.acmicpc.net/problem/1260

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, v;
    static StringTokenizer st;
    static ArrayList<Integer>[] adj; // 인접 리스트
    static boolean[] visited; // 방문 정점
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken()); // 탐색 시작할 정점 번호

        adj = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        for(int i=0; i<=n; i++){
            Collections.sort(adj[i]);
        }

        visited = new boolean[n+1];
        DFS(v);
        sb.append("\n");

        visited = new boolean[n+1];
        BFS(v);

        System.out.println(sb);
    }

    private static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            int num = queue.poll();
            if(!visited[num]){
                sb.append(num).append(" ");
                visited[num] = true;
            }
            for(int i=0; i<adj[num].size(); i++){
                int a = adj[num].get(i);
                if(!visited[a]){
                    queue.add(a);
                }
            }
        }

    }

    private static void DFS(int x) {
        visited[x] = true;
        sb.append(x).append(" ");
        for(int i=0; i<adj[x].size(); i++){
            int a = adj[x].get(i);
            if(!visited[a]) {
                DFS(a);
            }
        }
    }
}
