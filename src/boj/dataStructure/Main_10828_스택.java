package boj.dataStructure;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_10828_스택 {

    static List<Integer> stack;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        stack = new ArrayList<>();

        while(N-->0){
            st = new StringTokenizer(br.readLine());

            switch(st.nextToken()){
                case "push" :
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    sb.append(pop() +"\n");
                    break;
                case "size" :
                    sb.append(size() +"\n");
                    break;
                case "empty" :
                    sb.append(empty() +"\n");
                    break;
                case "top" :
                    sb.append(top() +"\n");
                    break;
            }
        }
        System.out.println(sb);
    }
    static void push(int x){
        stack.add(x);
    }
    static int pop(){
        if(empty() == 1) return -1;
        else {
            int value = stack.get(size()-1);
            stack.remove(size()-1);
            return value;
        }
    }
    static int size(){
        return stack.size();
    }
    static int empty(){
        if(stack.size() == 0) return 1;
        return 0;
    }
    static int top(){
        if(empty() == 1) return -1;
        else return stack.get(size()-1);
    }

}


