package 코테스터디.week6;

import java.io.*;
import java.util.*;

public class B15662_톱니바퀴2 {

    static class Wheel{
        int num;
        int[] arr;
        int direct;

        public Wheel(int num, int[] arr, int direct){
            this.num = num;
            this.arr = arr;
            this.direct = direct;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 톱니바퀴의 개수

        Wheel[] wheels = new Wheel[t+1];

        for(int i=1; i<=t; i++){
            String wheel = br.readLine();
            int[] arr = new int[9];
            for(int j=1; j<=8; j++){
                arr[j] = wheel.charAt(j-1) - '0';
            }
            wheels[i] = new Wheel(i, arr, 0);
        }

        int k = Integer.parseInt(br.readLine()); // 회전 횟수

        for(int i=1; i<=k; i++){
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()); // 회전시킨 톱니바퀴의 번호
            int b = Integer.parseInt(st.nextToken()); // 정수의 방향 (1 : 시계, -1 : 반시계)

            // 회전시켜야 할 바퀴 찾기
            List<Wheel> list = new ArrayList<>();
            Wheel now = wheels[a];
            list.add(new Wheel(a, now.arr, b));

            // 3일 때
            int temp = b;
            Wheel now1 = now;
            if(1<= a-1){
                for(int j=a-1; j>=1; j--){
                    Wheel left = wheels[j];
                    if(now1.arr[7] != left.arr[3]){
                        Wheel current = new Wheel(j, left.arr, temp == 1 ? -1 : 1);
                        list.add(current);
                        temp = current.direct;
                        now1 = left;
                    }else{
                        break;
                    }
                }
            }


            // 7일 때 확인
            temp = b;
            Wheel now2 = now;
            if(a+1 <= t){
                for(int j=a+1; j<=t; j++){
                    Wheel right = wheels[j];
                    if(now2.arr[3] != right.arr[7]){
                        Wheel current = new Wheel(j, right.arr, temp==1 ? -1 : 1);
                        list.add(current);
                        temp = current.direct;
                        now2 = right;
                    }else{
                        break;
                    }
                }
            }


            // 회전 시킴
            for(Wheel wheel : list){
                int[] newArr = new int[9];
                if(wheel.direct == 1){ // 시계 방향 회전
                    newArr[1] = wheel.arr[8];
                    newArr[2] = wheel.arr[1];
                    newArr[3] = wheel.arr[2];
                    newArr[4] = wheel.arr[3];
                    newArr[5] = wheel.arr[4];
                    newArr[6] = wheel.arr[5];
                    newArr[7] = wheel.arr[6];
                    newArr[8] = wheel.arr[7];
                }else{ // 반시계 방향 회전
                    newArr[1] = wheel.arr[2];
                    newArr[2] = wheel.arr[3];
                    newArr[3] = wheel.arr[4];
                    newArr[4] = wheel.arr[5];
                    newArr[5] = wheel.arr[6];
                    newArr[6] = wheel.arr[7];
                    newArr[7] = wheel.arr[8];
                    newArr[8] = wheel.arr[1];
                }
                wheels[wheel.num] = new Wheel(wheel.num, newArr, 0);
            }
        }

        int count = 0;
        for(int i=1; i<=t; i++){
            int[] arr = wheels[i].arr;
            if(arr[1] == 1){
                count++;
            }
        }
        System.out.println(count);
    }

}
