package baekjun.question_2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] map;
    static int[][] visit;

    static int n;
    static int m;

    public static void main(String[] args) {
        //System.out.println("hello world");
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        visit = new int[n][m];

        for(int i = 0 ; i < n; i++){
            String oneLine = sc.next();
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(String.valueOf(oneLine.charAt(j)));
                visit[i][j] = 0;
            }
        }
        bfs();
    }
    public static void bfs(){

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0));

        while(true){
            Point point = queue.poll();

            //System.out.println("Point poll : " + point.getX() + ", "+ point.getY());

            if(point.getX()==n-1 && point.getY()==m-1){
                System.out.println(visit[n-1][m-1]+1);
                break;
            }

            for(int check = 1 ; check <= 4; check++ ){
                Point nextPoint = checkMap(point.getX(),point.getY(),check);
                if(nextPoint!=null){
                    queue.add(nextPoint);
                }
            }
        }


    }




    public static Point checkMap(int x, int y, int i){
        if(i == 1){
           if((x+1 < n) && map[x+1][y] == 1 && visit[x+1][y] == 0){
               visit[x+1][y] = visit[x][y] + 1;
               return new Point(x+1, y);
           }
        }else if(i == 2){
            if((y+1 < m) && map[x][y+1] == 1 && visit[x][y+1] == 0){
                visit[x][y+1] = visit[x][y] + 1;
                return new Point(x, y+1);
            }
        }else if(i == 3){
            if((x-1 >= 0) && map[x-1][y] == 1 && visit[x-1][y] == 0){
                visit[x-1][y] = visit[x][y] + 1;
                return new Point(x-1, y);
            }
        }else if(i == 4){
            if((y-1 >= 0) && map[x][y-1] == 1 && visit[x][y-1] == 0){
                visit[x][y-1] = visit[x][y] + 1;
                return new Point(x, y-1);
            }
        }
        return null;
    }
}

class Point{
    int x;
    int y;

    int distance;
    public Point(int x , int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public void setDistance(int distance){
        this.distance = distance;
    }

}
