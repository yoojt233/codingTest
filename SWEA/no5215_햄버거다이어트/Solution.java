package SWEA.no5215_햄버거다이어트;

import java.util.Scanner;

public class Solution {
    static int[][] recipe;
    static int n, L, max;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); // 테스트 케이스
 
        for (int t = 0; t < tc; t++) {
            n = sc.nextInt(); // 재료 수
            L = sc.nextInt(); // 칼로리 limit
            max = 0;
 
            recipe = new int[n][2];
            for (int i = 0; i < n; i++) {
                recipe[i][0] = sc.nextInt();
                recipe[i][1] = sc.nextInt();
            }
 
            combo(0, 0, 0);
            System.out.printf("#%d %d\n", t + 1, max);
        }
        sc.close();
    }
 
    private static void combo(int idx, int score, int carl) {
        if (carl > L) {
            return;
        }
        if (idx == n) {
            max = Math.max(max, score);
            return;
        }
        combo(idx + 1, score + recipe[idx][0], carl + recipe[idx][1]);
        combo(idx + 1, score, carl);
    }
}