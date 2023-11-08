package 인프런.완전탐색_for문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [완전 탐색]
 * 연립방정식에서 x와 y의 값을 계산하기
 *
 * 자바
 * 1초 = 1억번의 연산 가능
 *
 * */
public class BOJ_19532_수학은_비대면강의입니다 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        for(int x = -999; x<=999; x++){
            for(int y = -999; y<=999; y++){
                if(a*x + b*y == c){
                    if(d*x + e*y == f){
                        System.out.println(x + " " + y);
                        break;
                    }
                }
            }
        }
    }

}
