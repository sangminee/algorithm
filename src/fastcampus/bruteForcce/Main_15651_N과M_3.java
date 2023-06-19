package fastcampus.bruteForcce;

import java.io.*;
import java.util.*;

public class Main_15651_N과M_3 {  // https://www.acmicpc.net/problem/15651

    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] resulted; // 결과 값

    static void dfs(int index){ // x : 인덱스
        if(index == M){
            for(int i=0; i<M; i++) sb.append(resulted[i]+ " ");
            sb.append('\n');
        }else{
            for(int i=1; i<=N; i++) {
                resulted[index] = i;
                dfs(index+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        resulted = new int[M];

        dfs(0);
        System.out.print(sb);
    }
}
