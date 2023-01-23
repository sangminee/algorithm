package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_LV16_4_15652 {
    static int n, m;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = new int[n];

        dfs(0, 1);
        System.out.println(sb);
    }

    private static void dfs(int index, int at) {
        if(index >= m){
            for(int i=0; i<m; i++){
                sb.append(result[i]+" ");
            }
            sb.append("\n");
        }else{
            for(int i=at; i<=n; i++){
                result[index] = i;
                dfs(index+1, i);
            }
        }
    }
}
