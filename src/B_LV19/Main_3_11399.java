package B_LV19;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3_11399 { // ATM (11399)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i][0] = i+1;
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        int sum = 0;
        for(int i=0; i<n; i++){

            for(int j=0; j<=i; j++){
                sum += arr[j][1];
            }
        }
        System.out.println(sum);
    }
}
