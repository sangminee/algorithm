package boj.dp.silver;

import java.io.*;
import java.util.*;

/**
 * 그 잔에 들어있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 다시 놓아야 함
 * - 연속으로 놓여있는 3잔을 모두 마실 수 없음
 *
 * 출력 : 가장 많은 양의 포도주를 마실 수 있는 프로그램 작성
 *
 * dp : i번째 까지의 수열일 때 마실 수 있는 포도주 양
 *
 * */
public class Main_2156_포도주시식 { // https://www.acmicpc.net/problem/2156 (실버1)

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine()); // 프도주 잔의 개수
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine()); // 포도의 양
        }

        int[] dp = new int[10001];

        dp[0] = arr[0]; // n = 1
        if(n >= 2) dp[1] = arr[0] + arr[1]; // n = 2
        if(n >= 3) dp[2] = Math.max(dp[1], Math.max(dp[0] + arr[2], arr[1] + arr[2]));
        if(n >= 4){
            for(int i=3; i<n; i++){
                dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]));
            }
        }

        int max = -1;
        for(int i=0; i<n; i++){
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }

}
