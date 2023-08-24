package boj.dp.silver;

import java.io.*;

public class Main_10844_쉬운계단수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final static long mod = 1000000000;
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine()); // 길이가 n인 계단 수가 총 몇 개 있는지

        long[][] dp = new long[101][10];

        // 기본값
        for(int i=0; i<=9; i++){
            dp[1][i] = 1;
        }

        if(n>=2){
            for(int i=2; i<=n; i++){
                dp[i][0] = dp[i-1][1] % mod;
                for(int j=1; j<=8; j++){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1] % mod;
                }
                dp[i][9] = dp[i-1][8] % mod;
            }
        }

        long sum = 0;
        for(int i=1; i<=9; i++){
            sum += dp[n][i];
        }
        System.out.println(sum % mod);

    }
}
