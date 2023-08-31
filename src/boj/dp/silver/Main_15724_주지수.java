package boj.dp.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15724_주지수 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 영토의 크기
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][m+1];
        int[][] sumArr = new int[n+1][m+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for(int j=1; j<=m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                sum += arr[i][j];
                sumArr[i][j] = sum;
            }
        }

        int k = Integer.parseInt(br.readLine());
        while (k --> 0){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = 0;
            for(int i=x1; i<=x2; i++){
                result += sumArr[i][y2] - sumArr[i][y1-1];
            }
            System.out.println(result);
        }

    }
}
