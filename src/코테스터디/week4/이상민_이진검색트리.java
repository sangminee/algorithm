package 코테스터디.week4;

import java.io.*;
import java.util.Objects;

/**
 * [트리]
 *
 * 1) 그래프의 특수한 형태
 * - DFS와 BFS
 *
 * 2) Tree 만을 위한 문제 : 1차원 배열로 tree 표현
 * - 이진트리
 * - 세그먼트 트리 (index tree)
 * - LCA (최소 공통 조장)
 *
 * - 인덱스 부모 노드 :: index/2
 *
 * - 루트 노드 : 1
 * - 부모 노드 : index/2
 * - 왼쪽 자식노드 : index X 2
 * - 오른쪽 자식노드 : index X 2 + 1
 *
 * ----------------------------------------
 * 이진 트리
 * - 왼 < 루 < 오
 * - 전위 순회 : 루 -> 왼 -> 오
 * - 후위 순회 : 왼 -> 오 -> 루
 *
 * - 전회 순회한 결과 주어졌을 때 , 이 트리를 후위 순회한 결과 출력
 *
 * */
public class 이상민_이진검색트리 { // https://www.acmicpc.net/problem/5639

    static class Node{
        int value;
        Node left, right;
        public Node(int value){
            this.value = value;
        }

        public void insert(int n){
            if(n < this.value){
                if(this.left == null){
                    this.left = new Node(n);
                }else this.left.insert(n);
            }else {
                if(this.right == null){
                    this.right = new Node(n);
                }else this.right.insert(n);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));

        while(true){
            String value = br.readLine();
            if(value == null || value.equals("")){
                break;
            }
            root.insert(Integer.parseInt(value));
        }

        postOrder(root);
    }

    static void postOrder(Node node){
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }
}
