package 인프런.완전탐색_for문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [완전탐색]
 * 영수, 민혁 - 숫자 야구
 *
 * - 스트라이크 : 같은 숫자, 같은 위치
 * - 볼 : 같은 숫자
 *
 * 3 스트라이크이면 게임이 끝남
 * 민혁의 물음들과 각각의 물음에 대한 영수의 답이 입력으로 주어질 때,
 * 영수가 생각하고 있을 가능성이 있는 답의 총 개수를 출력
 *
 *
 * 1 2 3 4 5 6 7 8 9
 *
 * 123 1s, 1b
 * 356 1s 0b
 * 327 2s, 0b
 * 489 0s, 1b
 *
 * 32_
 *
 * 1번째 위치에 올 수 있는 값 : 1,2,3
 * 2번째 위치에 올 수 있는 값 : 1,2,3
 * 3번째 위치에 올 수 있는 값 : 1,2,3
 * -> 2 가지의 경우의 수
 * */
public class BOJ_2503_숫자야구 { // https://www.acmicpc.net/problem/2503

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[][] data = new int[n][3];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
            data[i][2] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for(int a=1; a<=9; a++){ // 100의 자리가 올 수 있는 경우의 수
            for(int b=1; b<=9; b++){ // 10의 자리가 올 수 있는 경우의 수
                for(int c=1; c<=9; c++){ // 1의 자리가 올 수 있는 경우의 수

                    if(a != b && a != c && b !=c){
                        int count = 0;
                        for(int i=0; i<n; i++){
                            int num = data[i][0];
                            int strike = data[i][1];
                            int ball = data[i][2];

                            int strike_count = 0;
                            int ball_count = 0;

                            int num_100 = num/100;
                            int num_10 = (num%100)/10;
                            int num_1 = (num%100) % 10;

                            if(num_100 == a) strike_count++;
                            else if(num_100 == b || num_100 == c) ball_count++;
                            if(num_10 == b) strike_count++;
                            else if(num_10 == a || num_10 == c) ball_count++;
                            if(num_1 == c) strike_count++;
                            else if(num_1 == a || num_1 == b) ball_count++;

                            if(strike == strike_count && ball == ball_count) count++;
                        }

                        if(count == n) answer++; // 해당 숫자가 n의 결과를 모두 만족
                    }

                }
            }
        }
        System.out.println(answer);

    }

}
