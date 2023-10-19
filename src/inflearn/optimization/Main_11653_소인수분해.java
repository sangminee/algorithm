package inflearn.optimization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [약수 구하기 문제]
 * 소인수분해 : 1보다 큰 자연수를 소인수들만의 곱으로 나타낸 것
 * */
public class Main_11653_소인수분해 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

//        int number = 2;
//        while(N != 1){
//            if(N % number == 0){
//                System.out.println(number);
//                N = N/number;
//            }else{
//                number++;
//            }
//        }

        // 최적화 - N의 루트 까지 구하면 됨
        for(int i=2; i<=N; i++){
            while( N % i == 0){
                System.out.println(i);
                N/=i;
            }
        }
    }
}
