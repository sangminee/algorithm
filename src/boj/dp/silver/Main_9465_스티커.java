package boj.dp.silver;

import java.io.*;
import java.util.*;

/**
 * 스티커 : 2행 n열로 배치
 *
 * - 뗀 스티커와 변을 공유하는 스티커는 모두 찢어져서 사용할 수 없게 됨 (왼쪽, 오른쪽, 위, 아래)
 * - 각 스티커에 점수를 매기고, 2n개의 스티커 중에서 점수의 합이 최대가 되면서 서로 변을 공유하지 않는 스티커 집합 고르기
 *
 *
 * [풀이 방법]
 * - 가장 큰 값 부터 제거
 *
 * */
public class Main_9465_스티커 { // https://www.acmicpc.net/problem/9465 (실버1)

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        int testCase = Integer.parseInt(br.readLine());

        while(testCase-->0){
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n+1];
            int[][] dp = new int[2][n+1]; // 각 경우의 수까지 왔을 때 최대

            for(int i=0; i<2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            // 최대 - 대각선, 대각선 옆
            for(int i=2; i<=n; i++){
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + arr[1][i];
            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));


            // 시간 초과 - 완전 탐색으로 풀이
//            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
//            int[][] arr = new int[2][n];
//
//            for(int i=0; i<2; i++){
//                st = new StringTokenizer(br.readLine());
//                for(int j=0; j<n; j++){
//                    int data = Integer.parseInt(st.nextToken());
//                    arr[i][j] = data;
//                    priorityQueue.add(data);
//                }
//            }
//
//            int sum = 0;
//            while (!priorityQueue.isEmpty()){
//                int num = priorityQueue.poll();
//                boolean check = false;
//                for(int i=0; i<2; i++){
//                    for(int j=0; j<n; j++){
//
//                        // 같은 값이 존재할 때 오류 발생 -> 이미 점수를 더한 num도 -1로 변경
//                        if(arr[i][j] == num && arr[i][j] != -1){
//                            sum += num;
//                            arr[i][j] = -1;
//                            if(j-1>=0) arr[i][j-1] = -1; // 왼
//                            if(j+1<n) arr[i][j+1] = -1; // 오
//                            if(i-1>=0) arr[i-1][j] = -1; // 위
//                            if(i+1<2) arr[i+1][j] = -1; // 아래
//                            check = true;
//                            break;
//                        }
//                    }
//                    if(check) break;
//                }
//            }
//            sb.append(sum).append("\n");
        }

        System.out.println(sb);

    }
}
