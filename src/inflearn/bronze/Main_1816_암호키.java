package inflearn.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [완전 탐색]
 * 암호 시스템 -> 매우 큰 소수의 곱으로 이루어짐
 * 1_000_000 보다 작은 소인수만 구하기
 *
 * - 만약 S의 모든 소인수가 1_000_000 보다 크면 => YES
 * - 아니면 NO
 *
 * [소인수 구하는 방법]
 * - 소인수 : 1을 제외한 약수
 *
 * */
public class Main_1816_암호키 { // https://www.acmicpc.net/problem/1816

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int number_count = Integer.parseInt(br.readLine()); // 수의 개수

        while(number_count --> 0){
            Long s = Long.valueOf(br.readLine()); // 확인하고자 하는 수
            for(int i=2; i<=1_000_000; i++){
                if(s % i == 0){
                    System.out.println("NO");
                    break;
                }
                if(i == 1_000_000) System.out.println("YES"); // 100만 이후까지 프로그램이 멈추지 않았음
            }
        }
    }
}
