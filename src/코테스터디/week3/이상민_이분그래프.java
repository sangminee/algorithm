package 코테스터디.week3;

import java.io.*;
import java.util.*;

public class 이상민_이분그래프 { // https://www.acmicpc.net/problem/1707

    static ArrayList<Integer>[] adj;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while(k-->0){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()); // 정점의 개수
            int e = Integer.parseInt(st.nextToken()); // 간선의 개수

            ans = false;
            adj = new ArrayList[v+1];
            visited = new int[v+1];

            for(int i=0; i<v+1; i++){
                adj[i] = new ArrayList<>();
            }

            for(int i=0; i<e; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                adj[a].add(b);
                adj[b].add(a);
            }



            for(int i=1; i<=v; i++){
                if(visited[i] == 0){
                    dfs(i, 1);
                }
            }

            if(ans) System.out.println("NO");
            else System.out.println("YES");
        }

    }

    static int[] visited;
    static boolean ans;

    static void dfs(int x, int col){
        visited[x] = col;
        if(ans) return;

        for(Integer num : adj[x]){
            if(visited[x] == visited[num]){
                ans = true;
                return;
            }
            if(visited[num] == 0){
                dfs(num, col * -1);
            }

        }
    }
}