package 코테스터디.week4;

import java.io.*;
import java.util.*;

public class 이상민_부동산다툼 { // https://www.acmicpc.net/problem/20364

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 땅 개수
        int q = Integer.parseInt(st.nextToken()); // 오리 개수

        boolean[] root = new boolean[n+1];
        for(int i=0; i<q; i++){
            int value = Integer.parseInt(br.readLine());

            int temp = value;
            int ans = 0;
            while(temp != 1){
                if(root[temp] == true){
                    ans = temp;
//                    break; // 가장 처음 마주치는 점유된 땅의 번호를 구해야 함
                }
                temp = temp/2;
            }
            root[value] = true;
            System.out.println(ans);

        }
    }

//    static ArrayList<Integer>[] adj;
//    static boolean[] check;
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int n = Integer.parseInt(st.nextToken()); // 땅 개수
//        int q = Integer.parseInt(st.nextToken()); // 오리 개수
//
//        check = new boolean[n+1];
//        adj = new ArrayList[n+1];
//        for(int i=0; i<=n; i++){
//            adj[i] = new ArrayList<>();
//        }
//
//        // 그래프 넣기
//        for(int i=1; i<=n; i++){
//            if(2*i <= n) adj[i].add(2*i);
//            if(2*i +1 <= n) adj[i].add(2*i + 1);
//        }
//
//        for(int i=0; i<q; i++){
//            value = Integer.parseInt(br.readLine());
//            result = new int[n+1];
//            result[1] = 1;
//            dfs(1, 2);
//        }
//    }
//
//    static int value;
//    static int[] result;
//
//    static void dfs(int start, int index){ // 2부터 시작
//        if(start == value){
//            int ans = 0;
//            for(int i=1; i<index; i++){
//                if(check[result[i]]){
//                    ans = result[i];
//                    break;
//                }
////                System.out.print(result[i] +" ");
//            }
//            System.out.println(ans);
////            System.out.println();
//
//            check[value] = true;
//            return;
//        }
//
//        for(int i=0; i<adj[start].size(); i++){
//            int a = adj[start].get(i);
//            if(a <= value) {
//                result[index] = a;
//                dfs(a, index+1);
//            }else{
//                break;
//            }
//        }
//
//    }

}
