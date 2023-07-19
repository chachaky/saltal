package baekjun.question_2606;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] map;
    static int[] visit;
    static int nodeCount;

    static int virusCount = 0;
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        // 노드갯수
        nodeCount = sc.nextInt();
        map = new int[nodeCount+1][nodeCount+1];
        visit = new int[nodeCount+1];

        // 연결된 선 수
        int connectionCount = sc.nextInt();

        for(int i = 0 ; i < connectionCount; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = map[b][a]= 1; ////////////////중요
        }

        bfs(1);

        System.out.println(virusCount);

    }

    public static void bfs(int startNode){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visit[startNode] = 1;

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int i = 1; i <= nodeCount; i++ ){
                //방문하지 않았고 연결된 노드라면
                if( map[node][i] == 1 && visit[i]==0){
                    //큐에 추가
                    queue.add(i);
                    virusCount++;
                    visit[i] =1;
                }
            }
        }
    }
}