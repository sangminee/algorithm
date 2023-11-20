package 코테스터디.week2;

import java.io.*;
import java.util.*;

/**
 * 감소하는 수열
 *    1    100    2      50    60     8     7     3    6     5
 *    1    100    102    150   160  168   175   178   181   186
 *
 * i 까지의 수열이 주어졌을 때, 합이 큰 값
 *
 * i일때, i--을 해나가기 ->
 *
 * 1, 100, 2, 50 -> 50일 때부터 i--하면서 나보다 큰 값을 찾기 -> (dp[max] + 50, 50)
 *
 * 1 -> 1
 * 1, 100 -> 100
 *
 * */
public class 이상민_가장큰감소부분수열 { // https://www.acmicpc.net/problem/17216

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] data = new int[n];
        for(int i=0; i<n; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        dp[0] = data[0];

        for(int i=1; i<n; i++){
            dp[i] = data[i];
            for(int j=i-1; j>=0; j--){
                if(data[i] < data[j]){
                    dp[i] = Math.max(dp[j] + data[i], dp[i]);
                }
            }
        }

        int max = -1;
        for(int i=0; i<n; i++){
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}
