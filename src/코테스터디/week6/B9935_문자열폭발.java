package 코테스터디.week6;

import java.io.*;
import java.util.*;

// stack :: Last in first out
public class B9935_문자열폭발 { // https://www.acmicpc.net/problem/9935

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(); // 문자열 주어짐
        String bang = br.readLine();

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++){

            int count = 0;
            stack.push(str.charAt(i));

            // 스택의 크기가 폭발문자열의 크기를 넘어갔을 때 매번 검사
            if(stack.size() >= bang.length()){
                for(int j=0; j<bang.length(); j++){

                    if(stack.get(stack.size() - bang.length() + j) == bang.charAt(j)){
                        count++;
                    }

                    // 이미 stack에 폭발물이 들어있어있어야지 제거 가능
                    if(count == bang.length()){
                        for(int k=0; k<count; k++) stack.pop();
                    }
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        if(stack.isEmpty()){
            sb.append("FRULA");
        }else{
            for(char ch : stack){
                sb.append(ch);
            }
        }
        System.out.println(sb);
    }
}
