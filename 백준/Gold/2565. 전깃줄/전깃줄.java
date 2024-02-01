import java.io.*;
import java.util.*;

public class Main { // https://www.acmicpc.net/problem/2565

	static class Edge implements Comparable<Edge> {
		int a;
		int b;
		public Edge(int a, int b){
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Edge e){
			return this.a - e.a;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 전깃술의 개수
		StringTokenizer st;

		PriorityQueue<Edge> pq = new PriorityQueue<>();

		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			pq.add(new Edge(a, b));
		}


		int[][] dp = new int[n][2]; // 증가하는 수열 저장 (i : , j :: index0 - 직전에 저장한)

		Edge edge = pq.poll();
		dp[0][0] = edge.b;
		dp[0][1] = 1;

		int max = 0;
		for(int i=1; i<n; i++){
			edge = pq.poll();

			dp[i][0] = edge.b;
			dp[i][1] = 1;

			for(int j=0; j<i; j++){
				if(dp[j][0] < dp[i][0]){
					dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
				}
			}

			max = Math.max(max, dp[i][1]);
		}

		// for(int i=0; i<8; i++){
		// 	System.out.println(dp[i][0] + " : " + dp[i][1]);
		// }

		System.out.println(n - max);
	}
}
