package boj.B_LV10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B_LV10_6_2108 {

    static int[] arr = new int[500000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        int sum = 0;
        int[] cnt = new int[8002];

        for(int i=0 ;i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());

            if(arr[i] < 0){
                cnt[arr[i] + 4000]++;   // 값이 음수일 때
            }else{
                cnt[arr[i] ]++;   // 값이 양수일 때
            }
        }

        Arrays.sort(arr);

        // 산술평균
//        int sumReslut = String.format();
        sb.append(sum/n).append("\n");

        // 중앙 값
        sb.append(arr[arr.length/2]).append("\n");

        // 최빈 값
        int result = -1;

        List<Integer> list = new ArrayList<>();
        // 음수
        for(int i=4001; i<8002; i++){
            if(cnt[i] > result){
                result = cnt[i];
            }else if(cnt[i] == result){
                list.add(result);
            }
        }
        // 양수
        for(int i=1; i<4000; i++){
            if(cnt[i] > result){
                result = cnt[i];
            }else if(cnt[i] == result){
                list.add(result);
            }
        }

        sb.append(result).append("\n");

        // 범위
        sb.append(arr[arr.length-1] - arr[0]).append("\n");

        System.out.println(sb);

    }
}
