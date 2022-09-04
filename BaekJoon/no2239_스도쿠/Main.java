package BaekJoon.no2239_스도쿠;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char[][] map; // 스도쿠
	static boolean flag; // 완성 여부

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		map = new char[9][9];

		for (int i = 0; i < 9; i++)
			map[i] = br.readLine().toCharArray();

		flag = false;
		sudoku();

		for (char[] ch : map) {
			for (char c : ch)
				sb.append(c);
			sb.append("\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static void sudoku() {

		// 완성됬으면 return.
		if (flag)
			return;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (map[i][j] == '0') {
					for (int k = 1; k <= 9; k++) {
						if (!flag) {
							if (rowCheck(i, k) && colCheck(j, k) && boxCheck(i, j, k)) {
								map[i][j] = (char) (k + '0');
								flag = complete();
								sudoku();
								if (!flag)
									map[i][j] = '0';
							}
						} else
							return;
					}
					return;
				}
			}
		}
	}

	// 3x3 박스 체크
	private static boolean boxCheck(int c, int r, int n) {
		c = c / 3 * 3;
		r = r / 3 * 3;
		for (int i = c; i < c + 3; i++) {
			for (int j = r; j < r + 3; j++) {
				if (map[i][j] == ('0' + n))
					return false;
			}
		}
		return true;
	}

	// 열 체크
	private static boolean colCheck(int c, int n) {
		for (int i = 0; i < 9; i++) {
			if (map[i][c] == ('0' + n))
				return false;
		}
		return true;
	}

	// 행 체크
	private static boolean rowCheck(int r, int n) {
		for (int i = 0; i < 9; i++) {
			if (map[r][i] == ('0' + n))
				return false;
		}
		return true;
	}

	// 스도쿠 완성?
	private static boolean complete() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (map[i][j] == '0')
					return false;
			}
		}
		return true;
	}
}
