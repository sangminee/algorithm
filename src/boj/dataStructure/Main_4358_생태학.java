package boj.dataStructure;

import java.io.*;
import java.util.*;

public class Main_4358_생태학 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashMap<String, Integer> map = new HashMap<>();

        int count = 0;
        while(true){
            String input = br.readLine();
            if(input == null || input.length() == 0){
                break;
            }
            map.put(input, map.getOrDefault(input, 0) + 1);  // defaultValue : 해당 값이 없을 때 반환되어야 할
            count++;
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for(String key : list){
            double result = map.get(key)* 100 / (double) count;
            sb.append(key).append(" ").append(String.format("%.4f",result)).append("\n");
        }
        System.out.println(sb);
    }
}
