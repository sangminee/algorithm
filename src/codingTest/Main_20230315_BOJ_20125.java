package codingTest;

import java.io.*;

public class Main_20230315_BOJ_20125 { // 쿠키의 신체 측정 (20215)

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 출력
        // - 심장의 위치
        // - 왼쪽 팔, 오른쪽 팔, 허리, 왼쪽 다리, 오른쪽 다리
        // 3 3
        // 1 1 1 1 1

        int headIndexCol = 0, headIndexRow = 0;
        int waistCol=0, waistRow = 0;

        int a = 0, b=0, c= 0, d=0, e=0;

        for(int i=1; i<=N; i++){
            String input = br.readLine();
            char[] arr = input.toCharArray();

            for(int j=1; j<=N; j++){
                String str = String.valueOf(arr[j-1]);

                if(str.equals("*")){
                    if(headIndexRow == 0){
                        headIndexRow = i;
                        headIndexCol = j;
                    }else{
                        if(i == headIndexRow+1){
                            if(j < headIndexCol){ // 왼쪽팔
                                a++;
                            }
                            if(j > headIndexCol){  // 오른쪽 팔
                                b++;
                            }
                        }

                        // 허리 - 머리 col, 심장 위치 이후
                        if(i > headIndexRow+1 && j == headIndexCol){
                            c++;
                            waistRow = i;
                            waistCol = j;

                            d=0;
                            e=0;
                        }

                        // 왼쪽 다리 - 허리 col 전, 허리 row 이후
                        if(i > waistRow && j < waistCol){
                            d++;
                        }
                        // 오른쪽 다리 - 허리 col 이후, 허리 row 이후
                        if(i > waistRow && j > waistCol){
                            e++;
                        }
                    }
                }

            }
        }

        System.out.println(headIndexRow+1+" "+headIndexCol);
        System.out.println(a+" "+b+" "+c+" "+d+" "+e);

    }
}
