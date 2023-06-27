package boj.dataStructure;

import java.io.*;
import java.util.*;

/**
 * 홀수 번째 수를 읽을 때마다, 지금 까지 입력 받은 값의 중앙값 출력
 * - 홀수 번째 값을 읽을 때마다 정렬을 시켜서 중앙값 구하기
 * - 중앙값 : 가장 중앙에 있는 값
 * */
public class Main_2696_중앙값구하기 { // https://www.acmicpc.net/problem/2696 (골드2)

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        while(T-->0){
            int M = Integer.parseInt(br.readLine());  // 수열의 크기
            List<Integer> list = new ArrayList<>();
            List<Integer> arr = new ArrayList<>();  // 10개씩 나눠진 M의 값을 담은 배열

            int count = M/10;  // 반복문을 돌릴 - 줄바꿈을 위해
            for(int i=0; i<count; i++){
                arr.add(10);
            }
            if(M % 10 != 0) {
                count++;
                arr.add(M%10);
            }

            int result1 = 0;
            List<Integer> result2 = new ArrayList<>();

            for(int k=0; k<count; k++){
                st = new StringTokenizer(br.readLine());
                for(int i=1; i<=arr.get(k); i++){
                    list.add(Integer.parseInt(st.nextToken()));

                    if(i%2 !=0){
                        Collections.sort(list);
                        result1++;
                        result2.add(list.get(list.size()/2));
                    }
                }
            }

            sb.append(result1+"\n");  // 출력하는 중앙값의 개수

            int a = 0;
            for(int i=0; i<result2.size(); i++){
                sb.append(result2.get(i)+" ");  // 홀수 번째 수를 읽을 때마다 구한 중앙값
                a++;

                if(a % 10 == 0) sb.append("\n");
            }
            sb.append("\n");

        }
        System.out.println(sb);

    }
}
