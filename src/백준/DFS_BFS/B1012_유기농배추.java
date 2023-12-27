package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 배추들이 모여있는 곳 -> 배추흰지렁이 1마리만 있으면됨
 *
 * 배추들이 모여있는 곳을 찾기
 *
 * */
public class B1012_유기농배추 { // https://www.acmicpc.net/problem/1012

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int m,n,k;
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        while(t-->0){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 배추 밭의 가로 길이
            n = Integer.parseInt(st.nextToken()); // 세로 길이
            k = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치의 개수

            graph = new int[n][m];
            // 배추의 위치
            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[y][x] = 1;
            }

            // 필요한 최소의 배추흰지렁이 마리수 출력
            result = 0;
            visited = new boolean[n][m];
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(graph[i][j] == 1 && !visited[i][j]){
                        dfs(i, j);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }

    static int[][] graph;
    static boolean[][] visited;
    static int result;

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int getX = x + dx[i];
            int getY = y + dy[i];
            if(getX < 0 || getX >=n || getY < 0 || getY >= m) continue;

            if(!visited[getX][getY] && graph[getX][getY] == 1){
                dfs(getX, getY);
            }

        }
    }

}
