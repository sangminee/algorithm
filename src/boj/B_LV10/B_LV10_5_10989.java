package boj.B_LV10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_LV10_5_10989 {

    // 카운팅 정렬 (Counting Sort)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] cnt = new int[10001];

        for(int i=0; i<n; i++){
            cnt[Integer.parseInt(br.readLine())]++;
        }

//        Arrays.sort(arr);
//        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<10001; i++){
            while(cnt[i] > 0){
                sb.append(i).append("\n");
                cnt[i]--;
            }
        }

        System.out.println(sb);
    }
}
