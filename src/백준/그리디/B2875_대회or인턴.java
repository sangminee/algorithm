package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2875_대회or인턴 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 여학생 수
        int m = Integer.parseInt(st.nextToken()); // 남학생 수
        int k = Integer.parseInt(st.nextToken()); // 인턴쉽에 참여해야 하는 인원

        int ans = 0;
        while(true){

            n = n-2;
            m = m-1;

            if(n >= 0 && m >= 0 && n + m >= k){
                ans++;
            }else{
                break;
            }
        }
        System.out.println(ans);
    }
}
