package fastcampus.bruteForcce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15652_N과M_4 {
    static int N, M;
    static int[] resulted;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void dfs(int index, int start) {
        if (index == M) {
            for (int i = 0; i < M; i++) sb.append(resulted[i] + " ");
            sb.append('\n');
        } else {
            for (int i = start; i <= N; i++) {
                resulted[index] = i;
                dfs(index + 1, i);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        resulted = new int[M];
        visited = new boolean[N + 1];

        dfs(0, 1);
        System.out.println(sb);
    }

}
