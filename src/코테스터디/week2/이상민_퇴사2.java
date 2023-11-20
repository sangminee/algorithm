package 코테스터디.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * 1일 (10) -> 4일 (30) -> 5일 (45)
 * 2일 (20)
 * 3일 (10) -> 4일(30) -> 5(45) ----> 45
 *
 * dp[i] : i 일 때 , 이익의 수
 *
 */
public class 이상민_퇴사2 { // https://www.acmicpc.net/problem/15486

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;

    static class Node {
        int time;
        int price;
        public Node(int time, int price){
            this.time = time;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException{
         n = Integer.parseInt(br.readLine());
         StringTokenizer st;

        Node[] list = new Node[n+1];
         for(int i=0; i<n; i++){
             st = new StringTokenizer(br.readLine());
             int time = Integer.parseInt(st.nextToken()); // 기간
             int price = Integer.parseInt(st.nextToken()); // 금액
             list[i] = new Node(time,price);
         }
        int[] dp = new int[n+1]; // i일 일 때 최대 이익
        for(int i=0; i<n; i++){
            int nextDay = list[i].time + i;
            int price = list[i].price;
            if(nextDay <= n){
                dp[nextDay] = Math.max(dp[nextDay], dp[i] + price);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        System.out.print(dp[n]);

    }
}
