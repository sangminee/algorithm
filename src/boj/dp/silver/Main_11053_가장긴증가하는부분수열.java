package boj.dp.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수열 크기의 범위 : 1000
 *
 * 10 20 10 30 20 50
 *
 * n+1크기를 가진 table을 하나 선언
 * - int[][] 를 선언해서
 * - int[i][0] -> 길이  , int[i][1] -> 마지막 숫자 저장
 *
 * - 반복문을 돌면서 해당 인덱스부터 시작해서 증가하는 수열이 몇개 있는지를 저장
 *
 *
 * 반례)
 * 10 30 15 20 50 이런 수열이 존재할 때,
 *
 * 현재 내 풀이는 10 --> 30 --> 50 이 됨
 * 하지만 10 --> 15 --> 20 --> 50 이 정답이어야 함
 *
 * */
public class Main_11053_가장긴증가하는부분수열 { // https://www.acmicpc.net/problem/11053 (실버2)

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine()); // 수열의 크기

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;

        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++){
            dp[i] = 1;

            // arr[i] = 30
            // 10 20 10 30
            for(int j=1; j<i; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);  // dp[i] < dp[j] + 1  이라는 조건 추가하면 됨
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
