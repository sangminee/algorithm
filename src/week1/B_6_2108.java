package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class B_6_2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        int sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        int[] arr = new int[n];
        for(int i=0 ;i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if(!(map.get(arr[i]) > 1)){

            }
        }

        Arrays.sort(arr);
        // 산술평균
        sb.append(sum/n).append("\n");

        // 중앙 값
        sb.append(arr[arr.length/2]).append("\n");

        // 최빈 값


        // 범위
        sb.append(arr[arr.length/2] - arr[0]).append("\n");

    }
}
