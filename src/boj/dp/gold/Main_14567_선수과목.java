package boj.dp.gold;

import java.io.*;
import java.util.*;

/**
 * - 선수과목 조건을 반드시 지켜야만 함
 * 1. 한 학기에 들을 수 있는 과목 수에는 제한이 없음
 * 2. 모든 과목은 매 학기 항상 개설됨
 *
 * - 각 과목이 최소 몇 학기에 이수할 수 있는지 확인
 *
 * 출력 : 1번 과목부터 차례대로 최소 몇 학기에 이수할 수 있는지를 공백으로 구분하여 출력
 *
 * */
public class Main_14567_선수과목 { // https://www.acmicpc.net/problem/14567 (골드5)

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 과목의 수
        int m = Integer.parseInt(st.nextToken()); // 선수 조건의 수

        int[] dp = new int[n+1]; // 각 과목이 이수할 수 있는 학기
        dp[0] = 0; // 초기값

        // arr : 선수 과목의 수 집어 넣기
        ArrayList<Integer>[] arr = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
            arr[i].add(0);
        }

        /**
         * 1 - 0
         * 2 - 0, 1
         * 3 - 0, 1
         * 4 - 0
         * 5 - 0, 2, 4
         * 6 - 0
         * */

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // b의 선수 과목
            int b = Integer.parseInt(st.nextToken());

            arr[b].add(a);
        }

        for(int i=1; i<=n; i++){
            for(int j : arr[i]){ // i의 선수 과목들을 탐색
                dp[i] = Math.max(dp[i], dp[j]+1); // dp[j]는 dp[i]보다 항상 먼저 들어야 함
            }
        }

        for(int i=1; i<=n; i++){
            System.out.print(dp[i]+" ");
        }

    }

}
