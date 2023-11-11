package 코테스터디.week1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 상하좌우 인접한 빈 칸으로 모두 퍼져나감
 *
 * 0 : 빈칸
 * 1 : 벽
 * 2 : 바이러스가 있는 위치
 *
 * - 세울 수 있는 벽의 개수 : 3
 * -> 벽을 세우지 않는다면, 바이러스는 모든 빈칸으로 퍼져나갈 수 있음
 *
 * 얻을 수 있는 안전 영역의 최대 크기 출력  --> 0의 최대값 출력
 *
 * - 데이터 받기
 * - 바이러스 위치 따로 받기
 * --> 완전 탐색?
 * - 0 일 때 벽을 세울 수 있음
 *
 * */
public class 이상민_연구소 { // https://www.acmicpc.net/problem/14502
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] room;
    static int[][] copy_room;
    static int n, m;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로

        room = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(0);
        System.out.println(maxSafeZone);
    }

    static int maxSafeZone = -1;

    // 3개의 모든 조합을 다 찾기
    static void combi(int wall){
        if(wall == 3){
            find();
            return;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(room[i][j] == 0){
                    room[i][j] = 1;
                    combi(wall+1);
                    room[i][j] = 0;
                }
            }
        }
    }

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static void find(){
        Queue<int[]> queue = new LinkedList<>();

        // 복제하기
        copy_room = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                copy_room[i][j] = room[i][j];
                if(copy_room[i][j] == 2){
                    queue.add(new int[] {i,j});
                }
            }
        }

        while (!queue.isEmpty()){
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];

            for(int a=0; a<4; a++){
                int getX = x + dx[a];
                int getY = y + dy[a];
                if(0<=getX && getX<n && 0<=getY && getY<m){
                    if(copy_room[getX][getY] == 0){
                        copy_room[getX][getY] = 2;
                        queue.add(new int[]{getX, getY});
                    }
                }
            }
        }

        int countSafeZone = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(copy_room[i][j] == 0){
                    countSafeZone++;
                }
            }
        }

        maxSafeZone = Math.max(maxSafeZone, countSafeZone);
    }

}
