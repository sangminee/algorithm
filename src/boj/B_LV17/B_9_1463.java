package boj.B_LV17;

import java.io.*;

public class B_9_1463 { // 1로 만들기 (1463)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // bottom-up : 반복문
        int[] dp = new int[n+1];  // i의 최소 연산 횟수
        dp[0] = 0;

        dp[1] = 0;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + 1;  // + 1
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            }
            if(i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i/3]+1);
            }
        }
        System.out.println(dp[n]);




//        // dp로 풀지 않았음
//        ArrayList<Integer>[] arr = new ArrayList[10000];
//        for(int i=0; i<10000; i++){
//            arr[i] = new ArrayList<>();
//        }
//
//        arr[0].add(n);
//
//        boolean check = false;
//
//        int result = 0;
//        int index = 0;
//
//        while(!check){
//            for(int i=0; i<arr[index].size(); i++){
//                int a = arr[index].get(i);
//
//                if(a == 1){
//                    result = index;
//                    check = true;
//                    break;
//                }
//
//                if(a % 3 == 0){
//                    arr[index+1].add(a/3);
//                }
//
//                if(a % 2 == 0){
//                    arr[index+1].add(a/2);
//                }
//
//                arr[index+1].add(a-1);
//            }
//            index++;
//        }
//
//        System.out.println(result);

    }
}
