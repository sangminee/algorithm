package boj.B_LV17;

import java.io.*;
import java.util.StringTokenizer;

public class B_13_11054 { // 가장 긴 바이토닉 부분 수열 (11054)

    // LIS (최장 증가 부분 수열)

    // https://www.acmicpc.net/problem/11054

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 1  5  2  1  4  3  4  5  2  1

        // case1) 오름차순
        // 1  2  2  1  3  3  4  5  2  1

        // case2) 내림차순
        // 1  5  2  1  4  3  3  3  2  1

        // case3) 올라갔다 내려갔다 - 바이토닉 수열
        // 1  6  3  1  6  5  6  7  3  1

        int[] asc_result = new int[n];
        for(int i=0; i<n; i++){
            asc_result[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j] && asc_result[i] < asc_result[j] + 1){
                    asc_result[i] = asc_result[j] + 1;
                }
            }
        }

        int[] dsc_result = new int[n];
        for(int i=n-1; i>=0; i--){
            dsc_result[i] = 1;
            for(int j=n-1; j>i; j--){
                if(arr[i] > arr[j] && dsc_result[i] < dsc_result[j] + 1){
                    dsc_result[i] = dsc_result[j] + 1;
                }
            }
        }


        int max = -1;
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            result[i] = asc_result[i] + dsc_result[i] - 1;
            if(result[i] > max){
                max = result[i];
            }
        }

        System.out.print(max);
    }

}
