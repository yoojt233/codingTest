package SWEA.no1208_Flatten;

import java.util.Scanner;

public class Solution {
    static int min, max;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 10;
        for (int a = 0; a < tc; a++) {
            int ans = 0;
            int[] box = new int[100];
            int n = sc.nextInt();
            for (int b = 0; b < 100; b++)
                box[b] = sc.nextInt();
            dump(n, box);
            dif(box);
            ans = max - min;
            System.out.printf("#%d %d\n", a + 1, ans);
        }
        sc.close();
    }
 
    static void dump(int n, int[] b) {
        if (n > 0) {
            dif(b);
            for (int i = 0; i < 100; i++) {
                if (b[i] == max) {
                    b[i] -= 1;
                    break;
                }
            }
            for (int i = 0; i < 100; i++) {
                if (b[i] == min) {
                    b[i] += 1;
                    break;
                }
            }
            dump(n - 1, b);
        }
    }
 
    static void dif(int[] b) {
        max = 1; min = 100;
        for (int i = 0; i < 100; i++) {
            if (b[i] >= max)
                max = b[i];
            if (b[i] <= min)
                min = b[i];
        }
    }
}