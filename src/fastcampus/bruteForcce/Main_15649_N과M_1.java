package fastcampus.bruteForcce;

import java.io.*;
import java.util.*;

public class Main_15649_N과M_1 { // https://www.acmicpc.net/problem/15649

    static int N, M;
    static int[] resulted;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void dfs(int index){
        if(index == M){
            for(int i=0; i<M; i++) sb.append(resulted[i]+" ");
            sb.append('\n');
        }else{
            for(int i=1; i<=N; i++){
                if(!visited[i]){
                    resulted[index] = i;

                    visited[i] = true;
                    dfs(index+1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        resulted = new int[M];
        visited = new boolean[N+1];

        dfs(0);
        System.out.println(sb);
    }

}
