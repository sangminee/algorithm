package 코테스터디;

import java.io.*;
import java.util.*;

// x가 여러 개 존재 가능
public class Solution {
    static int AnswerN;
    static String[][] arr;
    static int n;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int test=1; test<=t; test++){
            n = Integer.parseInt(br.readLine());
            arr = new String[n][n];
            AnswerN = 0;

            int hX = 0;
            int hY = 0;
            StringTokenizer st;
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    arr[i][j] = st.nextToken();
                    if(arr[i][j].equals("X")){
                        hX = i;
                        hY = j;
                    }
                }
            }

            // 상
            for(int i=hX; i>=0; i--){
                if(arr[i][hY].equals("Y")){
                    break;
                }

                if(i-1 >= 0){
                    if(arr[i-1][hY].equals("H") && arr[i][hY].equals("H")){
                        AnswerN++;
                        arr[i-1][hY] = "L";
                        arr[i][hY] = "L";
                    }
                }
            }

            // 하
            for(int i=hX; i<n; i++){
                if(arr[i][hY].equals("Y")){
                    break;
                }
                if(i+1 < n){
                    if(arr[i+1][hY].equals("H") && arr[i][hY].equals("H")){
                        AnswerN++;
                        arr[i+1][hY] = "L";
                        arr[i][hY] = "L";
                    }
                }
            }

            // 좌
            for(int i=hY; i>=0; i--){
                if(arr[hX][i].equals("Y")){
                    break;
                }
                if(i-1 >= 0){
                    if(arr[hX][i-1].equals("H") && arr[hX][i].equals("H")){
                        AnswerN++;
                        arr[hX][i] = "L";
                        arr[hX][i-1] = "L";
                    }
                }

            }

            // 우
            for(int i=hY; i<n; i++){
                if(arr[hX][i].equals("Y")){
                    break;
                }
                if(i+1 < n){
                    if(arr[hX][i+1].equals("H") && arr[hX][i].equals("H")){
                        AnswerN++;
                        arr[hX][i] = "L";
                        arr[hX][i+1] = "L";
                    }
                }

            }

            System.out.println("#"+test +" "+AnswerN);
        }

    }

}
