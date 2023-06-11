package boj.dataStructure;

import java.io.*;
import java.util.*;

public class Main_1158_요세푸스 {

    static StringBuilder sb;
    static int N, K;

    // N을 계속 돌면서 k 번째가 끝났을 때
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 사람
        K = Integer.parseInt(st.nextToken()); // 제거되는 사람의 수

        sb = new StringBuilder();
        sb.append("<");

        List<Integer> arr = new ArrayList<>();
        for(int i=1; i<=N; i++){
            arr.add(i);
        }

        while(arr.size() > 1){
            for(int i=1; i<K; i++){
                int value = arr.get(0);
                arr.remove(0);
                arr.add(value);
            }

            int value = arr.get(0);
            arr.remove(0);
            sb.append(value+", ");
        }
        sb.append(arr.remove(0)+">");
        System.out.println(sb);



//        Queue<Integer> queue = new LinkedList<>();
//        for(int i=1; i<=N; i++){
//            queue.add(i);
//        }
//
//        // 3 6 2 7 5
//        while(!queue.isEmpty()){
//            for(int i=1; i<K; i++){
//                int value = queue.remove();
//                queue.add(value);
//            }
//            sb.append(queue.remove());
//            if(!queue.isEmpty()){
//                sb.append(", ");
//            }
//        }
//        sb.append(">");
//        System.out.println(sb);
    }

}
