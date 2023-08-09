package boj.dp.silver;

import java.io.*;

public class Main_17626_FourSquares { // https://www.acmicpc.net/problem/17626 (실버3)

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        int[] dp = new int[50001]; // i의 수는 몇개의 제곱근으로 이루어져 있나
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        dp[4] = 1;

        if(n > 4){
            int temp = 2; // 현재까지의 제곱근 수
            for(int i=5; i<=n; i++){
                if((temp+1) * (temp+1) == i){
                    temp++;
                    dp[i] = 1;
                }else{
                    int min =Integer.MAX_VALUE;
                    for(int j=1; j<=temp; j++){
                        if( i - (j*j) > 0) min = Math.min(min, 1 + dp[i - (j*j)]);
                    }
                    dp[i] = min;
                }
            }
        }


        System.out.println(dp[n]);
    }

}
