package boj.dataStructure;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_11286_절댓값힙 { // https://www.acmicpc.net/problem/11286  (실버1)

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static StringBuilder sb = new StringBuilder();

    static class Number{
        int number, absoluteValue;

        public Number(int number){
            this.number = number;
            this.absoluteValue = Math.abs(number);
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        /*** 우선 순위 큐 : 우선 순위가 가장 높은 데이터를 가장 먼저 삭제
         * # 우선 순위 큐 구현 방법
         * 1. 리스트
         *  - 다 비교
         * 2. heap
         *  - 완전 이진 트리 자료구조의 일종
         *  - 최소 힙 (min heap) : 가장 작은 노드 먼저 제거
         *  - 최대 힙 (max heap) : 가장 큰 노드 우선 제거
        */
        // 절대 값이 가장 작은 값을 출력 -> 내림차순 정렬
        PriorityQueue<Number> priorityQueue = new PriorityQueue<>(new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                // <내림차순>
                // o1 - o2 < 0 인 경우는 음수를 return
                // o1 - o2 = 0 인 경우는 0 을 return
                // o1 - o2 > 0 인 경우는 양수를 return -> 객체의 자리 변경

                if(o1.absoluteValue > o2.absoluteValue) return 1;  // o1의 값이 더 크다면 -> 자리 변경
                else if(o1.absoluteValue == o2.absoluteValue) return o1.number - o2.number; // 음수의 값을 앞으로
                return -1;
            }
        });

        while(N-->0){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){ // 값 출력
                if(priorityQueue.isEmpty())sb.append(0).append("\n");
                else sb.append(priorityQueue.poll().number).append("\n");
            }else{
                priorityQueue.add(new Number(x));
            }
        }

        System.out.println(sb);
    }

}
