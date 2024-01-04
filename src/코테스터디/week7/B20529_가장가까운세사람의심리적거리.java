package 코테스터디.week7;

import java.io.*;
import java.util.*;

public class B20529_가장가까운세사람의심리적거리 { // https://www.acmicpc.net/problem/20529

    static int n, sum;
    static String[] students;
    static int[] result;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());


        while(t-->0){

            n = Integer.parseInt(br.readLine());
            students = new String[n+1];

            Map<String, Integer> map = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                students[i] = st.nextToken();
                map.put(students[i], map.getOrDefault(students[i],0) + 1);
            }

            boolean check = false;
            for(String key : map.keySet()){
                if(map.get(key) >= 3){
                    check = true;
                    break;
                }
            }

            if(check){
                sb.append(0+"\n");
                continue;
            }

            // 1) n의 3개의 조합 찾기 -> 심리적 거리의 합 구하기
            result = new int[3];
            visited = new boolean[n+1];

            sum = Integer.MAX_VALUE;
            combination(1, 0);

            sb.append(sum+"\n");
        }

        System.out.println(sb);
    }

    static void combination(int start, int index){
        if(index == 3){
            // 학생 3명의 조합 찾기
            int distance = 0;

            for(int i=0; i<3; i++){
                String student1 = students[result[i]];
                for(int j=i+1; j<3; j++){
                    String student2 = students[result[j]];

                    if(!student1.equals(student2)) {
                        for (int a = 0; a < 4; a++) {
                            if (student1.charAt(a) != student2.charAt(a)) {
                                distance++;
                            }
                        }
                    }
                }
            }

            sum = Math.min(distance, sum);
            return;
        }

        for(int i=start; i<=n; i++){
            if(!visited[i]){
                visited[i] = true;
                result[index] = i;
                combination(i+1, index+1);
                visited[i] = false;
            }
        }
    }
}
