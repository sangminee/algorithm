package 코테스터디.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 각 칸에 적혀있는 수 - 현재 칸에서 갈 수 있는 거리 의미
 * 반드시 오른쪽이나 아래쪽으로만 이동해야 함
 * 0 : 더 이상의 진행을 막는 종착점
 *
 * - 가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 규칙에 맞게 이동할 수 있는 경로의 개수 구하기
 *
 * [문제 유형]
 * - 탐색 -> 시간초과 : 같은 칸을 여러번 방문할 경우 존재
 * - DP ...
 *
 * [풀이]
 * - 너비 우선 탐색
 * - (0,0)에서 시작
 * - (n-1, n-1)에 도착하는 경우 graph[n-1][n-1] 값에 +1를 함
 * - 출력 : result[n-1][n-1]
 * */
public class 이상민_점프 { // https://www.acmicpc.net/problem/1890
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] graph;
    static long[][] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        // 게임판
        graph = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new long[n][n]; // dp[i][j]에 도착하는 횟수
        dp[0][0] = 1;

        // Bottom-up
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(graph[i][j] == 0) continue; // 0일 때, 진행 X

                int move = graph[i][j];
                if(j + move < n) dp[i][j+move] += dp[i][j]; // 오른쪽 이동
                if(i + move < n) dp[i+move][j] += dp[i][j]; // 아래 이동
            }
        }

//        print();
        // 결과
        System.out.println(dp[n-1][n-1]);
    }

    public static void print(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

}
