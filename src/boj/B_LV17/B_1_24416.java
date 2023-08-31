package boj.B_LV17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1_24416 {

    /**
     * 동적 계획법
     */
    static int n;
    static int reCount, dpCount;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 각 코드의 실행 횟수 출력
        // 1. 재귀
        fib(n);

        // 2. DP
        dp = new int[n];
        dp(n);

        System.out.println(reCount+" "+dpCount);
    }

    private static int fib(int x) {
        if (x == 1 || x == 2) {
            reCount++;
            return 1;  // 코드 1
        } else {
            return fib(x - 1) + fib(x - 2);
        }
    }

    private static void dp(int n) {
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<n; i++){
            dp[i] = dp[i-1] + dp[i-2];  // 코드 2
            dpCount++;
        }
    }

}
