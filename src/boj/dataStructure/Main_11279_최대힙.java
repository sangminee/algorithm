package boj.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_11279_최대힙 { // https://www.acmicpc.net/problem/11279 (실버2)

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 우선 순위 큐
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        while(N-->0){
            int input = Integer.parseInt(br.readLine()); // 입력 값
            if(input == 0){
                if(priorityQueue.isEmpty()) sb.append("0").append("\n");
                else{
                    sb.append(priorityQueue.poll()).append("\n");
                }
            }else{
                priorityQueue.add(input);
            }
        }
        System.out.println(sb);
    }

}
