package boj.B_LV17;

import java.io.*;

public class B_3_1904 {
    // https://www.acmicpc.net/problem/1904
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 타일 : 0또는 1이 쓰여 있는 낱장의 타일들
        // 동주 -> 현재 : 1 또는 00의 타일들만 존재하게 됨
        // 결과 값 : N이 주어졌을 때 지원이가 만들 수 있는 모든 가짓수를 세기

        int[] result = new int[N+2];

        result[0] = 0;
        result[1] = 1; // 1
        result[2] = 2; // 00, 11

        // N = 3 -> 3 -> result[1] + result[2] -> 3개
        // N = 4 -> 5 -> result[2] + result[3] -> 5개

        if(N >=3){
            for(int i=3; i<=N; i++){
                result[i] = (result[i-1] + result[i-2]) % 15746;
            }
        }

        System.out.println(result[N]);

    }
}
