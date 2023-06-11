package boj.dataStructure;

import java.util.*;
import java.io.*;

public class Main_2346_풍선터뜨리기 { // https://www.acmicpc.net/problem/2346

    /**
     * 덱 (Deque) - Double-Ended Queue
     *
     * Deque<String> deque1 = new ArrayDeque<>();
     *
     * - stack + queue
     *
     * Deque<String> deque = new ArrayDeque<>();
     *
     * deque.addFirst(); // Deque의 앞쪽에 데이터를 삽입, 용량 초과시 Exception
     * deque.offerFirst(); //  Deque의 앞쪽에 데이터를 삽입 후 true, 용량 초과시 false
     *
     * deque.addLast(); // Deque의 뒤쪽에 데이터를 삽입, 용량 초과시 Exception
     * deque.add(); // addLast()와 동일
     * deque.offerLast(); //Deque의 뒤쪽에 데이터를 삽입 후 true, 용량 초과시 false
     * deque.offer(); // offerLast()와 동일
     *
     * deque.push(); // addFirst()와 동일
     * deque.pop(); // removeFirst()와 동일
     *
     * */

    // 양수일 때 -> 왼쪽으로 이동
    // 음수일 때 -> 오른쪽으로 이동

    static class Balloon{
        int num;
        int value; // 풍선 안에 적힌 종이의 값

        public Balloon(int num, int value){
            this.num = num;
            this.value = value;
        }
        public int getNum(){
            return num;
        }
        public int getValue(){
            return value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        Deque<Balloon> deque = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            int value = Integer.parseInt(st.nextToken());
            deque.add(new Balloon(i, value));
        }

        Balloon balloon = deque.pop();
        sb.append(balloon.getNum()+" ");

        while(!deque.isEmpty()){

            int size = balloon.getValue();

            // 양수일 때  -> 맨 앞의 값을 꺼내면서 뒤로 이동시킴
            if(size>0){
                for(int i=1; i <size; i++){
                    deque.addLast(deque.removeFirst());
                }
            }else{ // 음수일 때
                for(int i=size; i < 0; i++){
                    deque.addFirst(deque.removeLast());
                }
            }
            balloon = deque.pop();

            sb.append(balloon.getNum()+" ");
        }
        System.out.println(sb);

    }
}