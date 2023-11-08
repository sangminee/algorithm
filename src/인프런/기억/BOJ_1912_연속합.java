package 인프런.기억;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912_연속합 { // https://www.acmicpc.net/problem/1912

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine()); // 수열 크기

        int[] data = new int[n+1];
        int[] result = new int[n+1];
        int max = -123456789;

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            data[i] = Integer.parseInt(st.nextToken());
            result[i] = Math.max(data[i], result[i-1] + data[i]);
            max = Math.max(max, result[i]);
        }

        // 연속된 숫자 중 가장 큰 수
        System.out.println(max);
    }
}
