package 코테스터디.week8;

import java.io.*;
import java.util.*;

public class B11559_PuyoPuyo { // https://www.acmicpc.net/problem/11559

	static String[][] graph;
	static boolean[][] isVisited;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};

	static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		graph = new String[12][6];
		isVisited = new boolean[12][6];
		for(int i=0; i<12; i++){
			String input = br.readLine();
			for(int j=0; j<6; j++){
				graph[i][j] = String.valueOf(input.charAt(j));
				if(graph[i][j].equals(".")){
					isVisited[i][j] = true;
				}
			}
		}

		while(true){

			// 1. 같은색 뿌요 찾기
			for(int i=0; i<12; i++){
				for(int j=0; j<6; j++){
					// System.out.print(graph[i][j]);

					if(!graph[i][j].equals(".") && !isVisited[i][j]){
						bfs(i, j, graph[i][j]);
					}
				}
				// System.out.println();
			}

			if(moveCount == 0){
				break;
			}else{
				moveCount = 0;
				answer++;
			}

			// 2. 아래로 내려보내기

			for(int y=0; y<6; y++){
				for(int x=11; x>=0; x--){
					if(graph[x][y].equals(".")){

						for(int x2=x-1; x2>=0; x2--){
							if(!graph[x2][y].equals(".")){
								graph[x][y] = graph[x2][y];
								graph[x2][y] = ".";

								isVisited[x][y] = false;
								isVisited[x2][y] = true;
								break;
							}
						}

					}
				}
			}

		}
		System.out.println(answer);

	}

	static int moveCount = 0;
	static void bfs(int i, int j, String color){
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{i,j});

		ArrayList<int[]> list = new ArrayList<>();
		while(!queue.isEmpty()){
			int[] now = queue.poll();
			for(int h=0; h<4; h++){
				int x = dx[h] + now[0];
				int y = dy[h] + now[1];

				if(x < 0 || x>=12 || y < 0 || y >= 6 || isVisited[x][y] || !graph[x][y].equals(color)) continue;

				queue.add(new int[]{x,y});
				list.add(new int[]{x,y});

				isVisited[x][y] = true;

			}
		}

		if(list.size() >= 4){
			moveCount++;
			for(int k=0; k<list.size(); k++){
				int[] now = list.get(k);
				graph[now[0]][now[1]] = ".";
			}
		}else{
			for(int k=0; k<list.size(); k++){
				int[] now = list.get(k);
				isVisited[now[0]][now[1]] = false;
			}
		}
	}


}
