package 코테스터디.week7;

import java.io.*;
import java.util.*;

public class B1987_알파벳 { // https://www.acmicpc.net/problem/1987

    static int r,c, count=1;
    static boolean[] alphabet;
    static char[][] arr;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        alphabet = new boolean[50];
        arr = new char[r][c];

        for(int i=0; i<r; i++){
            String input = br.readLine();
            for(int j=0; j<c; j++){
                arr[i][j] = input.charAt(j);
            }
        }

        dfs(0,0, 1);
        System.out.println(count);
    }
    static void dfs(int a, int b, int result){
        if(alphabet[arr[a][b] - 'A']) {
            count = Math.max(result-1, count);
            return;
        }

        alphabet[arr[a][b] - 'A'] = true;
        for(int i=0; i<4; i++){
            int x = dx[i] + a;
            int y = dy[i] + b;
            if(x<0 || x>= r || y<0 || y>=c) continue;

            dfs(x, y, result+1);
        }
        alphabet[arr[a][b] - 'A'] = false;

    }


}
