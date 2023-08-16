package boj.dp.silver;

import java.io.*;
import java.util.*;

/**
 * table[i] : i 번째에 연속 합의 최대 값을 저장
 *
 * 10
 * 10 -4 3 1 5 6 -35 12 21 -1
 *
 * 10 0 3 4 9 15 0 12 33 0
 *
 * */
public class Main_1912_연속합 { // https://www.acmicpc.net/problem/1912 (실버2)

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] table = new int[n+1];
        table[0] = 0;

        int max = Integer.MIN_VALUE;

        for(int i=1; i<=n; i++){
            int data = Integer.parseInt(st.nextToken());

            table[i] = data;

            if(table[i] < table[i] + table[i-1]){
                table[i] = table[i] + table[i-1];
            }
            max = Math.max(max, table[i]);
        }

        System.out.println(max);
    }
}
