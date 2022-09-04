package SWEA.no1974_스도쿠검증;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] sudoku;
	static int[] v;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			sudoku = new int[9][9];

			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			if (solve()) {
				sb.append(1);
			} else
				sb.append(0);
			sb.append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}

	private static boolean solve() {

		// horizontal
		for (int i = 0; i < 9; i++) {
			v = new int[10];
			for (int j = 0; j < 9; j++) {
				v[sudoku[i][j]]++;
			}
			for (int k = 1; k < 10; k++)
				if (v[k] != 1)
					return false;
		}

		// vertical
		for (int i = 0; i < 9; i++) {
			v = new int[10];
			for (int j = 0; j < 9; j++) {
				v[sudoku[j][i]]++;
			}
			for (int k = 1; k < 10; k++)
				if (v[k] != 1)
					return false;
		}

		// square
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				v = new int[10];
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						v[sudoku[i * 3 + k][j * 3 + l]]++;
					}
				}
				for (int m = 1; m < 10; m++)
					if (v[m] != 1)
						return false;
			}
		}
		return true;
	}
}
