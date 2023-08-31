package boj.dp.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1106_호텔 { // https://www.acmicpc.net/problem/1106 (골드5)
    // '적어도' 라는 말을 주의

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken()); // 늘리고 싶은 고객 수
        int n = Integer.parseInt(st.nextToken());  // 형택이가 홍보할 수 있는 도시의 개수

        int[] dp = new int[ c + 101]; // i 고객을 얻기 위한 최소 비용
        Arrays.fill(dp, 987654321); // Integer.MAX_VALUE와의 차이 점
        dp[0] = 0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken()); // 홍보 비용
            int people = Integer.parseInt(st.nextToken()); // 고객 수

            for(int j = people; j<c+101; j++){ // 5
                dp[j] = Math.min(dp[j], dp[j - people] + value);
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=c; i<c+101; i++){
            System.out.println(i+" "+dp[i]);
            min = Math.min(min, dp[i]);
        }
        System.out.println(min); // 형택이가 투자해야 하는 돈의 최솟값




//        for(int i=1; i<c+101; i++){
//            for(int j=0; j<n; j++){
//                int value = arr[j][0];
//                int client = arr[j][1];
//
//                if(i - client >= 0) {
//                    if(dp[i] == 0) {
//                        dp[i] = dp[ i - client] + value;
//                    }
//                    else dp[i] = Math.min(dp[i], dp[i-client] + value);
//                }
//            }
//        }

    }
}
