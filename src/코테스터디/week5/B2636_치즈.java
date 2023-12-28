package 코테스터디.week5;

import java.io.*;
import java.util.*;

public class B2636_치즈 { // https://www.acmicpc.net/problem/2636

    static int[][] graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        int last = 0;

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        while(true){

            time++;
            ArrayList<int[]> remove = new ArrayList<>();

            boolean[][] visited = new boolean[n][m];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0,0});

            while(!queue.isEmpty()){
                int[] now = queue.poll();

                for(int i=0; i<4; i++){
                    int x = dx[i] + now[0];
                    int y = dy[i] + now[1];

                    if(x < 0 || x>=n || y <0 || y>=m || visited[x][y]) continue;

                    if(graph[x][y] == 0){
                        queue.add(new int[]{x,y});
                    } else if(graph[x][y] == 1){
                        remove.add(new int[]{x,y});
                    }
                    visited[x][y] = true;
                }
            }

            if(remove.size() == 0) {
                time -= 1;
                break;
            }else{
                last = 0;
                for(int i=0; i< remove.size(); i++){
                    int x = remove.get(i)[0];
                    int y = remove.get(i)[1];

                    if(graph[x][y] == 1){
                        last++;
                        graph[x][y] = 0;
                    }
                }
            }

        }
        System.out.println(time +"\n"+last);
    }

}
