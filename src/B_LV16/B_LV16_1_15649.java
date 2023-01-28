package B_LV16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_LV16_1_15649 {

    /**
     * 백트래킹 : 모든 경우를 탐색
     * -> 그래프 순회
     * <p>
     * - DFS (깊이 우선 탐색, Deep First Search) : 스택을 이용해서 그래프 순회
     * <p>
     * - BFS (너비 우선 탐색)
     */

    // https://www.acmicpc.net/problem/15649
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken()); // 인덱스

        dfs(0);
        System.out.println(sb);
    }

    static boolean[] visited = new boolean[9];
    static int n, m;
    static int[] result = new int[10000];
    static StringBuilder sb = new StringBuilder();

    private static void dfs(int index) {  // 인덱스
        if (index >= m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append('\n');
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                result[index] = i;
                visited[i] = true;
                dfs(index + 1);
                visited[i] = false;
            }
        }
    }

}
