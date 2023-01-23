package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_LV10_10_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        for(int i=0; i<n; i++){
            arr[i] = br.readLine();
        }

        // 오름 차순
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);  // 문자열 비교
                }else{
                    return o1.length() - o2.length();
                }
            }
        });

        for(int i=0; i<n; i++){
            if(i == 0){
                System.out.println(arr[i]);
            }
            if(i-1 >=0 && !arr[i-1].equals(arr[i])){
                System.out.println(arr[i]);
            }
        }

    }
}
