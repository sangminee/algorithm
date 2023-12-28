package 코테스터디.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 빈 공간과 벽
 * - 불이 동, 서, 남, 북 으로 퍼져나감 (벽에는 불이 붙지 않음)
 * - 불이 옮겨진 칸 or 불이 이제 붙으려는 칸으로 이동 X
 *
 * . : 빈공간
 * # : 벽
 * @ : 상근이의 시작 위치
 * * : 불
 *
 * 출력 : 각 테스트 케이스마다 빌딩을 탈출하는데 가장 빠른 시간 출력
 *
 * - 불이 한번에 이동이 되어야 함
 * */
public class B5427_불 { // https://www.acmicpc.net/problem/5427

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static int w,h;
    static char[][] graph;
    static Queue<Point> fire;
    static Queue<Point> sang;

    static class Point{
        int x;
        int y;
        int time;

        public Point(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException,NumberFormatException {
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(testCase-->0){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); // 너비
            h = Integer.parseInt(st.nextToken()); // 높이

            graph = new char[h][w];
            fire = new LinkedList<>();
            sang = new LinkedList<>();

            for(int i=0; i<h; i++){
                char[] str = br.readLine().toCharArray();
                for(int j=0; j<w; j++){
                    graph[i][j] = str[j];
                    if(graph[i][j] == '@') sang.add(new Point(i,j,0));
                    else if(graph[i][j] == '*') fire.add(new Point(i,j,0));
                }
            }

            answer = 0;
            bfs();

            // 테두리에 0이 아닌 값이 존재할 때, 가장 작은 값에 +1 을 하는 것이 정답
            // 0이라면 IMPOSSIBLE
            if(answer ==0) sb.append("IMPOSSIBLE\n");
            else sb.append(answer +"\n");
        }
        System.out.println(sb);
    }

    static int answer;

    public static void bfs() {
        while (!sang.isEmpty()){
            // 불 이동
            int size = fire.size();
            for(int i=0; i<size; i++){
                Point point = fire.poll();
                for(int d=0; d<4; d++) {
                    int getX = point.x + dx[d];
                    int getY = point.y + dy[d];

                    if(getX < 0 || getX >= h || getY < 0 || getY >= w) continue;

                    if(graph[getX][getY] == '.' || graph[getX][getY] == '@'){
                        graph[getX][getY] = '*';
                        fire.add(new Point(getX,getY,0));
                    }
                }
            }

            size = sang.size();
            for(int i=0; i<size; i++){
                Point point = sang.poll();
                for(int d=0; d<4; d++){
                    int getX = point.x + dx[d];
                    int getY = point.y + dy[d];
                    // 경계 값일 때 res 값 갱신
                    if(getX < 0 || getX >= h || getY < 0 || getY >= w) {
                        answer = point.time + 1;
                        return;
                    }
                    if(graph[getX][getY] == '.'){
                        graph[getX][getY] = '@'; // 메모리 초과 :: 이 코드가 없다면 상근이가 이미 이동한 위치도 다시 큐에 삽입됨
                        sang.add(new Point(getX, getY,point.time + 1));
                    }
                }

            }
        }

    }
}
