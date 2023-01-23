package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B_LV10_11_10814 { // 나이순 정렬

//    public static class Person{
//        int age;
//        String name;
//
//        public Person(int age, String name){
//            this.age = age;
//            this.name = name;
//        }
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[][] arr = new String[n][2];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }

        // 메모리 초과 - 열을 n으로 해서 그랬음
        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(arr[i][0]+" "+arr[i][1]).append("\n");
        }
        System.out.println(sb);
    }

}
