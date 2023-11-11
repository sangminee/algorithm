package 코테스터디.week1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 모든 지점에 대해 목표 지점(2) 까지의 거리를 구해라
 * 가로, 세로만 이동 가능
 *
 * 0 : 갈 수 없는 땅
 * 1 : 갈수 있는 땅
 * 2 : 목표 지점
 *
 * */
public class 이상민_쉬운최단거리 { // https://www.acmicpc.net/problem/14940

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] result;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];
        result = new int[n][m];

        int startX = -1, startY = -1;

        for(int i=0; i<n; i++){ // 가로
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){ // 세로
                int num = Integer.parseInt(st.nextToken());
                graph[i][j] = num;

                if(num == 2){
                    startX = i;
                    startY = j;
                    result[i][j] = 0;
                    visited[i][j] = true;
                }else if(num == 0){
                    visited[i][j] = true;
                    result[i][j] = 0;
                }
            }
        }

        BFS(startX, startY);

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j]){
                    result[i][j] = -1;
                }
                sb.append(result[i][j] +" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        visited[i][j] = true;

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];

            // 인접 노드 방문
            for(int w=0; w<4; w++){
                int getX = x + dx[w];
                int getY = y + dy[w];

                if(0<=getX && getX<n && 0<=getY && getY<m){
                    if(!visited[getX][getY] && graph[getX][getY] == 1){
                        visited[getX][getY] = true;
                        result[getX][getY] = result[x][y] + 1;
                        queue.add(new int[]{getX, getY});
                    }
                }
            }

        }
    }
}
