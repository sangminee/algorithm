package 백준;

import java.io.*;
import java.util.*;

// 토마토가 모두 익을 때까지의 최소 날짜
// 토마토가 모두 익은 상태 : 0,  모두 익지 못하는 상황 : -1
// 1 : 익은 토마토
// 0 : 익지 X 토마토
// -1 : 토마토가 들어있지 않은 칸
// 1이 여러개 있으면 동시에 시작해야 하는디 흠
// -> graph 에 직전 + 1 값과 0 이아니고 원래 값이 존재하면 그 값과 비교
public class B7576_토마토 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int m; // 가로
	static int n; // 세로
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] graph;
	static boolean[][] isVisited;
	static boolean[][] newVisited;
	static int zeroCount;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		graph = new int[n][m];
		isVisited = new boolean[n][m];

		Queue<int[]> finishTomato = new LinkedList<>();

		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++){
				int num = Integer.parseInt(st.nextToken());
				graph[i][j] = num;

				if(num==0){
					zeroCount++;
				}
				if(num != 0){
					isVisited[i][j] = true;
				}
				if(num == 1){
					finishTomato.add(new int[]{i, j});
				}
			}
		}


		int day = 0;
		Queue<int[]> newTomato;
		while(true){

			newTomato = new LinkedList<>();
			while(!finishTomato.isEmpty()){
				int[] get = finishTomato.poll();
				for(int a=0; a<4; a++) {
					int x = get[0] + dx[a];
					int y = get[1] + dy[a];
					if(x<0 || x>=n || y<0 || y>=m || graph[x][y] != 0) continue;
					if(graph[x][y] == 0){
						zeroCount--;
						newTomato.add(new int[]{x,y});
						graph[x][y] = 1;
					}
				}
			}

			day++;
			if(newTomato.size() == 0){
				break;
			}

			finishTomato = new LinkedList<>();
			while (!newTomato.isEmpty()){
				finishTomato.add(newTomato.poll());
			}
		}

		if(zeroCount == 0){
			System.out.println(day-1);
		}else{
			System.out.println(-1);
		}
	}

}
