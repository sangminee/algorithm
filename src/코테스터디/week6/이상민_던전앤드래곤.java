package 코테스터디.week6;

import java.io.*;
import java.util.*;
public class 이상민_던전앤드래곤 { // https://www.acmicpc.net/problem/16434


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 방의 개수

        long ack = Long.parseLong(st.nextToken()); // 용사의 초기 공격력
        long cur = 0; // 용사 현재 생명력
        long max = 0; // 용사의 최대 생명력

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int hp = Integer.parseInt(st.nextToken());

            if(t == 1){
                cur += (long) a * ((hp / ack) - ( hp%ack!=0 ? 0 : 1)); // 현재 체력에 몬스터에게 공격받은 용사 채력
                max = Math.max(max, cur);
            }else{
                ack += a;
                cur = Math.max(cur - hp, 0); // 현재 체력에서 -를 해주고 0 이하가 되지 않게 함
            }
        }

        max ++;
        System.out.println(max);
    }

    // HMaxHP
    // 최소 값 : 1,
    // 최대 값 : t=1일 때 용사 공격 받은

//    static class Room{
//        int t;
//        int a;
//        int h;
//        public Room(int t, int a, int h){
//            this.t = t;
//            this.a = a;
//            this.h = h;
//        }
//    }
//
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken()); // 방의 개수
//        int ack = Integer.parseInt(st.nextToken()); // 용사의 초기 공격력
//
//        long end = 1;
//        int maxAck = ack;
//        List<Room> rooms = new ArrayList<>();
//
//        for(int i=0; i<n; i++){
//            st = new StringTokenizer(br.readLine());
//            int t = Integer.parseInt(st.nextToken()); // t
//            int a = Integer.parseInt(st.nextToken()); // 공격력 (a)
//            int h = Integer.parseInt(st.nextToken()); // 생명력 (h)
//            Room room = new Room(t, a, h);
//            rooms.add(room);
//            if(t == 1){
//                if(h % maxAck == 0) end += (long) a *(h/maxAck - 1);
//                else end += (long) a * (h/maxAck);
//            } else {
//                maxAck += a;
//            }
//        }
//
//        long hmax = end; // 용사의 최대 생명력
//
//        int start = 1;
//        while(start <= end){
//
//            long cur = start; // 용사의 초기 생명력
//            boolean didnt = false;
//            int curAck = ack; // 용사의 초기 공격력
//
//            for(Room room : rooms){
//                if(room.t == 1){
//                    if(room.h % curAck == 0){
//                        long monsterToa = (long) room.a * (room.h/curAck -1);
//                        cur -= monsterToa;
//                    }else{
//                        long monsterToa = (long) room.a * (room.h / curAck);
//                        cur -= monsterToa;
//                    }
//                    if(cur < 0){
//                        didnt = true;
//                        break;
//                    }
//                }else{
//                    curAck += room.a;
//                    cur += room.h;
//                    if(cur > start) cur = start;
//                }
//            }
//
//            start += 1;
//            if(!didnt){
//                hmax = Math.min(start, hmax);
//                break;
//            }
//        }
//        System.out.println(hmax);
//    }

}
