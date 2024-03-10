import java.util.*; 

class Solution {
    
    static boolean[] isVisited; 
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        isVisited = new boolean[n]; 
        
        for(int i=0; i<n; i++){
            if(!isVisited[i]){
                answer++; 
                dfs(i, computers);
            }
        }
        return answer;
    }
    
    static void dfs(int start, int[][] computers){
        Queue<Integer> queue = new LinkedList<>(); 
        queue.add(start); 
        
        while(!queue.isEmpty()){
            int x = queue.poll();
            
            for(int i=0; i<computers[x].length; i++){
                if(!isVisited[i] && computers[x][i] == 1){
                   queue.add(i);
                   isVisited[i] = true;
                }
            }
        }
        
    }
}