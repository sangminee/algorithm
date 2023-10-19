package inflearn.memory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2559_수열 { // https://www.acmicpc.net/problem/2559

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 온도 측정한 전체 날짜 수
        int k = Integer.parseInt(st.nextToken()); // 연속적인 날짜의 수

        st = new StringTokenizer(br.readLine());
        int[] sum = new int[n+1]; // 누적합
        for(int i=1; i<=n; i++){
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }

        // 며칠 동안의 온도의 합이 가장 큰 지
        int max = -123456789;
        for(int i=k; i<=n; i++){
            max = Math.max(max, sum[i] - sum[i-k]);
        }

        System.out.println(max);

    }
}
