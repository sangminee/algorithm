package boj.greedy;

import java.io.*;

/**
 * - 모든 숫자를 전부 같게 만들려고 함
 * - S에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집기
 * - 1 -> 0, 0 -> 1
 *
 * 연속된 숫자 x가 몇개씩 존재하는지 파악
 * */
public class Main_1439_뒤집기 { // https://www.acmicpc.net/problem/1439 (실버5)

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();

        int zero = 0;
        int one = 0;

        if(input.charAt(0) == '0') zero++;
        else one ++;

        for(int i=1; i<input.length(); i++){
            if(input.charAt(i-1) != input.charAt(i)){
                if(input.charAt(i) == '0') zero++;
                else one ++;
            }
        }

        System.out.println(Math.min(zero, one));
    }
}
