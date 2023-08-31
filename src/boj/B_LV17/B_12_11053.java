package boj.B_LV17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_12_11053 {  // 가장 긴 증가하는 부분 수열 (11053)

    // https://www.acmicpc.net/problem/11053

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        int[] result = new int[n];

        // A = {10, 20, 10, 30, 20, 50}
        // result = {1, 2, 1, 3, 2, 4}

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = -1;
        for(int i=0; i<n; i++){
            result[i] = 1; // 기본적인

            for(int j=0; j<i; j++){
                if(arr[j] < arr[i] && result[i] < result[j] + 1){
                    result[i] = result[j] + 1;
                }
            }
            max = Math.max(max, result[i]);
        }

        System.out.println(max);
    }

}
