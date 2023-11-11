package 코테스터디.week1;

import java.io.*;
import java.util.*;

/**
 * 국경선 - 정사각형 형태
 *
 * 1. 두 나라 인구 차이가 L명 이상, R명 이하 -> 하루동안 국경선 염
 * 2. 열어야 하는 국경선 모두 열림 -> 인구 이동 시작
 * 3. 인접한 칸만 이동 가능 -> 연합
 * 4. 연합이루고 있는 칸의 인구수 -> (연합의 인구수)/(연합을 이루고 있는 칸의 개수)
 *
 * -- 인구 이동이 몇일 동안 이루어 졌는지 출력
 * */
public class 이상민_인구이동 { // https://www.acmicpc.net/problem/16234

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, L, R;
    static int[][] area;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        //  각 나라의 인구 수 입력받기
        area = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0; // 인구 이동이 일어난 횟수
        while(true){
            visited = new boolean[N][N]; // 방문 표시
            check = 0;

            for (int i=0; i<N; i++) {
                for(int j=0; j<N; j++){
                    if(!visited[i][j]){
                        bfs(i,j,visited);
                    }
                }
            }
            if(check == 0) break;
            count++;
        }
        System.out.println(count);
    }

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int check;

    // 너비 우선 탐색
    static void bfs(int i, int j, boolean[][] visited) {

        int bfsSum = 0;
        int bfsCount=0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});

        visited[i][j] = true;
        bfsSum += area[i][j];
        bfsCount += 1;
        Queue<int[]> reQueue = new LinkedList<>();
        reQueue.add(new int[]{i,j});

        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];

            for (int w = 0; w < 4; w++) {
                int getX = x + dx[w];
                int getY = y + dy[w];

                if (0 <= getX && getX < N && 0 <= getY && getY < N) {
                    int value = Math.abs(area[x][y] - area[getX][getY]);
                    if(L <= value && value <= R) {
                        if(visited[x][y] && !visited[getX][getY]){
                            bfsSum += area[getX][getY];
                            bfsCount +=1;
                            visited[getX][getY] = true;
                            queue.add(new int[] {getX, getY});
                            reQueue.add(new int[] {getX, getY});
                        }
                    }
                }
            }
        }

        if(bfsCount > 1 && bfsSum > area[i][j]){
            int result = bfsSum/bfsCount;
            while(!reQueue.isEmpty()){
                int[] temp = reQueue.poll();
                int x = temp[0];
                int y = temp[1];
                area[x][y] = result;
            }
            check += 1;
        }
    }

}
