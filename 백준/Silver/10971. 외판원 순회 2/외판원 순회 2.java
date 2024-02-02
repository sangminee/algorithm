import java.io.*;
import java.util.*;

public class Main { 

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
				if(i == j){ // 시작점
					isVisited[i] = true;
					dfs(1 , 0, i, j, isVisited);
				}
			}
		}

		if(min == Integer.MAX_VALUE) min = 0;
		System.out.println(min);
	}

	static void dfs(int count, int sum, int start, int y, boolean[] isVisited){
		if(count == n && graph[y][start] != 0){
			min = Math.min(min, sum + graph[y][start]);
			return;
		}

		for(int i=0; i<n; i++){
			if(!isVisited[i] && graph[y][i] != 0){
				isVisited[i] = true;
				dfs(count+1, sum + graph[y][i], start, i, isVisited);
				isVisited[i] = false;
			}
		}
	}
}
