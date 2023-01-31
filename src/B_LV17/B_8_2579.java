package B_LV17;

import java.io.*;

public class B_8_2579 { // 계단 오르기 (2579)
    // https://www.acmicpc.net/problem/2579
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 연속된 세계의 계단 오를 수 x

        // 최댓값
        int n = Integer.parseInt(br.readLine()); // 계단 수
        /*
        * 10 - 10
        * 20 - 10 + 20 = 30
        * ----------------------------  n = 2 까지는 최대 값이 정해져 있음
        * 15 - 20 + 15 = 35
        * 25 - 10 + 20 + 25 = 55
        * 10 - 10 + 20 + 25 + 10 = 65
        * 20 - 10 + 20 + 25 + 20 = 75
        * */

        int[] arr = new int[300+1];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] result = new int[300+1]; // 계단 수에 따른 최댓값
        result[1] = arr[1];
        result[2] = arr[1] + arr[2];
        result[3] = arr[3] + Math.max(arr[1], arr[2]);

        // bottom - up
        for(int i=4; i<=n; i++){
            result[i] = arr[i] + Math.max(arr[i-1]+result[i-3], result[i-2]);
        }
        System.out.println(result[n]);

    }

}
