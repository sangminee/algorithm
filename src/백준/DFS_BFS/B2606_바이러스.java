package 백준.DFS_BFS;

import java.util.*;
import java.io.*;

public class B2606_바이러스 { // https://www.acmicpc.net/problem/2606

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        // 1번 컴퓨터가 웜 바이러스에 걸림 -> 1번을 통해 바이러스에 걸리게 되는 컴퓨터의 수 출력

        int con = Integer.parseInt(br.readLine()); // 네트워크 상에서 직접 연결되어 있는 컴퓨터의 코드

        adj = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            adj[i] = new ArrayList<>();
        }

        visited = new boolean[n+1]; // 방문 시

        for(int i=0; i<con; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }
//        bfs(1);

        dfs(1);
        System.out.println(result);
    }

    static int result = 0;
    static boolean[] visited;

    private static void dfs(int start){ // 깊이 우선 탐색
        for(int i=0; i< adj[start].size(); i++){
            int num = adj[start].get(i);
            if(!visited[num]){
                System.out.print(num + " ");
                visited[num] = true;
                dfs(num);
                visited[num] = false;
                result++;
            }
        }
    }

    private static void bfs(int start) { // 너비 우선 탐색

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){

            int a = queue.poll();
            System.out.println(a);
            for(int i=0; i<adj[a].size(); i++){
                int num = adj[a].get(i);
                if(!visited[num]){
                    queue.add(num);
                    visited[num] = true;
                    result++;
                }
            }

        }

    }
}
