package boj.dataStructure;

import java.io.*;
import java.util.HashMap;
import java.util.Stack;

public class Main_10799_쇠막대기 { // https://www.acmicpc.net/problem/10799 (실버2)

    // i가 ( 이고 i+1 이 )라면 레이저

    // i가 (이고, i+1 이 ( 라면 i는 쇠막대기
    // i+1이 ( 이고 i+2가 (라면 겹쳐진 막대기 (value ++)
    // i값이 )이고 i+1 이 ) 라면 쇠막대기의 끝

    // 연속으로 나오기 시작하면 쇠막대기가 존재함
    //

    public static void solution(String str){

        Stack<Character> stack = new Stack<>();
        int result = 0;

        for(int i=0; i<str.length(); i++){
            if (str.charAt(i) == '(') {
                stack.push('(');
            }else{  // ) 일 경우
                if(stack.peek() == '('){   // 1. 레이저 일 경우
                    stack.pop();
                    result += stack.size();
                }else{   // 2. 쇠 막대기가 끝나는 경우
                    stack.pop();
                    result += 1;
                }
            }
        }

        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        solution(str);


        int length = str.length();
        int[] laser = new int[length]; // 레이저 위치
        int[] stick = new int[length]; // 쇠막대기 위치

        Stack<Character> stack = new Stack<>();

        int index = 1;
        int laserType = 1;  // 레이저가 연속으로 존재할 때 구분을 위해

        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');

                if (str.charAt(i + 1) != ')') { // 쇠 막대기의 처음 찾기 ( '('가 연속으로 존재할 때
                    stick[i] = index;
                    index++;
                }
            } else { // ) 일 때
                // 레이저 건 찾기
                if (str.charAt(i - 1) == '(' && laser[i - 1] == 0) {
                    laser[i] = laserType;
                    laser[i - 1] = laserType;
                    laserType++;
                }

                if (str.charAt(i - 1) == ')') {
                    index--;
                    stick[i] = index;
                }
            }
        }

        boolean[] checkStick = new boolean[length]; // 같은 인덱스를 가진 다른 쇠막대기를 구분해주기 위한
        int count = 0; // 결과

        for (int i = 0; i < length; i++) {
            if (stick[i] != 0 && !checkStick[i]) {
                int stickNum = stick[i];   // 쇠 막대기 번호 찾기
                int firstIndex = i;
                int lastIndex = 0;

                for (int j = firstIndex + 1; j < length; j++) {
                    if (stickNum == stick[j]) {   // 다음으로 쇠막대기가 나오는 값 찾기
                        lastIndex = j;
                        break;
                    }
                }

                for (int j = firstIndex; j < lastIndex; j++) {
                    if (laser[j] != 0 && laser[j - 1] == laser[j]) {  // 레이저건 배열의 같은 숫자를 기준으로 자르기
                        count++;
                    }
                }
                count++;   // 마지막 토막

                // 잘라진 레이저 건 표시
                checkStick[firstIndex] = true;
                checkStick[lastIndex] = true;
            }
        }
        System.out.println(count);
    }

    /*
     * 알아야 하는 것
     * - 쇠 막대기의 개수
     *
     * 1) 레이저 건의 개수, 위치 구하기
     * -> () 한쌍 --> 스택으로 구하기
     * -> boolean[] laser 레이저가 존재하는 index에 true로 변경
     *
     * 2) 쇠 막대기의 배치 구하기
     * -> ( () ) 2개 이상
     * -> int[] stick 로 1, 2, 3 .. 으로 표시
     * -> stick[1]을 가진 마지막 index - stick[1]을 가진 처음 index
     * -> (가 2개 이상이어야 함
     *
     * 3) 해당 쇠막대기가 몇조각으로 잘리는지 ?
     * stick[1] ---> laser[true]  ---> stick[1]
     *
     * return 배치된 쇠 막대기는 레이저에 의해 몇 개의 조각으로 잘려지는지
     *
     *
     * */

    // )의 값이 2개 연속으로 나오면 막대기의 끝임

    // 쇠막대기 -> 레이저를 중심으로 ()를 하나 이상 감싸고 있음

    // 쇠 막대기 찾기  - 대칭 ? 16, 14, 6, 4, 4 -> 모두 짝수임
    // 레이저는 쇠막대기에 있을 수 x
    // (가 연속으로 나오기 시작하면 쇠막대기에 존재할 수 있음
    // '(' : 쇠막대기의 시작
    // ')' : 쇠막대기의 끝

    // 다음으로 a의 값이 나오는 것을 찾음
    // 만약 다음 값이 없다면 그건 쇠막대기의 끝임

    // 레이저 건의 1 1 에서 앞의 1을 기준으로 쇠막대기를 자름
    // 쇠막대기 시작 값부터 끝 값까지
    // -> 레이저 배열을 반복문을 돌리면서
    //   1이 연속을 나올때 앞의 1을 기준으로 count을 ++ 시킴
    //   제일 마지막 토막을 위해 마지막에 ++ 필요함
    // 레이저가 연속으로 존재 할때..?


}
