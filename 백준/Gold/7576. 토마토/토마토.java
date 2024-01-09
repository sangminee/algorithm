import java.io.*;
import java.util.*;

/**
 * 출력 : 토마토가 익는
 * 익은 토마토 상하좌우 -> 익게됨
 * */
public class Main {

    static int[][] arr;
    static int n, m, zeroSize;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // y
        n = Integer.parseInt(st.nextToken()); // x
        arr = new int[n][m];
        zeroSize = 0;

        // 1 : 익은 토마토, 0 : 익지 x 토마토, -1 : 토마토가 들어있지 않은 칸
        Queue<int[]> finishTomato = new LinkedList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;

                if(num == 1){
                    finishTomato.add(new int[]{i,j});
                }else if(num == 0){
                    zeroSize++;   // 0인 모든 값을 구함
                }
            }
        }

        int day = 0;
        visited = new boolean[n][m];

        while (true){

            Queue<int[]> newFinishTomato = new LinkedList<>();
            while(!finishTomato.isEmpty()){
                int[] now = finishTomato.poll();
                int i = now[0];
                int j = now[1];

                for(int h=0; h<4; h++){
                    int x = i + dx[h];
                    int y = j + dy[h];

                    if(x < 0 || x >= n || y<0 || y>=m || visited[x][y]) continue;

                    if(arr[x][y] == 0){
                        arr[x][y] = 1;
                        zeroSize--;
                        visited[x][y] = true;
                        newFinishTomato.add(new int[]{x,y});
                    }
                }
            }
            if(newFinishTomato.size() == 0){
                break;
            }

            day++;

            while (!newFinishTomato.isEmpty()){
                finishTomato.add(newFinishTomato.poll());
            }

        }

        if(zeroSize != 0) System.out.println(-1); // 저장된 토마토가 모두 익지 못하는 상태
        else System.out.println(day);
    }

}
