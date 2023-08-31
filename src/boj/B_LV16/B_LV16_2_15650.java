package boj.B_LV16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_LV16_2_15650 {
    static int n, m;
    static int[] result = new int[8];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dfs(0, 1);
        System.out.println(sb);
    }

    private static void dfs(int index, int start) {  // start : 결과 시작 값
        if (index >= m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = start; i <= n; i++) {
                result[index] = i;
                dfs(index + 1, i + 1);
            }
        }
    }
}
