package boj.greedy;

import java.io.*;
import java.util.*;

public class Main_1715_카드정렬하기 { // https://www.acmicpc.net/problem/1715 (골드4)

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> queue = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            queue.add(Long.valueOf(br.readLine()));
        }

        long sum = 0;
        while (queue.size() >  1){
            long temp1 = queue.poll();
            long temp2 = queue.poll();
            long result = temp1 + temp2;

            sum += result;
            queue.add(result);
        }

        System.out.println(sum);
    }
}
