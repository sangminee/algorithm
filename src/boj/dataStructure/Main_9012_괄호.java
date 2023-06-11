package boj.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012_괄호 { // https://www.acmicpc.net/problem/9012 (실버4)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            String str = br.readLine();

            Stack<String> stack = new Stack<>();

            boolean check = true;

            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) == '('){
                    stack.push("(");
                }else{ // ')' 일 때
                    if(stack.isEmpty()){
                        check = false;
                        break;
                    }

                    String value = stack.pop();

                    if(!value.equals("(")){
                        check = false;
                        break;
                    }
                }
            }
            if(!check || !stack.isEmpty()) sb.append("NO\n");
            else sb.append("YES\n");
        }
        System.out.println(sb);
    }
}
