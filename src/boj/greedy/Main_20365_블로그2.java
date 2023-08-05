package boj.greedy;

import java.io.*;

/**
 * - 매일 아침 풀고 싶은 문제를 미리 정해놓고 글을 올림
 * - 매일 밤 각각의 문제에 대하여, 해결한 경우 파란색 / 못한 경우 빨간색으로 칠함
 *
 * 1. 연속된 임의의 문제들을 선택한다.
 * 2. 선택된 문제들을 전부 원하는 같은 색으로 칠한다
 *
 * 일우를 도와 각 문제를 주어진 색으로 칠할 때 필요한 최소한의 작업 횟수를 구하는 프로그램을 작성
 *
 * - 연속된 색깔의 조합이 몇개 인지 파악
 *
 * - 마지막으로 색칠된 색깔을 찾고,
 *
 * */
public class Main_20365_블로그2 { // https://www.acmicpc.net/problem/20365 (실버3)

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine()); // 칠해야 할 문제의 수

        char[] data = br.readLine().toCharArray(); // i번째 문제를 어떤 색으로 칠해야 하는지를 의미

        // 연속된 색깔의 숫자 찾기
        int red = 0;
        int blue = 0;

        if(data[0] == 'R') red++;
        else blue++;

        for(int i=1; i<N; i++){

            if(data[i-1] != data[i]){
                if(data[i] == 'R') red++;
                else blue++;
            }
        }

        // 더 큰 색깔을 칠한 다음에 -> 더 작은 색깔을 가진 값을 추가로 색칠하면 됨
        System.out.println(Math.min(red, blue)+1);

    }
}
