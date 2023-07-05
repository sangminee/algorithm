package boj.tree;

import java.io.*;
import java.util.*;

/**
 * 이진 트리 입력 받아
 * - 전위, 중위, 후위 순회 결과 출력
 *
 * */
public class Main_1991_트리순회 { // https://www.acmicpc.net/problem/1991 (실버1)

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Node>[] adj;
    static int N; // 노드의 개수
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Node{
        String value;
        String left;
        String right;

        public Node(String value, String left, String right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
//        adj = new ArrayList[N+1];
//        for(int i=0; i<=N; i++){
//            adj[i] = new ArrayList<>();
//        }


        map = new HashMap<>();
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken(); // 노드
            String B = st.nextToken(); // 왼쪽 자식
            String C = st.nextToken(); // 오른쪽 자식

//            adj[i].add(new Node(A,B,C));

            String[] str = {B,C};
            map.put(A, str);
        }

        pre("A");
        sb.append("\n");
        in("A");
        sb.append("\n");
        post("A");

//        preDfs("A");  // 항상 A가 루트 노드임
//        sb.append("\n");
//        inDfs("A");
//        sb.append("\n");
//        postDfs("A");

        System.out.println(sb);
    }
    static HashMap<String, String[]> map;
    static void pre(String x){
        sb.append(x);
        if(!map.get(x)[0].equals(".")) pre(map.get(x)[0]); // 왼쪽이 비어있지 않을 때
        if(!map.get(x)[1].equals(".")) pre(map.get(x)[1]);
    }
    static void in(String x){
        if(!map.get(x)[0].equals(".")) in(map.get(x)[0]); // 왼쪽이 비어있지 않을 때
        sb.append(x);
        if(!map.get(x)[1].equals(".")) in(map.get(x)[1]);
    }
    static void post(String x){
        if(!map.get(x)[0].equals(".")) post(map.get(x)[0]); // 왼쪽이 비어있지 않을 때
        if(!map.get(x)[1].equals(".")) post(map.get(x)[1]);
        sb.append(x);
    }

//    static void preDfs(String x){
//        for(int i=1; i<=N; i++){
//            Node root = adj[i].get(0);
//
//            if(root.value.equals(x)){
//                sb.append(root.value);
//                // 왼쪽 값이 존재할 때
//                if(root.left != null){
//                    preDfs(root.left);
//                }
//                // 오른쪽 값이 존재할 때
//                if(root.right != null){
//                    preDfs(root.right);
//                }
//                break;
//            }
//        }
//    }
//
//    static void inDfs(String x){
//        for(int i=1; i<=N; i++){
//            Node root = adj[i].get(0);
//            if(root.value.equals(x)){
//                // 왼쪽 값이 존재할 때
//                if(root.left != null){
//                    inDfs(root.left);
//                    sb.append(root.value);
//                }
//                // 오른쪽 값이 존재할 때
//                if(root.right != null){
//                    inDfs(root.right);
//                }
//                break;
//            }
//        }
//    }
//
//
//    static void postDfs(String x){
//        for(int i=1; i<=N; i++){
//            Node root = adj[i].get(0);
//            if(root.value.equals(x)){
//                // 왼쪽 값이 존재할 때
//                if(root.left != null){
//                    postDfs(root.left);
//                }
//                // 오른쪽 값이 존재할 때
//                if(root.right != null){
//                    postDfs(root.right);
//                    sb.append(root.value);
//                }
//                break;
//            }
//        }
//    }

}
