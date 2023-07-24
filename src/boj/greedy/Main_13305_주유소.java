package boj.greedy;

import java.io.*;
import java.util.*;

/**
 * 그리디 : 현재 상황에서 지금 당장 좋은 것만 고르는 방법
 *
 * 그리디 : 미래를 생각하지 않고 각 단계에서 가장 최선의 선택을 하는 기법
 * - 각 단계에서 최선의 선택을 한 것이 전체적으로 최선이길 바라는 알고리즘
 *
 *
 * 1km마다 1리터의 기름을 사용함
 * - 각 도시에는 단 하나의 주유소가 존재, 도시마다 주유소의 리터당 가격은 다를 수 있음
 * - 가격의 단위는 원을 사용
 *
 * 원 : 주유소의 리터당 가격
 * 숫자 : 도로의 길이
 *
 * 각 도시에 있는 주유소의 기름 가격과, 각 도시를 연결하는 도로의 길이를 입력으로 받아
 * 제일 왼쪽 도시에서 제일 오른쪽 도시로 이동하는 최소의 비용을 계산하는 프로그램 작성
 *
 * a : 리터
 * b : 비용
 *
 * 1. 도로의 길이를 우선 모두 받는다
 * 2. 도시당 주유소 리터당 가격을 받으면서,
 *  a에 우선 맨 처음 도시 당 주유소 리터를 넣고, 도로을 곱한 다음
 *  다음 도시의 주유소 리터와 비교해 더 작은 값으로 다음 도로의 리터를 계산.
 *
 * */
public class Main_13305_주유소 { // https://www.acmicpc.net/problem/13305 (실버3)

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine()); // 도시의 개수

        // 1. 도로의 길이를 우선 모두 받는다
        int[] load = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; i++){
            load[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 도시 당 주유소 리터당 가격을 받으며, 제일 적은 비용을 찾아 도로의 길이와 곱한다
        st = new StringTokenizer(br.readLine());

        // 데이터 범위 잘 생각해야 함
        long cost = Integer.parseInt(st.nextToken());
        long result = cost * load[0];

        for(int i=1; i<N; i++){
            cost = Math.min(cost, Integer.parseInt(st.nextToken()));
            result += cost * load[i];
        }

        System.out.println(result);
    }

}