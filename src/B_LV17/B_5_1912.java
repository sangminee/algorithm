package B_LV17;

import java.io.*;
import java.util.StringTokenizer;

public class B_5_1912 {  // 연속합 (1912)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] result = new int[N];

        // 10  -4   3   1   5   6   -35   12   21   -1
        // 10  -4   3   4   9   15  -35   12   33   -1

        // 2  1  -4  3  4  -4  6  5  -5  1
        // 2  3  -4  3  7   3  9  14  9  10

        // -1  -2  -3  -4  -5
        // -1  -2  -3  -4  -5

        // result[i-1] + arr[i] > arr[i] -> result[i] = result[i-1] + arr[i]
        // result[i-1] + arr[i] < arr[i] -> result[i] = arr[i]

        result[0] = Integer.parseInt(st.nextToken());
        for(int i=1; i<N; i++) {
            int value = Integer.parseInt(st.nextToken());
            if(result[i-1] + value > value){
                result[i] = result[i-1] + value;
            }else{
                result[i] = value;
            }
        }

        int max = result[0];
        for(int i=1; i<N; i++){
            max = Math.max(max, result[i]);
        }
        System.out.println(max);

    }
}
