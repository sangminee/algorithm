import java.io.*;
import java.util.*;

// n을 사용해 k 만들기
public class Main { // https://www.acmicpc.net/problem/2294
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // i개를 가지고 j를 만들 수 있는 최소 경우의 수
        int answer = Integer.MAX_VALUE;

        int[][] minCoin = new int[n+1][k+1];
        for(int i=0; i<=n; i++){
            for(int j=1; j<=k; j++){
                minCoin[i][j] = 10_002;
            }
        }

        for(int i=1; i<=n; i++){
            int coin = Integer.parseInt(br.readLine());
            for(int j=1; j<=k; j++){
                minCoin[i][j] = minCoin[i-1][j];

                if(j>=coin){
                    minCoin[i][j] = Math.min(minCoin[i][j], minCoin[i][j-coin] + 1);
                }
            }
            // k 의 최솟값
            if(minCoin[i][k] != 0 ) answer = Math.min(answer, minCoin[i][k]);
        }

        if(answer == 10_002)
            answer = -1;
        System.out.println(answer);

    }
}
