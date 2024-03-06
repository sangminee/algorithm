package 백준;

import java.io.*;
import java.util.*;

public class B1260_DFS와BFS {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, v;
	static ArrayList<Integer>[] adj;

	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 정점 개수
		m = Integer.parseInt(st.nextToken()); // 간선 개수
		v = Integer.parseInt(st.nextToken()); // 시작

		adj = new ArrayList[n+1];
		for(int i=0; i<=n; i++){
			adj[i] = new ArrayList<>();
		}

		for(int i=0; i<m; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adj[a].add(b);
			adj[b].add(a);
		}

		// 정점이 여러 개인 경우에 정점 번호가 작은 것부터 먼저 방문
		for(int i=1; i<=n; i++){
			Collections.sort(adj[i]);
		}

		// 깊이 탐색
		isVisited = new boolean[n+1];
		dfs(v);

		System.out.println();

		// 너비 탐색
		isVisited = new boolean[n+1];
		bfs();
	}

	static boolean[] isVisited;

	// 깊이 탐색
	public static void dfs(int start){
		isVisited[start] = true;
		System.out.print(start +" ");

		for(int i=0; i<adj[start].size(); i++){
			int num = adj[start].get(i);
			if(!isVisited[num]){
				dfs(num);
			}
		}
	}

	// 너비 탐색
	public static void bfs(){
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);

		while(!queue.isEmpty()){
			int num = queue.poll();
			if(!isVisited[num]){
				isVisited[num] = true;
				System.out.print(num+" ");
			}

			for(int i=0; i<adj[num].size(); i++){
				int a = adj[num].get(i);
				if(!isVisited[a]){
					queue.add(a);
				}
			}
		}
	}

}
