package 백준.dp;

import java.io.*;
public class B11057_오르막수 { // https://www.acmicpc.net/problem/11057

    static int n, count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+2][10];

        for(int i=0; i<=9; i++){
            dp[1][i] = 1;
        }

        for(int i=2; i<=n; i++){
            for(int j=0; j<=9; j++){
                for(int k=j; k<=9; k++){
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }


        int sum = 0;
        for(int i=0; i<=9; i++){
            sum += dp[n][i];;
        }

        System.out.println(sum%= 10007);
    }

}
