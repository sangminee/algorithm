package boj.dp.silver;

import java.io.*;

public class Main_11726_2xn타일링 { // https://www.acmicpc.net/problem/11726 (실버3)

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1001]; // i일때 채울 수 있는 타일의 수

        // 초기값
        dp[1] = 1; // 주의
        dp[2] = 2;
        dp[3] = 3;

        if(n > 3){
            for(int i=4; i<=n; i++){
                dp[i] = (dp[i-1] + dp[i-2]) % 10007;
            }
        }
        System.out.println(dp[n]);
    }
}
