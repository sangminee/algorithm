package boj.dataStructure;

import java.io.*;
import java.util.Stack;

public class Main_1935_후위표기식2 { // https://www.acmicpc.net/problem/1935

    /** 후위 표기법 (postfix)
     *  : 피연산자(1,2,3..)를 먼저 표시하고 연산자(*,+,-,..)를 나중에 표시하는 방법
     * ---> 컴파일러가 사용하는 것 : 스택을 사용
     *
     * <Stack>
     *     - Last In First Out (LIFO)
     *     - 항아리 생각
     *     - Stack<Integer> stack = new Stack<>();
     *     - stack.push(value);
     *     - stack.pop();
     *     - stack.peek();  // 가장 상단의 값 출력 (Last in)
     *     - stack.size();
     *     - stack.empty();
     *     - stack.contains(value);
     * </Stack>
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[] charArray = br.readLine().toCharArray();

        int[] data = new int[N];
        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> result = new Stack<>(); // 대문자 넣기
        for(int i=0; i<charArray.length; i++){
            // 숫자만 저장해 놓고, 피연산자일 때 바로 바로 계산
            char value = charArray[i];
            if(value - 'A' >= 0){
                result.push((double) data[value - 'A']);
            }else{
                // 앞에서부터 계산
                double a = result.pop();
                double b = result.pop();
                switch (value) {
                    case '+' :
                        result.push(b+a);
                        break;
                    case '*' :
                        result.push(b*a);
                        break;
                    case '-' :
                        result.push(b-a);
                        break;
                    case '/' :
                        result.push(b/a);
                        break;
                }
            }
        }
        System.out.printf("%.2f", result.pop());

    }
}
