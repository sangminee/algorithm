package B_LV19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_4_1541 { // 잃어버린 괄호 (1541)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 괄호를 쳐서 식의 값을 최소로 만들기

        String input = br.readLine();
        char[] arr = input.toCharArray();

        String str = "";
        ArrayList<String> list = new ArrayList<>();
        for(char c : arr){
            if(String.valueOf(c).equals("+")){
                list.add(str);
                list.add("+");
                str = "";
            }else if(String.valueOf(c).equals("-")){
                list.add(str);
                list.add("-");
                str = "";
            }else{
                str += String.valueOf(c);
            }
        }
        list.add(str);

        int index = 0;
        int[] val = new int[list.size()];

        for(String c : list){
            if(c.equals("-")){
                index++;
            }else if(c.equals("+")){
                continue;
            }else{  // int 이라면
                val[index] += Integer.parseInt(c);
            }
        }

        int sum = val[0];
        for(int i=1; i< list.size(); i++){
            sum -= val[i];
        }
        System.out.println(sum);

    }
}
