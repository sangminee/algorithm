package 코테스터디.week1;

import java.io.*;
import java.util.*;


/**
 * 0 : 집이 없는 곳
 * 1 : 집이 있는 곳
 *
 * 대각선 - 연결된 것 아님, 오/왼/위/아래 만 연결된 것임
 * 출력 - 단지수 , 각 단지에 속하는 집의 수 찾기
 *
 * (0,0) 부터 탐색 ~ (n, n) 까지
 * int count = 0;
 *
 */
public class 이상민_단지번호붙이기 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr;
    static boolean[][] visited;
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            char[] str = br.readLine().toCharArray();
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(String.valueOf(str[j]));
            }
        }

        int count = 0;
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j] == 1 && !visited[i][j]){
                    a = 0;
                    count++;
                    BFS(i,j);
                    list.add(a);
                }
            }
        }

        sb.append(count).append("\n");

        // 오름차순 정렬
        Collections.sort(list);
        for(int i=0; i< list.size(); i++){
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb);

    }

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int a;

    static void BFS(int x, int y){
        a++;
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int getX = x + dx[i];
            int getY = y + dy[i];
            if(0<=getX && getX<N && 0<=getY && getY<N){
                if(arr[getX][getY] == 1 && !visited[getX][getY]){
                    BFS(getX, getY);
                }
            }
        }

    }
}
