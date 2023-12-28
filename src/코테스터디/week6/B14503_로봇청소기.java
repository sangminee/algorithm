package 코테스터디.week6;

import java.io.*;
import java.util.*;

public class B14503_로봇청소기 { // https://www.acmicpc.net/problem/14503

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while(true){

            if(graph[r][c] == 0){
                graph[r][c] = 2;
                count++;
            }

//            int temp = d;
            boolean isEmpty = true; // 빈칸이 존재하지 않을 경우 확인
            for(int i=0; i<4; i++){

                int x = 0;
                int y = 0;

                if(d == 0){
                    d = 3;
                    x = dx[d] + r;
                    y = dy[d] + c;
                }else{
                    d = d-1;
                    x = dx[d] + r;
                    y = dy[d] + c;
                }

                if(x < 0 || x>=n || y<0 || y>=m) continue;
                if(graph[x][y] == 0){
                    isEmpty = false;

                    r = x;
                    c = y;
                    break;
                }

            }

            if(isEmpty){
                r = r - dx[d];
                c = c - dy[d];

                // 후진
                if(graph[r][c] == 1) {
                    break;
                }
            }

        }

        System.out.println(count);

    }
}

