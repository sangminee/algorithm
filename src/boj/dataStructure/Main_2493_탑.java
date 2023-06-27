package boj.dataStructure;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493_탑 { // https://www.acmicpc.net/problem/2493 (골드5)


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<int[]> stack = new Stack<>();
        for(int i=1; i<=N; i++){
            int height = Integer.parseInt(st.nextToken());
            int[] temp = {i, height};  // 직선상에 놓인 순서, 높이

            if(stack.isEmpty()){
                sb.append("0 ");  // 수신하는 탑 x
                stack.push(temp);
            }else{
                // 반복을 하면서 수신가능한 탑 찾기
                while(true){
                    if(stack.isEmpty()){
                        sb.append("0 ");
                        stack.push(temp);
                        break;
                    }

                    int[] peek = stack.peek();
                    if(height < peek[1]){  // 현재 탑의 높이 < 스택 맨 위에 존재하는 탑의 높이
                        sb.append(peek[0] + " ");
                        stack.push(temp);
                        break;
                    }else{
                        stack.pop();
                    }

                }
            }
        }
        System.out.println(sb);

        // 시간 초과
//        for(int i=arrayList.size()-1; i>=0; i--){
//            int[] a = arrayList.get(i);
//            for(int j=i-1; j>=0; j--){
//                int[] b = arrayList.get(j);
//                if(a[1] < b[1]){
//                    result[a[0]] = b[0];
//                    break;
//                }
//            }
//        }

    }
}
