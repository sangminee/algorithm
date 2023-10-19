package inflearn.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [완전 탐색]
 * N개의 사탕을 택희(A)/영훈이(B)/남규(C) 적절히 나눠가지기
 *
 * 1. 남은 사탕은 없어야 함
 * 2. C는 B보다 2개 더 많은 사탕을 가져야 함
 * 3. 사탕을 0개 받는 사람은 없어야 함
 * 4. A는 홀수이면 안됨
 *
 * */
public class Main_14568_2017연세대학교_프로그래밍_경시대회 { // https://www.acmicpc.net/problem/14568
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int candy = Integer.parseInt(br.readLine()); // 사탕의 총 개수
        int count = 0;
        for(int A=0; A<=candy; A++){ // 0개 ~ 6개
            for(int B=0; B<=candy; B++){
                for(int C=0; C<=candy; C++){
                    if(A+B+C == candy){ // 남는 사탕이 없어야 함
                        if(C >= B+2){ // C는 B보다 2개 이상 많은 사탕을 가져야 함
                            if(A!=0 && B!=0 && C!=0){ // 셋 중 사탕을 하나도 못받는 친구는 없어야 함
                                if(A%2 ==0){
                                    count++;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
