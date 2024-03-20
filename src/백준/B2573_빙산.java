package 백준;

import java.util.*;
import java.io.*;

public class B2573_빙산 { // https://www.acmicpc.net/problem/2573

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static int[][] graph;
	static boolean[][] isVisited;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new int[n][m];
		Queue<int[]> queue = new LinkedList<>(); // 빙산이 존재하는 곳 저장

		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++){
				int num = Integer.parseInt(st.nextToken());
				graph[i][j] = num;

				if(num != 0) queue.add(new int[]{i, j});
			}
		}

		int year = 1;

		while(true){
			int[][] newGraph = new int[n][m];
			Queue<int[]> newQueue = new LinkedList<>(); // 1년이 지나고도, 빙산이 존재할 경우 newQueue에 값 추가

			while(!queue.isEmpty()){
				int[] now = queue.poll(); // 빙산
				int x = now[0];
				int y = now[1];

				int count = 0; // 동서남북 중 0인 값 찾기
				for(int i=0; i<4; i++){
					int getX = dx[i] + x;
					int getY = dy[i] + y;
					if(getX < 0 || getX > n || getY < 0 || getY > m) continue;
					if(graph[getX][getY] == 0) count++;
				}

				if(graph[x][y] - count > 0) {
					newGraph[x][y] = graph[x][y] - count;
					newQueue.add(new int[] {x, y}); // 빙산이 다 녹지 않으면 추가
				}else{
					newGraph[x][y] = 0;
				}
			}

			for(int i=0; i<n; i++){
				for (int j=0; j<m; j++){
					graph[i][j] = newGraph[i][j];
				}
			}

			int size = newQueue.size(); // 1년이 지난후의 빙산

			// 빙산이 다 녹을 때까지 분리되지 않을 경우
			if(size == 0){
				year = 0;
				break;
			}

			for(int i=0; i<size; i++){
				int[] now = newQueue.poll();
				newQueue.add(now);
				queue.add(now);
			}

			// 2개 이상으로 분리가 되었는지 확인
			int div = bfs(newQueue);
			if(div >= 2){
				break;
			}
			year++;
		}
		System.out.println(year);
	}

	static void print(){
		for(int i=0; i<n; i++){
			for (int j=0; j<m; j++){
				System.out.print(graph[i][j] +" ");
			}
			System.out.println();
		}
	}

	// 너비탐색 -> 덩어리 수 찾기
	static int bfs(Queue<int[]> queue){
		int count = 0; // 덩어리 개수
		isVisited = new boolean[n][m];

		while(!queue.isEmpty()){
			int[] now = queue.poll();

			if(!isVisited[now[0]][now[1]]){ // 방문하지 않았을 때 덩어리의 시작점
				count++;

				Queue<int[]> check = new LinkedList<>();
				check.add(now);
				isVisited[now[0]][now[1]] = true;

				while(!check.isEmpty()){
					int[] next = check.poll();

					for(int i=0; i<4; i++){
						int getX = dx[i] + next[0];
						int getY = dy[i] + next[1];

						if(getX<0 || getX>n || getY<0 || getY>m || isVisited[getX][getY]) continue;

						if(graph[getX][getY] != 0){
							check.add(new int[]{getX, getY});
							isVisited[getX][getY] = true;
						}
					}
				}
			}
		}
		return count;
	}
}
