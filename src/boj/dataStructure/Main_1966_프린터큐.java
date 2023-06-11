package boj.dataStructure;

import java.util.*;
import java.io.*;

public class Main_1966_프린터큐 { // https://www.acmicpc.net/problem/1966

    static class Printer { // 프린터 객체 생성
        int num; // 문서 번호
        int value; // 중요도

        public Printer(int num, int value) {
            this.num = num;
            this.value = value;
        }

        public int getNum() {
            return num;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서의 개수
            int M = Integer.parseInt(st.nextToken());  // 결과 값 문서 번호 (해당 문서가 몇번 째로 출력되는지 return)

            st = new StringTokenizer(br.readLine()); // N개 문서의 중요도

            ArrayList<Printer> arr = new ArrayList<>();  // 문서를 담은

            for (int i = 0; i < N; i++) {
                int value = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    Printer printer = new Printer(i, value);
                    arr.add(printer);
                } else {
                    Printer printer = new Printer(i + 1, value);
                    arr.add(printer);
                }
            }

            int count = 0; // 출력 횟수

            while (!arr.isEmpty()) {

                // 맨 앞의 값을 뺀 다음에 loop을 돌면서 해당 값의 중요도보다 큰 값이 존재하면 뒤로 보냄
                // 만약 해당 값의 중요도가 가장 크다면 출력 -> count++;
                // printer의 num값이 M과 같으면 break

                Printer front = arr.get(0); // 가장 첫번째 원소
                arr.remove(0);

                boolean isMax = true; // 빼낸 값이 가장 중요도가 큰 원소인지 확인

                // 큐에 남아있는 원소들과 중요도 비교
                for (int i = 0; i < arr.size(); i++) {
                    if (front.getValue() < arr.get(i).getValue()) { // 맨 앞의 원소보다 중요도 큰 프린터 존재

                        arr.add(front);  // 뽑은 원소 및 나머지 원소들을 뒤로 보냄
                        for (int j = 0; j < i; j++) {
                            arr.add(arr.remove(j));
                        }

                        isMax = false;  // 뽑은 원소가 가장 큰 원소가 아니었으므로 탐색 마침
                        break;
                    }
                }

                if (!isMax) {
                    continue; // 조건문의 맨 처음으로 돌아가게 하는
                }

                count++; // 뽑은 원소가 가장 큰 값이었음
                if (front.getNum() == M) {
                    System.out.println(count);
                    break;
                }

            }


//            int mValue = 0; // 궁금한 문서의 값
//
//            HashMap<Integer, Integer> map = new HashMap<>();  // 동일한 값 찾기
//            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//
//            for(int j=0; j<N; j++){
//                int a = Integer.parseInt(st.nextToken());
//                priorityQueue.add(a);
//
//                if(M == 0 && j==0){ // 만약 N이 0이라면 첫번째 값
//                    mValue = a;
//                }else{
//                    if(j + 1== M){
//                        mValue = a;
//                    }
//                }
//                map.put(a, map.getOrDefault(a,0) +1);
//            }
//
//            // mValue가 몇번째로 출력되는지
//            // - 큐 문을 계속 돈다 -> mValue보다 작은 값은 계속 출력
//            // -> 큐 정렬 ? -> 우선 순위 큐
//            int count = 0;
//            while(!priorityQueue.isEmpty()) {
//                if(priorityQueue.poll() == mValue){
//                    break;
//                }else{
//                    count++;
//                }
//            }
//            System.out.println(count + map.get(mValue));
        }

    }

}
