package boj.greedy;

import java.io.*;
import java.util.*;

/**
 * 두 개의 파일을 합칠 때 필요한 비용 = 두 파일 크기의 합
 * -> 한 개의 파일을 완성하는데 필요한 비용의 총 합을 계산
 *
 * x1 = c2 + c3 = 30 + 30 = 60
 * x2 = c1 + x1 = 40 + 60 = 100
 * 최종 = c4 + x2 = 50 + 100 = 150
 *
 * 40 30 30 50
 * - 파일을 하나로 합칠 때 필요한 최소 비용을 계산하는 프로그램 작성
 *
 * a b c d
 *
 * */
public class Main_13975_파일합치기3 { // https://www.acmicpc.net/problem/13975 (골드4)

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            int K = Integer.parseInt(br.readLine()); // 소설을 구성하는 장의 수

            // 1장부터 k장까지 수록한 파일의 크기를 나타내는 양의 정수

            PriorityQueue<Long> queue = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<K; i++){
                queue.add(Long.valueOf(st.nextToken()));
            }

            long result = 0;
            while(true){
                long temp1 = queue.poll();
                long temp2 = queue.poll();

                long sum = temp1 + temp2;
                result += sum;
                queue.add(sum);

                if(queue.size() == 1){
                    break;
                }
            }
            System.out.println(result);
        }
    }

}
