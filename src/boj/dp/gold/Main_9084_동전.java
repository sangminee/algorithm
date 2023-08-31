package boj.dp.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9084_동전 { // https://www.acmicpc.net/problem/9084 (골드5)
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] arr;
    static int n, m;

    public static void main(String[] args) throws IOException {
        // 주어진 금액을 만드는 모든 방법
        int testCase = Integer.parseInt(br.readLine());

        while(testCase-->0){
            n = Integer.parseInt(br.readLine()); // 동전의 가지수
            st = new StringTokenizer(br.readLine());
            arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            m = Integer.parseInt(br.readLine()); // 만들어야 하는 금액

            int[] dp = new int[m+1]; // i를 만들 수 있는 동전 경우의 수
            for(int i=0; i<n; i++){
                int coin = arr[i];

                for(int j=1; j<=m; j++){
                    if(j-coin > 0) dp[j] = dp[j] + dp[j-coin];
                    else if(j-coin == 0) dp[j] = dp[j] + 1;
                }

            }
            System.out.println(dp[m]);
        }
    }

}
