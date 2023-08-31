package boj.B_LV16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_LV16_7_14888 {

    // https://www.acmicpc.net/problem/14888

    // 숫자가 중복될 경우 어떻게 ?
    // 연산자의 조합 어떻게 찾지 ? -> 해결

    static int MIN = Integer.MAX_VALUE;
    static int MAX = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());  // 수의 개수
        StringTokenizer st;

        arr1 = new int[n];  // 숫자
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        arr2 = new int[4]; // 연산자
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<4; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
            operatorSum += arr2[i];
        }

        // 덧셈 :0, 뺄셈 : 1, 곱셈 : 2, 나눗셈: 3

        // 모든 숫자 조합 찾기  -> 찾을 필요 없음
        result1 = new int[100000][n];
        numDFS(0, 0);

        // 모든 연산자 조합 찾기
        result2 = new int[100000][n-1];
        operatorDFS(0, 0);

        // -> 둘이 결합해서 최대, 최소 찾기


        int finalResult;


        // n = 2;
        for(int i=0; i<numDfsSum; i++){
            finalResult = result1[numDfsSum][0];

            for(int j=0; j<n; j++){

                if(result2[j][0] == 0){
                    finalResult += result1[numDfsSum][j];
                }else if(result2[j][0] == 1){
                    finalResult -= result1[numDfsSum][j];
                }else if(result2[j][0]== 2){
                    finalResult *= result1[numDfsSum][j];
                }else{
                    finalResult %= result1[numDfsSum][j];
                }

            }


            int a = Integer.parseInt(result1[i][0] + String.valueOf(result2[i][0])
                    + result1[i][1]);
            System.out.println(a);
        }

        // 결과값 1 : 만들 수 있는 식의 최댓값
        // 결과값 2 : 만들 수 있는 식의 최솟값

    }

    static int[] arr4 = new int[100];  // 연사자 visited
    static int[][] result2; // 모든 연산자 조합

    // 덧셈 :0, 뺄셈 : 1, 곱셈 : 2, 나눗셈: 3
    private static void operatorDFS(int index, int cnt) {
        if(index>= n-1){
//            for(int i=0; i<n-1; i++){
//                if(result2[cnt][i] == 0){
//                    System.out.print("+ ");
//                }else if(result2[cnt][i] == 1){
//                    System.out.print("- ");
//                }else if(result2[cnt][i] == 2){
//                    System.out.print("* ");
//                }else{
//                    System.out.print("% ");
//                }
//            }
//            System.out.println();
            cnt++;
        }else{
            for(int i=0; i<4; i++){
                if(arr4[i] != arr2[i]){
                    result2[cnt][index] = i;
                    arr4[i]++;
                    operatorDFS(index+1, cnt);
                    arr4[i]--;
                }
            }
        }
    }

    static int n;
    static int operatorSum;

    static int[] arr1; // 숫자
    static int[] arr2; // 연산자
    static boolean[] visited = new boolean[101];

    static int[][] result1; // 모든 숫자 조합

    static int numDfsSum;
    private static void numDFS(int index, int cnt) {
        if(index >= n){
//            for(int i=0; i<n; i++){
//                System.out.print(result1[cnt][i]+" ");
//            }
//            System.out.println();
            cnt++;
            numDfsSum = cnt;
        }else{
            for(int i=0; i<n; i++){
                if(!visited[arr1[i]]){
                    result1[cnt][index] = arr1[i];
                    visited[arr1[i]] = true;
                    numDFS(index+1, cnt);
                    visited[arr1[i]] = false;
                }
            }
        }
    }

}
