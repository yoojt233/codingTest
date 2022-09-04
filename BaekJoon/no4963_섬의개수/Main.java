package BaekJoon.no4963_섬의개수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int row, col;
	static int[][] map;
	static boolean[][] checked;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());

		while (!finished(row, col)) {
			map = new int[row][col];
			checked = new boolean[row][col];

			for (int i = 0; i < row; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < col; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}

			int ans = 0;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (map[i][j] == 1 && !checked[i][j]) {
						dfs(i, j);
						ans++;
					}
				}
			}

			sb.append(ans).append("\n");

			st = new StringTokenizer(br.readLine());
			col = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static void dfs(int x, int y) {
		checked[x][y] = true;
		for (int i = 0; i < 8; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];

			if (cx >= 0 && cx < row && cy >= 0 && cy < col && map[cx][cy] == 1 && !checked[cx][cy])
				dfs(cx, cy);
		}
	}

	private static boolean finished(int x, int y) {
		if (x == 0 && y == 0)
			return true;
		return false;
	}
}