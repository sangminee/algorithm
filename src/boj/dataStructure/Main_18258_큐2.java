package boj.dataStructure;

import java.io.*;
import java.util.StringTokenizer;

public class Main_18258_큐2 {
    /**
     * Queue ( 큐 )
     * - 먼저 저장한 데이터를 먼저 꺼내는
     * - 줄을 서다 : FIFO
     *
     * - add()
     * - remove() -> 맨 앞에서 값을 꺼내는
     * - peek() -> 맨 앞 데이터를 확인하는
     * - isEmpty() -> 큐 비었는지 확인
     *
     * PriorityQueue (우선순위 큐)
     * - 힙 구조를 가짐
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        LinkedQueue queue = new LinkedQueue();
        while(N --> 0){
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push" :
                    queue.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    sb.append(queue.pop()+"\n");
                    break;
                case "size" :
                    sb.append(queue.size()+"\n");
                    break;
                case "empty" :
                    sb.append(queue.empty()+"\n");
                    break;
                case "front" :
                    sb.append(queue.front()+"\n");
                    break;
                case "back" :
                    sb.append(queue.back()+"\n");
                    break;
            }
        }
        System.out.println(sb);
    }

}

/**
 * <선형 큐>
 * LinkedList 로 Queue 구현
 * - 배열로 구현하면 효율성이 떨어짐
 * */
class QueueNode{
    int value;
    QueueNode queueNode; // 다음 노드를 가리킴

    public QueueNode(int value){
        this.value = value;
        queueNode = null;  // 새로운 노드는 다음 노드가 없음
    }

    // getter, setter
    public int getValue(){
        return value;
    }
    public QueueNode getNextNode(){
        return queueNode;
    }
    public void setNextNode(QueueNode queueNode) {
        this.queueNode = queueNode;
    }
}

class LinkedQueue{
    QueueNode front; // 맨 앞
    QueueNode back; // 맨 뒤
    int size;

    public LinkedQueue(){
        this.size = 0;
        this.front = null;
        this.back = null;
    }

    public int empty(){  // 큐가 비어있으면 1, 아니면 0 출력
        if(front == null  && back == null){
            return 1;
        }
        return 0;
    }

    public void push (int value){
        QueueNode queueNode = new QueueNode(value); // 새로운 노드
        size++;
        if(empty() == 1){
            front = queueNode;
            back = queueNode;
        }else{
            back.setNextNode(queueNode); // 기존 마지막 node에 새로운 node 연결
            back = queueNode; // 새로운 node를 back으로 변경
        }
    }

    // 가장 앞에 있은 정수를 빼고 그 수를 출력하는
    // 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
    public int pop(){
        if(empty() == 1){
            return -1;
        }else{
            QueueNode popNode = front;
            if(popNode.getNextNode() != null){
                front = front.getNextNode();
            }else{  // 큐에 이제 값 x
                front = null;
                back = null;
            }
            size--;
            return popNode.getValue();
        }
    }

    public int size() { // 큐에 들어있는 정수의 개수 출력
        return size;
    }

    //  큐의 가장 앞에 있는 정수를 출력, 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
    public int front(){
        if(front != null){
            return front.getValue();
        }
        return -1;
    }

    // 큐의 가장 뒤에 있는 정수를 출력, 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
    public int back(){
        if(back != null){
            return back.getValue();
        }
        return -1;
    }
}