package boj.dp.silver;

import java.io.*;

/**
 * 이 문제가 dp인 이유?
 *
 * 1. 우선 완선 탐색으로 접근을 해본다 -> n이 커질수록 탐색해야 하는 경우가 많아짐
 * 2.
 *
 * <풀이 방법>
 *     1) 풀고 싶은 가짜 문제 정의
 *     2) 가짜 문제를 풀면 진짜 문제를 풀 수 있는가
 *     3) 초기 값은 어떻게 되는가
 *     4) 점화식 구해내기
 *     - 공통점이 있는 것들을 묶어내기
 *     5) 진짜 문제 정답 출력하기
 *     </풀이>
 * */
public class Main_9095_123더하기 { // https://www.acmicpc.net/problem/9095

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int testCase = Integer.parseInt(br.readLine());

        // 진짜 문제 : 주어진 n에 대해 1,2,3의 합으로 표현
        // 가짜 문제 : i를 1,2,3의 합으로 표현
        long[] dp = new long[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<11; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        while(testCase --> 0){
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}
