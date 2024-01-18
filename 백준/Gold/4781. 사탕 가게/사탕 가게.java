import java.io.*;
import java.util.*;

public class Main { // https://www.acmicpc.net/problem/4781

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        while(true){

            String input = br.readLine();
            if(input.equals("0 0.00")){
                break;
            }

            st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken()); // 사탕 종류의 수
            int money = subStr(st.nextToken()); // 상근이가 가지고 있는 돈의 양 (100을 곱해서 int 형으로 만든 다음에 0부터 money까지 탐색)

            // i로 살 수 있는 가장 큰 칼로리를 저장
            long[] dp = new long[money + 1];

            for(int i=1; i<=n; i++){
                st = new StringTokenizer(br.readLine());
                int calorie = Integer.parseInt(st.nextToken()); // 사탕의 칼로리
                int price = subStr(st.nextToken()); // 가격

                for(int j=price; j<=money; j++){
                    dp[j] = Math.max(dp[j], dp[j-price] + calorie);
                }
            }
            sb.append(dp[money]+"\n");
        }

        System.out.println(sb);
    }

    static int subStr(String str){
        double a = Double.parseDouble(str);
        return (int) (a * 100 + 0.5);
    }

}