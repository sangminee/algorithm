package boj.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_14425_문자열집합 { // https://www.acmicpc.net/problem/14425  (실버3)

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++){
            map.put(br.readLine(), 0);
        }

        int count = 0;
        for(int i=0; i<M; i++){
            String a = br.readLine();
            if(map.get(a) != null){
                count++;
            }
        }
        System.out.println(count);

    }

}
