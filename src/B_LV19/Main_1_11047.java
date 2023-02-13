package B_LV19;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1_11047 {  // 동전 0 (11047)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i=n-1; i>=0; i--){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int index = 0;
        int count = 0;
        while(k != 0){
            if(k - arr[index] >= 0){
                count++;
                k = k - arr[index];
            }else{
                index++;
            }
        }
        System.out.println(count);

    }
}
