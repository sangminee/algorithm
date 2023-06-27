package boj.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_7662_이중우선순위큐 { // https://www.acmicpc.net/problem/7662 (골드4)

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        /**
         * # TreeSet
         * - 오름 차순 정렬
         * - 중복 허용 x
         *
         * # TreeMap  ( key : value )
         * - 오름 차순 정렬
         * - 중복 허용 x (마지막 값이 대체함)
         *
         * */
        while(T-->0){
            int Q = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> map = new TreeMap<>();  // value : 중복된 값이 존재할 때 카운트
            while(Q-->0){
                st = new StringTokenizer(br.readLine());
                String operator = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if(operator.equals("D")){
                    if(map.size() != 0){
                        if(value == 1){  // 최댓값 삭제하는 연산
                            map.put(map.lastKey(), map.get(map.lastKey()) -1);
                            if(map.get(map.lastKey()) == 0){
                                map.remove(map.lastKey());
                            }
                        }else{ // 최솟값 삭제하는 연산
                            map.put(map.firstKey(), map.get(map.firstKey()) - 1);
                            if(map.get(map.firstKey()) == 0){
                                map.remove(map.firstKey());
                            }
                        }
                    }

                }else{
                    map.put(value, map.getOrDefault(value, 0) + 1); // 동일한 정수가 삽입될 수 있다.
                }
            }

            if(map.size() == 0){
                sb.append("EMPTY").append("\n");
            }else{
                // 최댓값, 최솟값 출력
                int max = map.lastKey();
                int min = map.firstKey();
                sb.append(max + " "+ min).append("\n");
            }
        }

        System.out.println(sb);
    }

}
