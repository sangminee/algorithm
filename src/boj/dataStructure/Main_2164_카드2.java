package boj.dataStructure;

import java.util.*;
import java.io.*;

public class Main_2164_카드2 { // https://www.acmicpc.net/problem/2164

    /**
     * Queue 함수
     * 1) 값 추가
     * add(value) -> 성공시 true, 아니면 IllegalStateException 발생
     * offer(value)
     *
     * 2) 값 삭제
     * poll() -> 첫번째 값 반환 후 제거
     * remove() -> 첫번째 값 제거
     *
     * 3) 그외
     * peek() -> 첫번째 값 참조
     *
     * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 제일 위에 있는 카드를 버림
        // 제일 위에 있는 카드를 제일 아래로 옮김
        // 제일 마지막에 남는 카드 출력

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++){
            queue.add(i);
        }

        while(queue.size() > 1){
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.poll());

        // 시간 초과 발생
//        ArrayList<Integer> arr = new ArrayList<>();
//        for(int i=1; i<=N; i++){
//            arr.add(i);
//        }
//
//        while (arr.size() > 1){
//            arr.remove(0);
//            int value = arr.get(0);
//            arr.remove(0);
//            arr.add(value);
//        }
//        System.out.println(arr.get(0));
    }

}
