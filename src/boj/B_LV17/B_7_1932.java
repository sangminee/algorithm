package boj.B_LV17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_7_1932 { // 정수 삼각형 (1932)

    // https://www.acmicpc.net/problem/1932

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 삼각 형의 크기

        ArrayList<Integer>[] arr = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            arr[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            if(i==0){
                arr[i].add(Integer.parseInt(st.nextToken()));
            }else if(i==1){
                arr[i].add(arr[0].get(0) + Integer.parseInt(st.nextToken()));
                arr[i].add(arr[0].get(0) + Integer.parseInt(st.nextToken()));
            } else{
                // i>=2 일때
                for(int j=0; j<=i; j++){
                    int a = Integer.parseInt(st.nextToken());

                    if(j == 0){
                        arr[i].add(a + arr[i-1].get(0));
                    }
                    else if(j == i){
                        arr[i].add(a + arr[i-1].get(j-1));
                    }
                    else{
                        if(a + arr[i-1].get(j-1) > a + arr[i-1].get(j)){
                            arr[i].add( a + arr[i-1].get(j-1));
                        }else {
                            arr[i].add(a + arr[i - 1].get(j));
                        }
                    }

                    // j = 0 -> a + arr[i-1].get(0)
                    // j >= 1
                    // a + arr[i-1].get(j-1) > a + arr[i-1].get(j) -> arr[i].add( a + arr[i-1].get(j-1))


                }

            }
        }

        int max = -1;
        for(int i=0; i<n; i++){
            max = Math.max(max, arr[n-1].get(i));
        }
        System.out.println(max);

    }

}
