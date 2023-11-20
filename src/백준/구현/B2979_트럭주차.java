package 백준.구현;

import java.io.*;
import java.util.*;

public class B2979_트럭주차 { // https://www.acmicpc.net/problem/2979

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); // 1대 주차
        int b = Integer.parseInt(st.nextToken()); // 2대 주차
        int c = Integer.parseInt(st.nextToken()); // 3대 주차

        int[] time = new int[101];

        int minTime = Integer.MAX_VALUE;
        int maxTime = -1;
        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            minTime = Math.min(minTime, start);
            maxTime = Math.max(maxTime, end);
            for(int j=start; j<end; j++){ // 떠난 시간은 계산 X
                time[j] += 1;
            }
        }

        int result = 0;
        for(int i=minTime; i<=maxTime; i++){
            if(time[i] == 1){
                result += 1 * a;
            }else if(time[i] == 2){
                result += 2 * b;
            }else if(time[i] == 3){
                result += 3 * c;
            }
        }

        // 상근이가 내야하는 주차요금 출력
        System.out.println(result);

    }
}
