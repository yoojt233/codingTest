package SWEA.no2805_농작물수확하기;

import java.util.Scanner;

public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        // test_case
        int tc = sc.nextInt();
        for (int a = 0; a < tc; a++) {
 
            // 변의 크기
            int n = sc.nextInt();
            char[][] farm = new char[n][n];
 
            int sum = 0;
            int blank = n / 2;
 
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                String str = sc.nextLine();
                farm[i] = str.toCharArray();
            }
 
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    farm[i][j] -= '0';
                }
            }
 
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < blank; j++) {
                    farm[i][j] = 0;
                }
                for (int j = n - 1; j > n - blank-1; j--) {
                    farm[i][j] = 0;
                }
                blank--;
            }
            blank = 1;
            for (int i = n / 2 + 1; i < n; i++) {
                for (int j = 0; j < blank; j++) {
                    farm[i][j] = 0;
                }
                for (int j = n - 1; j > n - blank-1; j--) {
                    farm[i][j] = 0;
                }
                blank++;
            }
 
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    sum += farm[i][j];
 
            System.out.printf("#%d %d\n", a + 1, sum);
        }
        sc.close();
    }
}
