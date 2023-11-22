package 백준.다익스트라;

import java.io.*;
import java.util.*;

public class B1753_최단경로 { // https://www.acmicpc.net/problem/1753

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Node>[] list;
    static int[] result;

    static class Node implements Comparable<Node> {
        int i; // 이어진 그래프
        int w; // 가중치
        public Node(int i, int w){
            this.i = i;
            this.w = w;
        }
        public int compareTo(Node o){
            return this.w - o.w;
        }
    }

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken()); // 정점의 개수
        int e = Integer.parseInt(st.nextToken());  // 간선의 개수

        int k = Integer.parseInt(br.readLine()); // 시작 정점의 번호
        list = new ArrayList[v+1];

        for(int i=0; i<=v; i++){
            list[i] = new ArrayList<>();
        }

        // 각 간선을 나타내는 3개의 정수가 주어짐
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, w)); // 방향이 있는 그래프임
        }

        result = new int[v+1];
        Arrays.fill(result, Integer.MAX_VALUE); // 초기값 세팅

        // 다익 스트라
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[v+1]; // 최단경로 탐색이 끝났으면 탐색 X

        // 시작점 (k) 은 최단 경로가 0임
        pq.add(new Node(k, 0));
        result[k] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(check[now.i]) continue;
            check[now.i] = true;

            for(Node node : list[now.i]){
                int nodeNum = node.i;
                int nodeValue = node.w;

                if(result[nodeNum] > result[now.i] + nodeValue){
                    result[nodeNum] = result[now.i] + nodeValue;
                    pq.add(new Node(nodeNum, result[nodeNum])); // 1부터 node.i 까지의 최단 경로가 구해짐
                }

            }
        }

        for(int i=1; i<=v; i++){
            if(result[i] == Integer.MAX_VALUE){
                sb.append("INF\n");
            }else{
                sb.append(result[i]+"\n");
            }
        }

        System.out.println(sb);
    }

}
