package SWEA.no2001_파리퇴치;

import java.util.Scanner;

public class Solution {
    static int[][] fly;
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 0; t < tc; t++) {
            int n = sc.nextInt();
            fly = new int[n][n];
            int m = sc.nextInt();
  
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    fly[i][j] = sc.nextInt();
                }
            }
  
            int chance = n - m + 1;
            int answer = 0;
            for (int i = 0; i < chance; i++) {
                for (int j = 0; j < chance; j++) {
                    int sum = 0;
                    for (int a = i; a < i + m; a++) {
                        for (int b = j; b < j + m; b++) {
                            sum += fly[a][b];
                        }
                    }
                    if(sum > answer)
                        answer = sum;
                }
            }
            System.out.printf("#%d %d\n", t + 1, answer);
        }
        sc.close();
    }
}