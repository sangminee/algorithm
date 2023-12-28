package 코테스터디.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1107_리모컨 {  // https://www.acmicpc.net/problem/1107

    static boolean[] broken;
    static int target, brokenButton;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        target = Integer.parseInt(br.readLine()); // 수빈이가 이동하려는 채널
        brokenButton = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수

        broken = new boolean[10];
        if(brokenButton !=0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i< brokenButton; i++){
                int num = Integer.parseInt(st.nextToken());
                broken[num] = true;
            }
        }

        if(target == 100){
            System.out.println(0);
            System.exit(0);
        }

        int count = Math.abs(target - 100);


        // 범위를 500_000 이 아니라 1_000_000 으로 한 이유
        // - 9빼고 모든 버튼이 고장났다면 999999
        for(int i=0; i<=1000000; i++){
            if(!checkChannel(i)){
                int click = Math.abs(i - target);
                count = Math.min(click+size, count);
            }
        }
        System.out.println(count);
    }

    static int size = 0;
    static boolean checkChannel(int x) {
        String xString = String.valueOf(x);
        size = xString.length();
        boolean check = false;
        for (char c : xString.toCharArray()) {
            if (broken[Character.getNumericValue(c)]) {
                check = true;
                break;
            }
        }
        return check;
    }

}
