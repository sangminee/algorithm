package boj.dp.gold;

import java.io.*;

/**
 * [문제]
 * - 목적지까지 번호순서대로 일렬로 서서 걸어가도록
 * - 아이들의 번호순서가 바뀌었음
 *
 * - 다시 번호 순서대로 줄을 세우기 위해서 아이들의 위치를 옮기려고 함
 * - 위치를 옮기는 아이들의 수를 최소로
 *
 * n = 7
 * 3 7 5 2 6 1 4 (4이동)
 *
 * 3 7 4 5 2 6 1 (7이동)
 * 3 4 5 2 6 1 7 (1이동)
 * 1 3 4 5 2 6 7 (2이동)
 *
 * 1 2 3 4 5 6 7
 *
 * 출력 : 번호 순서대로 줄을 세우는데 옮겨지는 아이들의 최소 수
 *
 * [풀이 방법]
 * - 증가하는 수 찾기
 *
 * - 이 문제가 왜 dp ?
 * - 가장 긴 오름차순 길이 응용
 * - LIS (Longest Increasing Subsequence, 최장 증가 부분 수열)문제임
 * -> 최장 증가 부분 수열의 길이가 얼마인지 푸는 것이기 때문에 DP를 이용하는 것임
 *
 * ex) 3 7 5 2 6 1 4
 * LIS : 3 5 6
 * -> 7, 2, 1, 4 를 이동시키면 됨  -> result = N - LIS.size()
 *
 * */
public class Main_2631_줄세우기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());

        int[] line = new int[N+1];
        for(int i=1; i<=N; i++){
            line[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N+1]; // i인 배열이 존재할 때, 최대 배열의 수
        dp[0] = 0;

        int maxIncreasing = 0;
        for(int i=1; i<=N; i++){
            int num = line[i];
            dp[i] = 1; // 기본 값

            for(int j=1; j<=i; j++){
                if(line[j] < num){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxIncreasing = Math.max(maxIncreasing, dp[i]);
                }
            }
        }

        System.out.println(N-maxIncreasing);

    }
}
