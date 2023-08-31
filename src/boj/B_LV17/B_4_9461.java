package boj.B_LV17;

import java.io.*;

public class B_4_9461 { // 파도반 수열 (9461)

    static long[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        padovan();

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            sb.append(result[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static void padovan( ) {
        result = new long[101];
        result[1] = 1;
        result[2] = 1;
        result[3] = 1;

        for(int i=4; i<105; i++){
            result[i] = result[i-2]+ result[i-3];
        }
    }
}
