package 코테스터디.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B17471_게리맨더링_부분집합 { // 정답 코드

    static int n, result;
    static int[] people;
    static ArrayList<ArrayList<Integer>> adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()); // 구역의 개수

        // 인구 정보
        people = new int[n + 1]; // i구역 당 인구 수
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // 인접한 구역의 정보
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int num = Integer.parseInt(st.nextToken());
                adj.get(i).add(num);
            }
        }

        result = Integer.MAX_VALUE;
        isSelected = new boolean[n+1];
        div(1);
        if(result == Integer.MAX_VALUE)
            result = -1;
        System.out.println(result);
    }

    static boolean[] isSelected; // 부분 집합에 포함되었는지 아닌지 판별

    static void div(int cnt){
        if(cnt == n){
            List<Integer> team1 = new ArrayList<>(); // true
            List<Integer> team2 = new ArrayList<>(); // false

            for(int i=1; i<=n; i++){
                if(isSelected[i]) team2.add(i);
                else team1.add(i);
            }

            if(team1.size()==0 || team2.size()==0){
                return;
            }

            if(bfs(team1) && bfs(team2)){
                int team1population1 = 0;
                int team1population2 = 0;

                for(int i=1; i<=n; i++){
                    if(isSelected[i]) team1population1 += people[i];
                    else team1population2 += people[i];
                }

                result = Math.min(result, Math.abs(team1population1 - team1population2));
            }

            return;
        }

        isSelected[cnt] = true;
        div(cnt+1);
        isSelected[cnt] = false;
        div(cnt+1);
    }

    static boolean bfs(List<Integer> team){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(team.get(0));

        boolean[] visited = new boolean[n+1];
        visited[team.get(0)] = true;

        int count = 1;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(Integer i : adj.get(now)){
                if(team.contains(i) && !visited[i]){
                    count++;
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        if(team.size() != count){
            return false;
        }else{
            return true;
        }

    }
}
