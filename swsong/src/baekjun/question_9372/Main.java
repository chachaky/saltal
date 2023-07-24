package baekjun.question_9372;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] visit;
    static int[][] map;

    static int n;
    static int m;

    static int count;
    public static void main(String[] args) {
        int testCount;

        Scanner sc = new Scanner(System.in);

        testCount = sc.nextInt();

        for(int i = 0 ; i < testCount; i ++){

            count = 0;

            n = sc.nextInt();
            m = sc.nextInt();

            visit = new int[n+1];
            map = new int[n+1][n+1];

            for(int j = 0 ; j < m; j++){
                int a = sc.nextInt();
                int b = sc.nextInt();

                map[a][b] = 1;
                map[b][a] = 1;
            }

            bfs(1);

            System.out.println(count-1);
        }
    }

    private static void bfs(int startNode) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(startNode);

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int i = 1; i <= n; i ++ ){
                if(visit[i] == 0 && map[node][i] ==1){
                    visit[i] = 1;
                    queue.add(i);
                    count++;
                }
            }
        }

    }
}
