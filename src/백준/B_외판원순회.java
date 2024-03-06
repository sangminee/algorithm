package 백준;

import java.io.*;
import java.util.*;

public class B_외판원순회 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] graph; // 순회에 드는 비용
	static boolean[] isVisited;
	static int n;
	static StringTokenizer st;
	static int max = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		n = Integer.parseInt(br.readLine());
		graph = new int[n][n];

		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++){
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0; i<n; i++){
			isVisited = new boolean[n];
			isVisited[i] = true;
			bfs(i, i, 1, 0);
		}

		System.out.println(max);
	}

	static void bfs(int first, int start, int dept, int sum){ // start 로 돌아와야 함
		if(dept == n && graph[start][first] != 0){
			max = Math.min(sum+graph[start][first], max);
			return;
		}

		for(int i=0; i<graph[start].length; i++){
			int num = graph[start][i];

			if(num != 0 && !isVisited[i]){
				isVisited[i] = true;
				bfs(first, i, dept+1, sum + num);
				isVisited[i] = false;
			}
		}
	}
}
