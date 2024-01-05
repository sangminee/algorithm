package 코테스터디.week6;

import java.io.*;
import java.util.*;

/**
 * - 최대 5번 이동해서 만들 수 있는 가장 큰 블록의 값 구하기
 3
 2 2 0
 2 4 0
 4 8 0

 * */
public class B12100_2048 { // https://www.acmicpc.net/problem/12100

    static int n;
    static int[][] arr;
    static int max=-1;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        find(arr, 0);
        System.out.println(max);
    }
    static void print(int[][] board){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.printf("%4d",board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static void find(int[][] board, int dept){
        if(dept == 5){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    max = Math.max(max, board[i][j]);
                }
            }
            return;
        }

        int[][] a = up(board);
        find(a, dept+1);

        int[][] b = down(board);
        find(b, dept+1);

        int[][] c = left(board);
        find(c, dept+1);

        int[][] d = right(board);
        find(d, dept+1);
    }

    static int[][] copy(int[][] origin){
        int[][] board = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = origin[i][j];
            }
        }
        return board;
    }
    // 상
    static int[][] up(int[][] origin){
        int[][] board = copy(origin);
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 0){
                    int now = i;

                    for(int a=i+1; a<n; a++){
                        if(board[a][j] != 0){
                            board[now][j] = board[a][j];
                            board[a][j] = 0;

                            // 다음으로 0이 되는 수 찾기
                            for(int b=now; b<=a; b++){
                                if(board[b][j] == 0){
                                    now = b;
                                    break;
                                }
                            }
                        }
                    }
//                    board[n-1][j] = 0;
                }
                if(board[i][j] != 0 && board[i+1][j] == 0){
                    int now = i+1;
                    for(int a=i+1; a<n; a++){
                        if(board[a][j] != 0){
                            board[now][j] = board[a][j];
                            board[a][j] = 0;

                            // 다음으로 0이 되는 수 찾기
                            for(int b=now; b<=a; b++){
                                if(board[b][j] == 0){
                                    now = b;
                                    break;
                                }
                            }
                        }
                    }
                }

                if(board[i][j] != 0 && board[i][j] == board[i+1][j]){ // 0이 아니고, 다음 값과 똑같은 경우 || 값이 다르면 아무런 이동 필요 x
                    board[i][j] += board[i+1][j];
                    board[i+1][j] = 0; // 합쳐진 수를 0으로 변환
                }
            }
        }

        return board;
    }

    // 하
    static int[][] down(int[][] origin){
        int[][] board = copy(origin);
        for(int i=n-1; i>0; i--){
            for(int j=0; j<n; j++){
                if(board[i][j] == 0){
                    int now = i; // 0일 때
                    for(int a=i-1; a>=0; a--){
                        if(board[a][j] != 0){
                            board[now][j] = board[a][j];
                            board[a][j] = 0;

                            // now 이후에 0이 되는 수 찾기
                            for(int b=now; b>=a; b--){
                                if(board[b][j] == 0){
                                    now = b;
                                    break;
                                }
                            }
                        }
                    }
//                    board[0][j] = 0; // 제일 마지막 값
                }

                if(board[i][j] != 0 && board[i-1][j] == 0){
                    int now = i-1; // 0일 때
                    for(int a=i-1; a>=0; a--){
                        if(board[a][j] != 0){
                            board[now][j] = board[a][j];
                            board[a][j] = 0;

                            // now 이후에 0이 되는 수 찾기
                            for(int b=now; b>=a; b--){
                                if(board[b][j] == 0){
                                    now = b;
                                    break;
                                }
                            }
                        }
                    }
                }
                if(board[i][j] != 0 && board[i][j] == board[i-1][j]){
                    board[i][j] += board[i-1][j];
                    board[i-1][j] = 0;
                }
            }
        }
        return board;
    }

    // 좌
    static int[][] left(int[][] origin){
        int[][] board = copy(origin);
        // 0 4 0 0 4
        for(int i=0; i<n; i++){
            for(int j=0; j<n-1; j++){
                if(board[i][j] == 0){ // 현재 보드가 0이라면 나머지 숫자 모두 왼쪽으로 이동 (그 다음 숫자가 0이라면?)
                    int now = j; // 0 인 값
                    for(int a=j+1; a<n; a++){
                        if(board[i][a] != 0){
                            board[i][now] = board[i][a];
                            board[i][a] = 0;

                            for(int b=now; b<=a; b++){
                                if(board[i][b] == 0){
                                    now = b;
                                    break;
                                }
                            }
                        }
                    }
                }

                if(board[i][j] != 0 && board[i][j+1] == 0){
                    int now = j+1; // 0 인 값
                    for(int a=j+1; a<n; a++){
                        if(board[i][a] != 0){
                            board[i][now] = board[i][a];
                            board[i][a] = 0;

                            for(int b=now; b<=a; b++){
                                if(board[i][b] == 0){
                                    now = b;
                                    break;
                                }
                            }
                        }
                    }
                }

                if(board[i][j] != 0 && board[i][j] == board[i][j+1]){
                    board[i][j] += board[i][j+1];
                    board[i][j+1] = 0;
                }
            }
        }
        return board;
    }

    // 우
    static int[][] right(int[][] origin){
        int[][] board = copy(origin);
        for(int i=0; i<n; i++){
            for(int j=n-1; j>0; j--){

                if(board[i][j] == 0){
                    int now = j;
                    for(int a=j-1; a>=0; a--){
                        if(board[i][a] != 0){
                            board[i][now] = board[i][a];
                            board[i][a] = 0;

                            boolean check = false;
                            for(int b=now; b>=a; b--){
                                if(!check && board[i][b] == 0){
                                    now = b;
                                    check = true;
                                }
                            }
                        }
                    }
//                    board[i][0] = 0; // 맨 끝
                }

                if(board[i][j] != 0 && board[i][j-1] == 0){
                    int now = j-1;
                    for(int a=j-1; a>=0; a--){
                        if(board[i][a] != 0){
                            board[i][now] = board[i][a];
                            board[i][a] = 0;

                            boolean check = false;
                            for(int b=now; b>=a; b--){
                                if(!check && board[i][b] == 0){
                                    now = b;
                                    check = true;
                                }
                            }
                        }
                    }

                }
                if(board[i][j] != 0 && board[i][j] == board[i][j-1]){
                    board[i][j] += board[i][j-1];
                    board[i][j-1] = 0;
                }
            }
        }
        return board;
    }

}
