package boj.dp.gold;

import java.io.*;
import java.util.*;

/**
 * 1 -> 4 -> 5 => 45
 * 2 => 20
 * 3 -> 4 -> 5 => 45
 * 4
 * */
public class Main_15486_퇴사2 { // https://www.acmicpc.net/problem/15486 (골드5)

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());

        int[][] data = new int[N+2][2];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken()); // 기간
            data[i][1] = Integer.parseInt(st.nextToken()); // 금액
        }

        int[] dp = new int[N+2]; // i일 까지 일했을 때의 최대 수익
        int max = -1;
        for(int i=1; i<=N+1; i++){
            // 현재 시점까지의 최대 수익
            if(max < dp[i]) {
                max = dp[i];
            }
            int nextDay = i + data[i][0]; // 다음날
            if(nextDay <= N+1){
                dp[nextDay] = Math.max(dp[nextDay], max + data[i][1]);
            }
        }
        System.out.println(dp[N+1]);

    }
}
