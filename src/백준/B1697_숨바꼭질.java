package 백준;

import java.util.*;
import java.io.*;

public class B1697_숨바꼭질 { // https://www.acmicpc.net/problem/1697

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n, k;
	static int max = 100_001;
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int time = 1;

		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);

		boolean[] isVisited= new boolean[max];
		isVisited[n] = true;
		boolean finish = false;

		while(true){
			Queue<Integer> newQueue = new LinkedList<>();

			while (!queue.isEmpty()){
				int temp = queue.poll();
				if(temp == k){
					finish = true;
					System.out.println(time-1);
					break;
				}
				if(temp + 1 <= max && !isVisited[temp+1]){
					isVisited[temp+1] = true;
					newQueue.add(temp+1);
				}
				if(temp-1 >=0 && !isVisited[temp-1]){
					isVisited[temp-1] = true;
					newQueue.add(temp-1);
				}
				if(temp *2 <= max && !isVisited[temp*2]){
					isVisited[temp*2] = true;
					newQueue.add(temp*2);
				}
			}

			if(finish) break;
			while (!newQueue.isEmpty()){
				queue.add(newQueue.poll());
			}
			time++;
		}
	}

}
