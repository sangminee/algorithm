package 코테스터디.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 아기상어 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class Fish implements Comparable<Fish> {
        int x;
        int y;
        int time;
        public Fish(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Fish o) {
            if(this.time == o.time){
                if(this.x == o.x){
                    return this.y - o.y;
                }
                return this.x - o.x;
            }
            return this.time - o.time;
        }
    }

    // 상하좌우 이동
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine()); // 공간의 크기
        int[][] graph = new int[n][n];

        Fish shark = null;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());

                if(graph[i][j] == 9){
                    shark = new Fish(i, j, 0);
                    graph[i][j] = 0;
                }
            }
        }

        int sharkSize = 2;
        int eatFish = 0;
        int result = 0;

        Queue<Fish> queue = new LinkedList<>(); // 아기상어가 이동할 수 있는 곳을 담는
        PriorityQueue<Fish> pq = new PriorityQueue<>(); // 남아있는 물고기를 담는
        queue.add(shark);

        while(true){

            boolean[][] visited = new boolean[n][n];
            visited[queue.peek().x][queue.peek().y] = true;

            // 이동할 수 있는 제일 가까운 물고기 찾기
            while(!queue.isEmpty()){
                Fish fish = queue.poll();

                for(int i=0; i<4; i++){
                    int x = fish.x + dx[i];
                    int y = fish.y + dy[i];

                    if(x < 0 || x >= n || y < 0 || y >= n || visited[x][y] || graph[x][y] > sharkSize) continue;

                    if(graph[x][y] != 0 && graph[x][y] < sharkSize){
                        pq.add(new Fish(x, y, fish.time+1));
                    }

                    queue.add(new Fish(x, y, fish.time+1));
                    visited[x][y] = true;
                }
            }

            // 먹이가 없으면 종료
            if(pq.isEmpty()) break;

            Fish fish = pq.poll();
            eatFish++;
            graph[fish.x][fish.y] = 0;
            if(eatFish == sharkSize){
                sharkSize++;
                eatFish = 0;
            }

            // 아기 상어 위치 다시 세팅
            pq.clear();
            queue.add(new Fish(fish.x, fish.y, 0));
            result += fish.time;
        }

        System.out.println(result);

    }
}
