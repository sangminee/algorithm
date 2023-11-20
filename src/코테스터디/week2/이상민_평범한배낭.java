package 코테스터디.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 출력 : 한 줄에 배낭에 넣을 수 있는 물건 가치합의 최대값
 *  무게 낮은 순 -> 가치가 높은 순
 * */
public class 이상민_평범한배낭 { // https://www.acmicpc.net/problem/12865

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, k;

    static class Item implements Comparable<Item> {
        int weight;
        int value;
        public Item(int weight, int value){
            this.weight = weight;
            this.value = value;
        }
        @Override
        public int compareTo(Item o){
            if(this.weight - o.weight < 0) return -1;
            else if(this.weight - o.weight == 0) return this.value - o.value;
            else return 1;
        }
    }

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 물품의 수
        k = Integer.parseInt(st.nextToken());// 버틸 수 있는 무게
        List<Item> data = new ArrayList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken()); // 무게
            int v = Integer.parseInt(st.nextToken()); // 가치
            data.add(new Item(w,v));
        }
        int[][] dp = new int[n+1][k+1];
        for(int i=1; i<=n; i++){
            Item item = data.get(i-1);
            for(int j=1; j<=k; j++){ // i번째 물품 까지 있을 때, j 가치를 만드는 방법
                if(j - item.weight >= 0){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-item.weight] + item.value);
                }else dp[i][j] = dp[i-1][j];
            }
        }
//        for(int i=1; i<=n; i++){
//            for(int j=1; j<=k; j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
        System.out.println(dp[n][k]);
    }

}
