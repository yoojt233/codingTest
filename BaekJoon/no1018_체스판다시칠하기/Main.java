package BaekJoon.no1018_체스판다시칠하기;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 세로
		int m = sc.nextInt(); // 가로
		char[][] map = new char[n][m];

		// 체스판 입력
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		// 체스판 종류
		char[][] typeWhite = { { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
				{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
				{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
				{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' } };
		char[][] typeBlack = { { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
				{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
				{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
				{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' } };

		int answer = 32;
		for (int a = 0; a < n - 7; a++) {
			for (int b = 0; b < m - 7; b++) {
				int cntWhite = 0;
				int cntBlack = 0;
				for (int i = a; i < a + 8; i++) {
					for (int j = b; j < b + 8; j++) {
						if (map[i][j] != typeWhite[i-a][j-b])
							cntWhite++;
						if (map[i][j] != typeBlack[i-a][j-b])
							cntBlack++;
					}
				}
				answer = Math.min(answer, Math.min(cntWhite, cntBlack));
			}
		}
		System.out.println(answer);
		sc.close();
	}
}
