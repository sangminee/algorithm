package boj.greedy;

import java.io.*;
import java.util.*;

public class Main_11047_동전0 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 동전의 개수
        int k = Integer.parseInt(st.nextToken()); // 만들기를 원하는

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0; i<n; i++){
            queue.add(Integer.parseInt(br.readLine()));
        }
        int count = 0;
        int a = queue.poll();

        while (true){
            if(k == 0) break;

            if(k >= a){
                k = k - a;
                count++;
            }else{
                a = queue.poll();
            }
        }

        System.out.println(count);

    }
}
