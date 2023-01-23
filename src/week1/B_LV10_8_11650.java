package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B_LV10_8_11650 {

    // https://www.acmicpc.net/problem/11650

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }


        // 람다식 x
//        Arrays.sort(arr, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[0] == o2[0]){
//                    return o1[1] - o2[1];
//                }else{
//                    return o1[0] - o2[0];
//                }
//            }
//        });

        // 람다식 o
        Arrays.sort(arr, ((o1, o2) -> {
            // Comparator 비교 방식 : 양수 ( 앞의 값이 더 큼), 음수 (뒤의 값이 더 큼)
            if(o1[0] == o2[0]){  // x 좌표가 같다면
                return o1[1] - o2[1];  // y 좌표 비교
            }else{
                return o1[0] - o2[0];  // x 좌표끼리 비교
            }
        }));

        for(int i = 0; i < n; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}
