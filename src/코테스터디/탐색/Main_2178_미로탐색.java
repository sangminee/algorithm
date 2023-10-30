package 코테스터디.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로탐색 { // https://www.acmicpc.net/problem/2178

    // 오른쪽, 아래, 왼쪽, 위
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1][M+1];
        graph = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            String str = br.readLine();
            for(int j=1; j<=M; j++){
                graph[i][j] = Integer.parseInt(str.substring(j-1,j));
            }
        }

        bfs(1,1);
        System.out.println(graph[N][M]);
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        visited[i][j] = true;

        while(!queue.isEmpty()){
            int[] temp = queue.poll();

            for(int k=0; k<4; k++){
                int x = temp[0] + dx[k];
                int y = temp[1] + dy[k];

                if(x >0 && y >0 && x <= N && y<=M ){
                    if(!visited[x][y] && graph[x][y] != 0){
                        visited[x][y] = true;
                        queue.add(new int[]{x,y});
                        graph[x][y] = graph[temp[0]][temp[1]] + 1;
                    }
                }
            }
        }
    }

}
