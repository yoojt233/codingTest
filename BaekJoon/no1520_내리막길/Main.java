package BaekJoon.no1520_내리막길;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map, ans;
	static boolean[][] visited;
	static int row, col;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		ans = new int[row][col];
		visited = new boolean[row][col];

		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		System.out.print(dfs(row - 1, col - 1));

		br.close();
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static int dfs(int x, int y) {
		if (x == 0 && y == 0)
			return 1;

		if (ans[x][y] != 0 || visited[x][y])
			return ans[x][y];

		visited[x][y] = true;
		for (int d = 0; d < 4; d++) {
			int cx = x + dx[d];
			int cy = y + dy[d];

			// 경계값, 오르막 or 평지
			if (cx < 0 || cx >= row || cy < 0 || cy >= col || map[cx][cy] <= map[x][y])
				continue;

			ans[x][y] += dfs(cx, cy);
		}
		return ans[x][y];
	}
}