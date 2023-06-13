package programmers.stackQueue;

import java.util.Stack;

public class Lv1_같은숫자는싫어 {
    public Stack<Integer> solution(int []arr) {

        Stack<Integer> stack = new Stack<>();

        stack.push(arr[0]);

        for(int i=1; i<arr.length; i++){
            int value = arr[i];
            if(stack.peek() != value){
                stack.add(value);
            }
        }
        return stack;
    }
}
