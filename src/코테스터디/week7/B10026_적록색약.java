package 코테스터디.week7;

import java.io.*;
import java.util.*;

// 출력
// - 적록색약인 사람이 봤을 때 구역 (빨-초 , 파)
// - 적록색약 X 사람이 봤을 때 구역 (빨강, 파랑, 초록)
public class B10026_적록색약 {

    static char[][] graph;
    static boolean[][] visited;
    static int n;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new char[n][n];


        for(int i=0;i<n;i++){
            String input = br.readLine();
            for(int j=0;j<n; j++){
                graph[i][j] = input.charAt(j);
            }
        }

        // 적록 색약 X
        int r = 0;
        int g = 0;
        int b = 0;
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    char want = graph[i][j];
                    visited[i][j] = true;
                    dfs1(i,j,want);

                    if(want == 'R') r++;
                    else if(want == 'G') g++;
                    else b++;
                }
            }
        }

        // 적록 색약 O
        int rg = 0;
        int b2 = 0;
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    char want = graph[i][j];
                    if(want == 'B') {
                        dfs1(i,j,want);
                        b2++;
                    }else{
                        dfs2(i,j);
                        rg++;
                    }

                }
            }
        }

        int result1 = r+g+b;
        int result2 = rg+b2;
        System.out.println(result1+" "+result2);
    }

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static void dfs2(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});

        while(!queue.isEmpty()){
            int[] now = queue.poll();

            for(int h=0; h<4; h++){
                int x = dx[h] + now[0];
                int y = dy[h] + now[1];
                if(x < 0 || x>=n || y< 0 || y>=n || visited[x][y]) continue;

                if(graph[x][y] != 'B'){
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
    }

    static void dfs1(int i, int j, char want){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});

        while(!queue.isEmpty()){
            int[] now = queue.poll();

            for(int h=0; h<4; h++){
                int x = dx[h] + now[0];
                int y = dy[h] + now[1];
                if(x < 0 || x>=n || y< 0 || y>=n || visited[x][y]) continue;

                if(graph[x][y] == want){
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
    }
}
