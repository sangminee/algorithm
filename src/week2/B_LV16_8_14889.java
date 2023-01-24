package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_LV16_8_14889 {

    // https://www.acmicpc.net/problem/14889

    static int n;
    static int[][] arr;

    static int start, link;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());  // n은 짝수

        StringTokenizer st;
        arr = new int[n+1][n+1];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i+1][j+1] = Integer.parseInt(st.nextToken());
            }
        }

        start = n/2;
        link = n/2;

//        for(int i=0; i<n; i++){
//            for(int j=0; j<n; j++){
//                System.out.print(arr[i+1][j+1]+" ");
//            }
//            System.out.println();
//        }


        // 스타트 팀과 링크 팀의 능력치 차이의 최솟값 출력
        // 1. 스타트 팀과 링크 팀 조합 찾기
        dfs(0);

        // 2. 각 팀의 최대 능력치, 최소 능력치 찾기

    }

    private static void dfs(int i) {
    }
}
