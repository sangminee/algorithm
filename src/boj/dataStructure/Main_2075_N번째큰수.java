package boj.dataStructure;

import java.io.*;
import java.util.*;

public class Main_2075_N번째큰수 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

       StringTokenizer st;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                queue.add(Integer.valueOf(st.nextToken()));
            }
        }

        for(int i=0; i<N-1; i++){
            queue.poll();
        }
        System.out.println(queue.poll());
    }
}
