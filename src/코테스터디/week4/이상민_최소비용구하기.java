package 코테스터디.week4;

import java.io.*;
import java.util.*;

/**
 * - A번째 도시에서 B도시 까지 가는데 드는 버스의 최소 비용
 * - 방향이 정해짐
 * */
public class 이상민_최소비용구하기 {  //https://www.acmicpc.net/problem/1916

    static class Bus{
        int end;
        int cost;
        public Bus(int end, int cost){
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수

        ArrayList<Bus>[] adj = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            adj[i] = new ArrayList<>();
        }

        // 버스의 정보
        StringTokenizer st;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj[start].add(new Bus(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); // 구하고 싶은 출발점 도시
        int b = Integer.parseInt(st.nextToken()); // 도착점 도시

        // 최단 거리의 비용을 저장
        long[] dist = new long[n+1];
        Arrays.fill(dist, Long.MAX_VALUE); // 초기화
        dist[a] = 0; // 출발 도시는 최단거리 값이 0 임

        boolean[] check = new boolean[n+1]; // 최단 거리가 정해졌는지 아닌지 표기

        for(int i=0; i<n; i++){

            int minIndex = 0;
            long min = Long.MAX_VALUE;

            // 최단거리가 정해지지 않고, 가장 작은 최단거리를 가지고 있는 정점 뽑기
            for(int j=1; j<=n; j++){
                if(!check[j] && min > dist[j]){
                    min = dist[j];
                    minIndex = j;
                }
            }

            check[minIndex] = true;

            for(int j=0; j<adj[minIndex].size(); j++){
                Bus bus = adj[minIndex].get(j);
                if(dist[bus.end] > dist[minIndex] + bus.cost){
                    dist[bus.end] = dist[minIndex] + bus.cost;
                }
            }
        }

        System.out.println(dist[b]);
    }
}
