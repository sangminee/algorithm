package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1157_단어공부 { // https://www.acmicpc.net/problem/1157

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String str = br.readLine().toUpperCase(); // 알파벳 대소문자로 이루어진 단어

        int[] arr = new int[26]; // 영문자의 개수는 26개임
        for(int i=0; i<str.length(); i++){
            if('A' <= str.charAt(i) && str.charAt(i) <= 'Z'){
                arr[str.charAt(i) - 'A'] ++;
            }else{
                arr[str.charAt(i) - 'a'] --;
            }
        }

        int maxValue = -1;
        char result = '?';

        for(int i=0; i<26; i++){
            if(maxValue == arr[i]){
                result = '?';
            }
            if(maxValue < arr[i]){
                result = (char)(i + 'A');
                maxValue = arr[i];
            }
        }
        System.out.println(result);
        // 가장 많이 사용된 알파벳 알아내기

    }
}
