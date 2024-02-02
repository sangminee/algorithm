import java.io.*;
import java.util.*;

public class Main { // https://www.acmicpc.net/problem/10971

	static int[][] graph;
	static boolean[] isVisited;
	static int n;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // 도시의 수

		graph = new int[n][n];
		StringTokenizer st;

		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++){
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				isVisited = new boolean[n];
				result = new int[n];

				if(i == j){ // 시작점
					isVisited[i] = true;
					result[0] = i;
					dfs(1 , 0, i, j, isVisited,result);
				}
			}
		}

		if(min == Integer.MAX_VALUE) min = 0;
		System.out.println(min);
	}

	static int[] result;

	static void dfs(int count, int sum, int start, int y, boolean[] isVisited, int[] result){
		if(count == n && graph[y][start] != 0){
			min = Math.min(min, sum + graph[y][start]);

			// for(int i=0; i<n; i++){
			// 	System.out.print(result[i]+" ");
			// }
			// System.out.print( " : " + (sum+ graph[y][start]));
			// System.out.println();
			return;
		}

		for(int i=0; i<n; i++){
			if(!isVisited[i] && graph[y][i] != 0){
				isVisited[i] = true;
				result[count] = i;
				dfs(count+1, sum + graph[y][i], start, i, isVisited,result);
				isVisited[i] = false;
			}
		}
	}
}
