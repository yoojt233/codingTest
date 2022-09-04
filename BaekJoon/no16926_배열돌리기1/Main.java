package BaekJoon.no16926_배열돌리기1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static String[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		map = new String[row][col];
		for (int i = 0; i < row; i++)
			map[i] = br.readLine().split(" ");

		int k = Math.min(row, col) / 2;
		for (int i = 0; i < n; i++) { // 돌릴 횟수
			for (int j = 0; j < k; j++) { // 얼마나 내부?
				move_left(j, j, row - j - 1, col - j - 1);
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.print(sb.toString());
	}

	private static void move_left(int sx, int sy, int ex, int ey) {
		String temp = map[sx][sy];

		// 윗줄 왼쪽으로 이동
		for (int i = sy; i < ey; i++)
			map[sx][i] = map[sx][i + 1];

		// 오른쪽줄 위로 이동
		for (int i = sx; i < ex; i++)
			map[i][ey] = map[i + 1][ey];

		// 아랫줄 오른쪽으로 이동
		for (int i = ey; i > sy; i--)
			map[ex][i] = map[ex][i - 1];

		// 왼쪽줄 아래로 이동
		for (int i = ex; i > sx; i--)
			map[i][sy] = map[i - 1][sy];

		map[sx + 1][sy] = temp;
	}
}
