package 백준.그래프;

import java.io.*;
import java.util.*;

/**
 * <경로 압축>
 *
 * Union - 항상 대표 노드끼리 연결해줘야 함
 *
 * index와 value가 같다면 대표노드임
 * -> 틀리다면
 *
 * ## find
 * - 대상 노드 배열에 index와 v
 * */
public class B1717_집합의표현 { // https://www.acmicpc.net/problem/1717

    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); // 연산의 개수

        // 1. 자신의 대표 노드(부모 노드) 저장된 배열 초기화
        // - 처음에는 자기 자신의 값을 저장
        parent = new int[n+1];
        for(int i=0; i<=n; i++){
            parent[i] = i;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(num == 0){ // a가 포함된 집합과 b가 포함된 집합을 합친다는 의미
                union(a, b);
            }else{ // 두 원소 같은지
                if(checkSame(a, b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    // 각 노드가 속한 집합을 1개로 합치는
    // - 기준 : 작은 노드
    // union 연산 시, 항상 대표 노드 끼리 연결해 줘야 함
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b){
            parent[b] = a; // 2개 연결
        }
    }

    // 자신의 대표 노드 찾아서 대표 노드를 찾아 주는
    private static int find(int x) {
        if(parent[x] == x){
            return x;
        }else{
            return parent[x] = find(parent[x]);
        }
    }

    private static boolean checkSame(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b) return true;
        else return false;
    }
}
