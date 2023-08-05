package boj.greedy;

import java.io.*;
import java.util.*;

/**
 * 탐욕 알고리즘 (Greedy algorithm)
 * - 최적의 해에 가까운 값을 구하기 위해 사용됨
 * - 일종의 전략임
 * - 매 순간 최적이라고 생각되는 경우를 선택
 *
 *
 * 최소라는 것이 있으면 - 그리디를 생각
 *
 * -----------------------------------------------------------------
 *
 * - 집에 있는 에너지 드링크를 하나로 합쳐서 한번에 먹으려고 함
 *
 * 1. 임의의 서로 다른 두 에너지 드링크를 고른다.
 * 2. 한쪽 에너지 드링크를 다른 쪽 에너지 드링크에 모두 붓는다.
 * 단, 페인은 야근 후유증으로 인해 손이 떨려, 붓는 과정에서 원래 양의 절반을 바닥에 흘리게 된다.
 * 3. 다 붓고 남은 빈 에너지 드링크는 버린다.
 * 4. 1~3 과정을 에너지 드링크가 하나만 남을 때까지 반복한다.
 *
 * 5
 * 3 2 10 9 6
 *
 * 10 9 6 3 2
 *
 * 1) 10 + 9/2  = 14.5
 * 2) 14.5 + 6/2 = 17.5
 * 3) 17.5 + 3/2 + 19
 * 4) 18 + 2/2 = 20
 *
 * */
public class Main_20115_에너지드링크 { // https://www.acmicpc.net/problem/20115 (실버3)

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine()); // 에너지 드링크의 수

        // 에너지 드링크의 양
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<N; i++){
            priorityQueue.add(Integer.parseInt(st.nextToken()));
        }

        // 페인이 최대로 만들 수 있는 에너지 드링크의 양 출력
        double result = priorityQueue.poll();
        while(!priorityQueue.isEmpty()){
            double cal = priorityQueue.poll()/2.0;
            result = result + cal;
        }

        System.out.println(result);
    }
}
