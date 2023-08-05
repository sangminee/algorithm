package boj.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * - PT를 한 번 받을 때 운동기구를 최대 두 개까지만 선택할 수 있음
 * - PT를 받을 때마다 이전에 사용하지 않았던 운동기구를 선택
 * - PT를 받을 때 운동기구를 되도록이면 두 개를 사용
 *
 * - PT를 한 번 받을 때의 근손실 정도가 M을 넘지 않도록 하고 싶음
 * - M의 최솟값을 구해보기 (운동기구를 두 개 사용해서 PT를 받을 때의 근손실 정도는 두 운동기구의 근손실 정도의 합)
 *
 * - 운동기구를 2개 사용해서 pt를 받을 때의 근손실 정도 => 두 운동기구의 근손실 정도의 합
 *
 * 5
 * 1 2 3 4 5
 *
 * 1 4 => 5
 * 2 3 => 5
 * 5 => 5
 *
 * if -> N이 홀수
 * if -> N이 짝수
 *
 * 최댓값을 구함 구함
 *
 * */
public class Main_20300_서강근육맨 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine()); // 운동 기구의 개수를 나타내는 정수

        // 각 운동 기구의 근손실 정도를 나타내는 정수
        long[] data = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            data[i] = Long.valueOf(st.nextToken());
        }
        Arrays.sort(data);

        long result = Integer.MIN_VALUE;
        if(N % 2 == 0){ // 짝수일 때
            for(int i=0; i<N/2; i++){
                result = Math.max(result, data[i] + data[N-i-1]);
            }
        }else{ // 홀수일 때
            result = data[N-1];
            for(int i=0; i<N/2; i++){
                result = Math.max(result, data[i] + data[N-i-2]);
            }
        }
        System.out.println(result);
    }
}
