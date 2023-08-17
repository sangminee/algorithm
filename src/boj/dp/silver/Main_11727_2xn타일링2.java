package boj.dp.silver;

import java.io.*;

public class Main_11727_2xn타일링2 { // https://www.acmicpc.net/problem/11727 (실버3)

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());

        long[] table = new long[1001];

        table[0] = 0;
        table[1] = 1;
        table[2] = 3;

        if(n >= 3){
            for(int i=3; i<=n; i++){
                table[i] = (table[i-1] + table[i-2] + table[i-2])%10007;
            }
        }

        System.out.println(table[n]);
    }
}
