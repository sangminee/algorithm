import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 수의 갯수
        int m = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수

        int[] sum = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }

        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()); // 수의 갯수
            int j = Integer.parseInt(st.nextToken());

            System.out.println(sum[j] - sum[i-1]);
        }
    }
}
