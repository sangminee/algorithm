package 백준.DFS_BFS;

import java.io.*;
import java.util.*;

/**
 * 나 - 부모 (1촌) - 할아버지 (2촌)
 * */
public class B2644_촌수계산 { // https://www.acmicpc.net/problem/2644

    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int person1=0, person2=0, result=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 전체 사람의 수
        st = new StringTokenizer(br.readLine());
        person1 = Integer.parseInt(st.nextToken());
        person2 = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine()); // 부모 자식들 간의 관계의 수
        // person1과 2의 촌수를 계산

        visited = new boolean[n+1];

        adj = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 부모
            int y = Integer.parseInt(st.nextToken()); // 자식

            adj[x].add(y);
            adj[y].add(x);
        }

        dfs(person1, 0);

        if(result == 0) System.out.println(-1);
        else System.out.println(result);
    }

    static void dfs(int x, int dept){
        if(x == person2){
            result = dept;
            return;
        }

        for(int i=0; i<adj[x].size(); i++){
            int y = adj[x].get(i);

            if(!visited[y]){
                visited[y] = true;
                dfs(y, dept+1);
                visited[y] = false;
            }
        }

    }
}
