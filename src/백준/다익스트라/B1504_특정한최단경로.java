package 백준.다익스트라;

import java.io.*;
import java.util.*;

/**
 * - 방향성이 없는 그래프
 *
 *
 * - 1번 정점에서 N번 정점으로 최단거리로 이동  -->
 *
 * - 최단 경로를 구해야 함
 *
 * */
public class B1504_특정한최단경로 { // https://www.acmicpc.net/problem/1504

    static ArrayList<Edge>[] adj;
    static int n;
    static int MAX = 200_000_000;

    static class Edge implements Comparable<Edge> {
        int num;
        int weight;

        public Edge(int num, int weight){
            this.num = num;
            this.weight = weight;
        }

        public int compareTo(Edge e){
            return this.weight - e.weight;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int e = Integer.parseInt(st.nextToken()); // 간선의 개수

        adj = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new Edge(b, c));
            adj[b].add(new Edge(a, c));
        }

        // 반드시 u와 v를 거치면서 최단거리 구하기
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken()); // 2
        int v = Integer.parseInt(st.nextToken()); // 3

        // u와 v의 최단 경로 구하기 -> 시작값 : 1 , 끝값 : n

        // 1 ~ u 최단 경로
        // u ~ v 최단 경로
        // v ~ n 최단경로

        // 1) 1 -> u -> v -> n
        int result1 = 0;
        result1 += find(1, u);
        result1 += find(u, v);
        result1 += find(v, n);

        // 2) 1 -> v -> u -> n
        int result2 = 0;
        result2 += find(1, v);
        result2 += find(v, u);
        result2 += find(u, n);

        int ans = (result1 >= MAX && result2 >= MAX) ? -1 : Math.min(result1, result2);
        System.out.println(ans);
    }

    static int find(int start, int end){
        int[] dist = new int[n+1];
        Arrays.fill(dist, MAX);
        boolean[] check = new boolean[n+1];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Edge current = pq.poll();
            if(check[current.num] == true) continue;
            check[current.num] = true;

            for(Edge edge : adj[current.num]){
                if(dist[edge.num] > dist[current.num] + edge.weight){
                    dist[edge.num] = dist[current.num] + edge.weight;
                    pq.add(new Edge(edge.num, dist[edge.num]));
                }
            }
        }
        return dist[end];
    }
}
