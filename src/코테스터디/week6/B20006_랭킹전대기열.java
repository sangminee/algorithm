package 코테스터디.week6;

import java.io.*;
import java.util.*;

public class B20006_랭킹전대기열 {

    static class Game implements Comparable<Game> {
        int num; // 방 생성 순서
        int min;// 입장 가능
        int max;
        PriorityQueue<Player> arr;
        public Game(int num, int max, int min){
            this.num = num;
            this.max = max;
            this.min = min;
            arr = new PriorityQueue<>();
        }
        @Override
        public int compareTo(Game g){
            return this.num - g.num;
        }
    }

    static class Player implements Comparable<Player>{
        int level;
        String id;
        public Player(int level, String id){
            this.level = level;
            this.id = id;
        }

        @Override
        public int compareTo(Player o) {

            int len1 = o.id.length();
            int len2 = this.id.length();

            int m = len1 <= len2 ? len1 : len2;
            for(int a=0;a<m;a++) {
                char c1 = this.id.charAt(a);
                char c2 = o.id.charAt(a);
                if(c1!= c2) {
                    return c1-c2;
                }
            }
            return len2-len1;
        }

//        @Override
//        public int compareTo(Player p){
//            boolean pFrist = true;
//            if(this.id.length() != p.id.length()){
//                int min = Math.min(this.id.length(), p.id.length());
//                for(int i=0; i<min; i++){
//                    if(this.id.charAt(i) < p.id.charAt(i)){
//                        pFrist = false;
//                        break;
//                    }
//                }
//            }else{
//                for(int i=0; i<this.id.length(); i++){
//                    if(this.id.charAt(i) < p.id.charAt(i)){
//                        pFrist = false;
//                        break;
//                    }
//                }
//            }
//
//            return pFrist == true ? 1 : -1;
//        }
    }

    static int p=0, m=0;
    static ArrayList<Game> games;
    static int index = 1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken()); // 플레이어의 수
        m = Integer.parseInt(st.nextToken()); // 방의 정원

        games = new ArrayList<>();

        for(int i=0; i<p; i++){
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String id = st.nextToken();

            if(games.size() == 0){
                makeGame(level, id);
            }else{

                boolean isPlayerInGame = false; // 플레이어가 방에 들어갈 수 있는지 판별
                for(int j=0; j<games.size(); j++){
                    Game now = games.get(j);

                    if(now.arr.size() == m) continue;

                    if(now.min <= level && level <= now.max){
                        if(now.arr.size() < m){
                            now.arr.add(new Player(level, id));
                        }
                        isPlayerInGame = true;
                        break;
                    }
                }

                if(!isPlayerInGame){ // 방이 존재하지 않을 때
                    // 방이 꽉 찼을 때
                    makeGame(level, id);
                }
            }
        }

        PriorityQueue<Game> pq = new PriorityQueue<>();
        for(int i=0; i<games.size(); i++){
            pq.add(games.get(i));
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Game now = pq.poll();

            sb.append(now.arr.size() >= m ? "Started!" : "Waiting!").append("\n");

            PriorityQueue<Player> players = now.arr;
            while(!players.isEmpty()){
                Player player = players.poll();
                sb.append(player.level+" "+player.id+"\n");
            }
        }
        System.out.println(sb);
    }

    static void makeGame(int level, String id){
        Game game = new Game(index, level+10, level-10);
        game.arr.add(new Player(level, id));
        games.add(game);
        index++;
    }

}
