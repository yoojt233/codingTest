package SWEA.no1954_달팽이숫자;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
 
        // 우 하 좌 상
        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { 1, 0, -1, 0 };
 
        for (int a = 0; a < tc; a++) {
            // n은 변의 길이
            int n = sc.nextInt();
            int[][] snail = new int[n][n];
 
            int cnt = 1;
            int x = 0, y = 0, k = 0;
 
            while (cnt <= Math.pow(n, 2)) {
                snail[x][y] = cnt++;
                x += dx[k];
                y += dy[k];
                if (x < 0 || y < 0 || x >= n || y >= n || snail[x][y] != 0) {
                    x -= dx[k];
                    y -= dy[k];
                    if (k == 3)
                        k = 0;
                    else
                        k++;
                    x += dx[k];
                    y += dy[k];
                }
            }
 
            // 달팽이 출력
            System.out.printf("#%d\n", a + 1);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("%d ", snail[i][j]);
                }
                System.out.println();
            }
        }
        sc.close();
    }
}