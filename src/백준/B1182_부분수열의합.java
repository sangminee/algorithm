package 백준;

import java.io.*;
import java.util.*;

public class B1182_부분수열의합 {

    static int n,s,answer;
    static int[] arr;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        answer = 0;
        isVisited = new boolean[n];
        div(0, isVisited);

        System.out.println(answer);
    }

    static void div(int index, boolean[] isVisited){
        if(index == n){
            int sum = 0;
            int count = 0;
            for(int i=0; i<n; i++){
                if(isVisited[i]) {
                    sum += arr[i];
                    count++;
                }
            }
            if(count == 0) return;
            if(sum == s) answer++;
            return;
        }

        // 현재 원소를 선택
        isVisited[index] = true;
        div(index+1, isVisited);

        // 현재 원소를 비선택
        isVisited[index] = false;
        div(index+1, isVisited);
    }

}
