package inflearn.optimization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * [약수 빠르게 구하기 문제]
 * 소수 - 1과 자기 자신만 약수로 갖는
 *
 * 16 -> (루트) -> 4
 * 1 16
 * 2 8
 * 4
 * -----------
 * 18  -> (루트) -> 4.xxx
 * 1 8
 * 2 9
 * 3 6
 * ---------------
 * ---> 어떤 수를 가져와도 왼쪽 편은 루트 까지만 계산함
 *
 * */
public class Main_1978_소수찾기 { // https://www.acmicpc.net/problem/1978

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine()); // 주어진 수


        // 완전 탐색
//        st = new StringTokenizer(br.readLine());
//        int answer = 0;
//        while(N-->0){
//            int number = Integer.parseInt(st.nextToken());
//            int count = 0;
//            for(int i=1; i<=number; i++){
//                if(number % i == 0) count++;
//            }
//            if(count==2) answer++;
//        }
//        System.out.println(answer);

        // 최적화
        st = new StringTokenizer(br.readLine());
        int answer = 0;
        while(N-->0){
            int number = Integer.parseInt(st.nextToken());
            int a = (int) Math.sqrt(number);

            int count = 0;
            for(int i=1; i<=a; i++){
                if(number % i == 0) {
                    System.out.println(i+" "+number/i);
                    count++;
                }
            }
            if(count==2) answer++;
        }
        System.out.println(answer);


    }
}
