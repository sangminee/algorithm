package 코테스터디.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B7682_틱택토 { // https://www.acmicpc.net/problem/7682

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<int[]> arr = new ArrayList<>();
        arr.add(new int[]{0,1,2});
        arr.add(new int[]{3,4,5});
        arr.add(new int[]{6,7,8});
        arr.add(new int[]{0,3,6});
        arr.add(new int[]{1,4,7});
        arr.add(new int[]{2,5,8});
        arr.add(new int[]{0,4,8});
        arr.add(new int[]{2,4,6});

        while(true){
            String input = br.readLine();
            if(input.equals("end")) break;

            char[] list = input.toCharArray();

            int xSize = 0;
            int ySize = 0;

            for(int i=0; i<list.length; i++){
                if(list[i] == 'X') xSize++;
                if(list[i] == 'O') ySize++;
            }

            boolean xBingo = false;
            boolean yBingo = false;

            for(int i=0; i<arr.size(); i++){
                int a = arr.get(i)[0];
                int b = arr.get(i)[1];
                int c = arr.get(i)[2];

                if(list[a] == 'X' && list[b] == 'X' && list[c] == 'X') xBingo = true;
                if(list[a] == 'O' && list[b] == 'O' && list[c] == 'O') yBingo = true;
            }

            if(xSize == ySize+1 && xBingo && !yBingo){
                System.out.println("valid");
                continue;
            }

            if(xSize == ySize && yBingo && !xBingo){
                System.out.println("valid");
                continue;
            }

            if(xSize == 5 && ySize == 4 && !xBingo && !yBingo){
                System.out.println("valid");
                continue;
            }

            System.out.println("invalid");

        }
    }
}
