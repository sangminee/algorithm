package boj.dp.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2293_동전1 { // https://www.acmicpc.net/problem/2293(골드5)

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n,k;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 동전 개수
        k = Integer.parseInt(st.nextToken());  // 원하는 가치의 합

        int[] dp = new int[k+1]; // 해당 가치를 만들 수 있는 동전의 경우의 수
        for(int i=1; i<=n; i++){
            int coin = Integer.parseInt(br.readLine());

            for(int j=1; j<=k; j++){
                if(j - coin > 0) dp[j] = dp[j] + dp[j-coin];
                else if(j - coin == 0) dp[j] = dp[j] + 1;
            }
        }
        System.out.println(dp[k]);

//        for(int i=1; i<=k; i++){
//            System.out.print(dp[i]+" ");
//        }
    }

}
