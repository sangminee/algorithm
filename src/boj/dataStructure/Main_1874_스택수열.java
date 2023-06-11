package boj.dataStructure;

import java.io.*;
import java.util.*;

public class Main_1874_스택수열 { // https://www.acmicpc.net/problem/1874

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        // 스택의 맨 마지막 숫자를 pop 했을 때, 입력 받은 값과 같아야 함
        // 같지 않다면 오름차순을 만족시키지 x -> 'NO'

        int start = 1; // 오름차순 스택에 들어가야 할 값

        while (N --> 0){
            int value = Integer.parseInt(br.readLine()); // 4, 3 -> 6

            if(start <= value){
                for(int i=start; i<=value; i++){
                    stack.push(i);
                    sb.append("+\n");
                    start++; // 5
                }
            }

            int popValue = stack.pop();
            if(popValue == value){
                sb.append("-\n");
            }else{
                break;
            }
        }

        if(N != -1){
            System.out.println("NO");
        }else{
            System.out.println(sb);
        }
    }

}
