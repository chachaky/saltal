package baekjun.question_11047;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[] coinMap;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int count = 0;

        coinMap = new int[n];

        for(int i = 0; i < n; i++ ){
            coinMap[i] = sc.nextInt();
        }

        for(int i = n-1; i >=0 ; i--){
            if(k ==0 ) break;

            if(k >= coinMap[i]){
                count += k/coinMap[i];
                k = k % coinMap[i];
            }
       }

        System.out.println(count);
    }
}
