package boj.dp.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * dp (dynamic programming)
 * - 문제의 크기를 변화하면서 정답을 계산하는데,
 * 작은 문제의 결과를 이용해서 큰 문제의 정답을 빠르게 계산하는 알고리즘
 *
 * 1. 문제가 원하는 정답을 찾기 위해 가장 먼저 완전 탐색 접근 시도해 보기
 * 2. 너무 많음
 * 3. 빠른 탐색 방법으로 dp 사용
 *
 * <풀이 방법>
 *     1) 풀고 싶은 가짜 문제 정의
 *     2) 가짜 문제를 풀면 진짜 문제를 풀 수 있는가
 *     3) 초기 값은 어떻게 되는가 (초기값 : 쪼개지 않아도 풀 수 있는 작은 문제들)
 *     4) 점화식 구해내기
 *     5) 진짜 문제 정답 출력하기
 *     </풀이>
 *
 * - 이미 계산한 것을 메모리에 저장하여 중복 계산을 막는다
 * - 최소/최대 문제 등에서 자주 사용됨
 * - 점화식을 구해야 하며 이 과정이 어렵지만 코드는 간단
 *
 * dp 조건
 * - 큰 문제를 작은 문제로 나눌 수 있어야 함
 * - 중복되는 문제를 테이블에 저장하여 다시 계산 x
 *
 * 1. Top-Down (하향식) : 재귀함수 사용
 * 2. Bottom-Up (상향식) : 반복문 사용
 *
 * */
public class Main_1463_1로만들기 { // https://www.acmicpc.net/problem/1463 (실버3)

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        // 풀이2)
        int[] dp = new int[N+1]; // 해당 값을 만들 수 있는 최소 연산 수를 저장

        // 진짜 문제 : n을 연산을 통해 1로 만들기
        // 가짜 문제 : 1부터 i까지 몇번의 연산을 통해 갈 수 있나

        // 초기 값
        dp[0] = 0;
        dp[1] = 0; // 1를 만들기 위해서는 0번의 연산 개수가 필요함

        for(int i=2; i<=N; i++){
            dp[i] = dp[i-1] + 1;
            if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
            if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
        }
        System.out.println(dp[10]);

        /////////////////////////////////////////////////////////////
        // 풀이1) dp 배열에 몇번의 연산을 하면 해당 값에 도달할 수 있는지 추가
        int count = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        List<Integer> start = new ArrayList<>();
        start.add(N);
        map.put(count, start);

        boolean check = false;
        while (true){

            List<Integer> list = new ArrayList<>();
            for(int i=0; i<map.get(count).size(); i++){
                int num = map.get(count).get(i);
                if(num == 1){
                    check = true;
                    break;
                }

                if(num % 3 == 0){
                    list.add(num/3);
                }
                if(num % 2 == 0){
                    list.add(num/2);
                }
                list.add(num-1);
            }

            if(check) break;

            count++;
            map.put(count, list);
        }
        System.out.println(count);

    }
}
