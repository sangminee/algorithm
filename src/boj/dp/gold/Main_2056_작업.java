package boj.dp.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * - 수행해야 할 작업 N개 존재 (3 <= N <= 10000)
 * - 각각의 작업마다 걸리는 시간 주어짐
 * - 작업들 간에 선행 관계라는 것이 존재 -> 먼저 완료되어야 할 작업들 존재
 *
 * 1 : 0 ~ 5
 * 2 : 5 ~ 6
 * 3 : 6 ~ 9
 * 4 : 5 ~ 11
 * 5 : 6 ~ 12
 * 6 : dp[2] ~ dp[4] + num = 19
 *
 * */
public class Main_2056_작업 { // https://www.acmicpc.net/problem/2056

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        // 모든 작업을 완료하기 위해 필요한 최소 시간을 구하기
        ArrayList<Integer>[] arr = new ArrayList[n];
        for(int i=0; i<n; i++){
            arr[i] = new ArrayList<>();
        }

        int[] dp = new int[n+1]; // 작업을 완료하기 위한 최소 선행
        dp[0] = 0;
        int max = -1;
        for(int i=1; i<=n; i++){ //
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken()); // 기본 값 - 각각의 작업마다 걸리는 시간
            int num = Integer.parseInt(st.nextToken()); // 선행 관계에 있는 작업의 개수

            dp[i] = time;
            for(int j=0; j<num; j++){
                int temp = Integer.parseInt(st.nextToken());
                dp[i] = Math.max(dp[i], dp[temp] + time);
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }

}
