package BaekJoon.no1937_욕심쟁이판다;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map, dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N];

		// map 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		int max = 0;

		// 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				max = Integer.max(max, dfs(i, j));
		}

		System.out.println(max + 1);
		br.close();
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static int dfs(int x, int y) {
		if (dp[x][y] != 0)
			return dp[x][y];

		int cnt = 0;
		for (int d = 0; d < 4; d++) {
			int cx = x + dx[d];
			int cy = y + dy[d];

			if (cx < 0 || cx >= N || cy < 0 || cy >= N || map[cx][cy] <= map[x][y])
				continue;

			cnt = Integer.max(cnt, dfs(cx, cy) + 1);
		}

		dp[x][y] = cnt;
		return cnt;
	}
}
