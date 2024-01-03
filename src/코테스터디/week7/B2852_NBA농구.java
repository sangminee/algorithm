package 코테스터디.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2852_NBA농구 { // https://www.acmicpc.net/problem/2852

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 골이 들어간 횟수
        StringTokenizer st;

        int firstTeamScore = 0;
        int secondTeamScore = 0;

        int firstTeamResult = 0;
        int secondTeamResult = 0;

        int goal = 0;

        int currentLeadingTeam = -1; // -1: 아무도 이기고 있지 않음, 0: 1번 팀이 이기고 있음, 1: 2번 팀이 이기고 있음

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken().replace(":","")); // 문자열 분리해서 천의 자리수로 변환
            int sec = (time/100*60) + time%100;  // 초단위로 변환

            if(team == 1) firstTeamScore++;
            else secondTeamScore++;

            if(firstTeamScore > secondTeamScore){
                if(currentLeadingTeam == 0) firstTeamResult += sec - goal;
                goal = sec;
                currentLeadingTeam = 0;

            } else if(firstTeamScore==secondTeamScore){
                if(currentLeadingTeam == 0) {
                    firstTeamResult += sec-goal;
                } else if(currentLeadingTeam == 1) {
                    secondTeamResult += sec-goal;
                }
                goal = sec;
                currentLeadingTeam = -1; // 무승부 상태로 초기화
            }else { // 2팀이 이기고 있을 때
                if(currentLeadingTeam == 1) secondTeamResult += sec - goal;
                goal = sec;
                currentLeadingTeam = 1;
            }
        }

        if(currentLeadingTeam == 0) firstTeamResult += (48*60)-goal;
        else if(currentLeadingTeam == 1) secondTeamResult += (48*60)-goal;

        System.out.println(String.format("%02d:%02d", firstTeamResult/60, firstTeamResult%60));
        System.out.println(String.format("%02d:%02d", secondTeamResult/60, secondTeamResult%60));
    }

    /**
     * static class Info implements Comparable<Info>{
     *         int team;
     *         int time;
     *         public Info(int team, int time){
     *             this.team = team;
     *             this.time = time;
     *         }
     *         @Override
     *         public int compareTo(Info o){
     *             return this.time - o.time;
     *         }
     *     }
     *
     *     public static void main(String[] args) throws IOException{
     *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     *
     *         int n = Integer.parseInt(br.readLine()); // 골이 들어간 횟수
     *         StringTokenizer st;
     *
     *         PriorityQueue<Info> pq = new PriorityQueue<>();
     *
     *         for(int i=0; i<n; i++){
     *             st = new StringTokenizer(br.readLine());
     *             int team = Integer.parseInt(st.nextToken());
     *             String time = st.nextToken().replace(":","");
     *
     *
     *             pq.add(new Info(team, Integer.parseInt(time)));
     *         }
     *
     *         int winFristTeam = 0;
     *         int winSecondTeam = 0;
     *
     *         // 첫번째로 이기기 시작한 시간 찾기
     *         int start1 = 0;
     *         int start2 = 0;
     *
     *         // 결과 (역전이 되는 시간일 때)
     *         int result1 = 0;
     *         int result2 = 0;
     *
     *         while(!pq.isEmpty()){
     *             Info info = pq.poll();
     *
     *             if(info.team == 1){
     *                 winFristTeam++;
     *
     *                 if(winSecondTeam < winFristTeam){
     *                     if(start1 == 0){
     *                         start1 = info.time;
     *                     }
     *                 }else if(winSecondTeam == winFristTeam){
     *                     // 팀2가 그동안 이기고 있었음
     *                     int time = timeCal(start2, info.time);
     *                     result2 = plusTime(result2, time);
     *                     start2 = 0;
     *                     start1 = 0;
     *                 }
     *
     *             }else{
     *                 winSecondTeam++;
     *
     *                 if(winSecondTeam > winFristTeam) {
     *                     if (start2 == 0) {
     *                         start2 = info.time;
     *                     }
     *                 }else if(winSecondTeam == winFristTeam){
     *                     // 팀1이 그동안 이기고 있었음
     *                     int time = timeCal(start1, info.time);
     *                     result1 = plusTime(result1, time);
     *
     *                     start1 = 0;
     *                     start2 = 0;
     *                 }
     *             }
     *
     *         }
     *
     *         if(start1 != 0) result1 = plusTime(result1, timeCal(start1, 4800));
     *         else if(start2 != 0) result2 = plusTime(result2, timeCal(start2, 4800));
     *         System.out.println(print(result1));
     *         System.out.println(print(result2));
     *     }
     *
     *     static String print(int time){
     *         int hour = time/100;
     *         int min = time%100;
     *
     *         String result = "";
     *         if(hour == 0){
     *             result +="00:";
     *         }else if(hour < 10){
     *             result += "0"+hour+":";
     *         } else {
     *             result += hour+":";
     *         }
     *
     *         if(min/10 == 0){
     *             result += "0"+min;
     *         }else result += min;
     *
     *         return result;
     *     }
     *
     *     static int plusTime(int a, int b){
     *         int aHour = a / 100;
     *         int aMin = a % 100;
     *         int bHour = b/100;
     *         int bMin = b % 100;
     *
     *         int hour = aHour + bHour;
     *         int min = aMin + bMin;
     *
     *         if(min > 60){
     *             hour += min/60;
     *             min = min%60;
     *         }
     *         return (hour * 100) + min;
     *     }
     *
     *     static int timeCal(int start, int end){
     *         int sHour = start / 100;
     *         int sMin = start % 100;
     *         int eHour = end/100;
     *         int eMin = end % 100;
     *
     *         int min = 0;
     *         if(eMin < sMin){
     *             eHour -= 1;
     *             min = 60+eMin - sMin;
     *         }else{
     *             min = eMin - sMin;
     *         }
     *         int hour = eHour - sHour;
     *         return (hour * 100) + min;
     *     }
     * */
}

