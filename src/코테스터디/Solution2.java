package 코테스터디;

import java.util.*;
import java.io.*;

/**
 * 문제설명
 * 문제의 내용을 충분히 파악한 후 풀이해 주시기 바랍니다
 * 올림픽에 출전한 N명의 육상 선수가 좌우 방향으로 늘어서 있다.
 * 각 선수의 실력은 정수로 표시된다. 왼쪽부터 순서대로 선수들의 실력을 표시한 배열을 A[1..N]이라고 하자.
 *
 * 올림픽 주최측이 갑자기 원래 개인 종목이던 육상을 팀 종목으로 바꾸었다.
 * 각 선수는 현재 늘어서 있는 위치에서 자기자신을 포함하는 연속된 선수들을 모아서 팀을 만들 수 있다고 한다.
 * 단, 연속된 선수들 중 자기 자신이 아닌 한 명을 제외할 수 있다.
 *
 * 각 선수는 자신을 포함하는 팀의 실력의 합이 가장 큰 것을 원한다.
 * 즉, i번째 선수가 원하는 최선의 팀은 1 ≤ s ≤ i ≤ t ≤ N을 만족하는
 * s와 t로 A[s]+A[s+1]+…+A[t] 의 값 혹은 A[s]+A[s+1]+…+A[t]에서 A[i]가 아닌 것 중
 * 하나를 제외한 값이 가장 큰 경우이다.
 *
 * 어떤 선수에 대해서는 가능한 가장 큰 값이 음수가 될 수도 있음에 주의하라.
 *
 * N 명의 실력을 입력으로 받아 각 선수에 대해서 최선의 팀을 구성하는 방법을 계산하는 프로그램을 작성하라.
 * 각 선수에 대해 독립적으로 계산하는 것임에 주의하라.
 * 즉, 어느 한 선수가 구성한 팀이 다른 선수가 구성하려는 팀에 영향을 주지 않는다.
 *
 * [입력]
 *
 * 첫째 줄에 테스트 케이스의 개수 T가 주어지고, 이후 차례로 T개 테스트 케이스가 주어진다.
 * 각 케이스의 첫째 줄에는 선수의 수 N이 주어진다. (1 ≤ N ≤ 200,000)
 *
 * 다음 줄에는 각 선수의 실력을 나타내는 N개의 정수가 선수들이 좌우로 늘어선 순서대로 주어진다.
 * 선수들의 실력을 나타내는 값은 -10,000 이상 10,000 이하의 정수이다.
 *
 * [출력]
 *
 * 각 테스트 케이스의 답을 순서대로 표준출력으로 출력하며,
 * 각 케이스마다 줄의 시작에 “#x”를 출력하여야 한다. 이때 x는 케이스의 번호이다.
 *
 * 같은 줄에, 테스트 케이스에 대해서 각 선수들에 대해 실력의 최대 합을 계산하여
 * 그 절대값을 우선 취한 후, 모두 더한 값을 1,000,000,007로 나눈 나머지를 출력한다.
 *
 * 어떤 선수에 대한 최대 합이 음수인 경우 그 절대값을 취해야 함을 다시 강조한다.
 *
 * --------------------
 * 3
 * 5
 * -1 2 -3 2 -1
 * 1
 * 0
 * 4
 * 1 1 1 1
 * */
public class Solution2 {

	static int AnswerN;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); // 테스트 케이스
		for(int test_case=1; test_case<=t; test_case++ ){
			int n = Integer.parseInt(br.readLine()); // 선수의 수

			int[] dp = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());

			int[] score = new int[n];

			for(int i=0; i<n; i++){
				score[i] = Integer.parseInt(st.nextToken());
				dp[i] = score[i]; // 본인 점수 추가
			}

			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(i != j){
						dp[i] = Math.max(dp[i], dp[i]+ score[j]);
					}
				}
			}

			AnswerN = 0;
			for(int i=0; i<n; i++){
				AnswerN +=(Math.abs(dp[i]) % 1_000_000_007);
			}

			System.out.println("#"+test_case+" "+AnswerN);
		}

	}
}
