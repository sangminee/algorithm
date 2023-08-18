package boj.dp.silver;

import java.io.*;
import java.util.*;

/**
 * 10
 * 1 100 2 50 60 3 5 6 7 8
 *
 *
 * 합이 가장 큰 증가하는 부분 수열
 *
 * */
public class Main_11055_가장큰증가하는부분수열 { // https://www.acmicpc.net/problem/11055 (실버2)

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine()); // 수열의 크기

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            dp[i] = arr[i];

            for(int j=0; j<i; j++){
                if(arr[j] < arr[i] && dp[i] < dp[j] + arr[i]){
                    dp[i] = dp[j] + arr[i];
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

}
