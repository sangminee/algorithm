package 코테스터디;

import java.io.*;
import java.util.*;

public class B14719_빗물 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken()); // 세로
        int w = Integer.parseInt(st.nextToken()); // 가로

        boolean[][] block = new boolean[h][w];

        int count  = 0;

        st = new StringTokenizer(br.readLine());

        int[] start = null;
        for(int y=0; y<w; y++){ // y 자리

            int x = Integer.parseInt(st.nextToken());
            if(start == null) start = new int[]{x,y};

            for(int i=0; i<x; i++){
                block[i][y] = true;
            }

            if(y!= 0 && x < start[0]){
                for(int i=0; i<x; i++){
                    for(int j=start[1]; j<=y; j++){
                        if(!block[i][j]){
                            count++;
                            block[i][j] = true;

//                            System.out.println("[a] "+ i+", " + j);
                        }
                    }
                }
            }else if(x >= start[0]){
                for(int i=0; i<start[0]; i++){ // x
                    for(int j=start[1]; j<y; j++){ // y
                        if(!block[i][j]){
                            count++;
                            block[i][j] = true;

//                            System.out.println("[b] "+i+", " + j);
                        }
                    }
                }
                start = new int[]{x,y};
            }
        }

        System.out.println(count);


    }

}
