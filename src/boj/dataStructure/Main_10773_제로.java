package boj.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10773_제로 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        while(K --> 0){
            int value = Integer.parseInt(br.readLine());
            if(value == 0){
                int popValue = stack.pop();
                if(sum != 0) sum -= popValue;
            }else{
                stack.add(value);
                sum+=value;
            }
        }
        System.out.println(sum);
    }

}
