package boj.B_LV17;

import java.io.*;

public class B_11_2156 {
    // 포도주 시식 (2156)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] result = new int[n+1];
        result[0] = arr[0];   // n = 1
        if(n>=2) result[1] = arr[0] + arr[1];  // n = 2
        if(n>=3) result[2] = Math.max(result[0]+arr[2], Math.max(result[1], arr[1]+arr[2]));

        if(n >= 4){
            for(int i=3; i<n; i++){
                result[i] = Math.max(arr[i]+result[i-2], Math.max(arr[i]+arr[i-1]+result[i-3],result[i-1]));
            }
        }

        int MAX = -1;
        for(int i=0; i<n; i++){
            if(result[i] > MAX) {
                MAX = result[i];
            }
        }
        System.out.print(MAX);
    }
}
