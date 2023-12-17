package 백준.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10451_순열사이클 { // https://www.acmicpc.net/problem/10451

    static int[] arr;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            int n = Integer.parseInt(br.readLine()); // 순열의 크기
            arr = new int[n+1];
            visited = new boolean[n+1];
            answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<=n; i++){
                if(!visited[i]){
                    answer++;
                    dfs(i);
                }
            }

            System.out.println(answer);
        }
    }

    static void dfs(int i) {
        if(visited[i]) return;

        visited[i] = true;
        dfs(arr[i]);
    }
}
