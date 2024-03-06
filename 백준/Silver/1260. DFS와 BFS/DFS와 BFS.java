import java.io.*;
import java.util.*;

public class Main { // https://www.acmicpc.net/problem/1260 (실버2)

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Integer>[] adj; // ArrayList 객체의 배열을 선언
    static StringBuilder sb = new StringBuilder();
    static int N,M,V;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수
        V = Integer.parseInt(st.nextToken()); // 정점의 번호

        // 인접 행렬

        // 인접리스트
        adj = new ArrayList[N+1];
        // 배열 내의 각 ArrayList 객체 초기화
        for(int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        visited = new boolean[N+1];
        dfs(V);

        visited = new boolean[N+1];
        bfs(V);

        System.out.println(sb);
    }

    // 깊이 우선 탐색
    static void dfs(int x){
        sb.append(x+" ");
        visited[x] = true;

        Collections.sort(adj[x]);
        for(int y : adj[x]){
            if(visited[y]) continue;
            dfs(y);
        }

//        for(int i=0; i<adj[x].size(); i++){
//            int num = adj[x].get(i);
//            if(!visited[num]) dfs(num);
//        }
    }

    // 넢이 우선 탐색
    static void bfs(int x){
        sb.append("\n");

        // Queue : FIFO
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;

        while(!queue.isEmpty()){
            x = queue.poll();
            sb.append(x+" ");

            Collections.sort(adj[x]);
            for(int y : adj[x]){
                if(visited[y]) continue;
                queue.add(y);
                visited[y] = true;
            }
            
//            for(int i=0; i<adj[x].size(); i++){
//                int num = adj[x].get(i);
//
//                if(!visited[num]){
//                    queue.add(num);
//                    visited[num] = true;
//                }
//            }
        }

    }
}
