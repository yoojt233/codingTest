package BaekJoon.no1022_소용돌이예쁘게출력하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int sx, ex, sy, ey, max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken()) + 5000;
		sy = Integer.parseInt(st.nextToken()) + 5000;
		ex = Integer.parseInt(st.nextToken()) + 5000;
		ey = Integer.parseInt(st.nextToken()) + 5000;

		map = new int[ex - sx + 1][ey - sy + 1];
		init();

		int std = check(max);
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				for (int s = 0; s < std - check(map[i][j]); s++)
					sb.append(" ");
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static int check(int num) {
		int cnt = 1;
		while (num / 10 > 0) {
			++cnt;
			num /= 10;
		}
		return cnt;
	}

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };

	private static void init() {
		int idx = 1;
		int row = 5000, col = 5000;
		fill(idx, row, col);

		int k = 1, d = 0;
		while (isZero()) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < k; j++) {
					row += dx[d];
					col += dy[d];

					++idx;
					fill(idx, row, col);
				}
				d = (d + 1) % 4;
			}
			++k;
		}
	}

	private static boolean isZero() {
		for (int[] arr : map) {
			for (int i : arr) {
				if (i == 0)
					return true;
			}
		}
		return false;
	}

	private static void fill(int idx, int row, int col) {
		if (row >= sx && col >= sy && row <= ex && col <= ey) {
			map[row - sx][col - sy] = idx;
			max = idx;
		}
	}
}