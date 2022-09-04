package BaekJoon.no1890_점프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static long[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		dp = new long[N][N];
		for (int i = 0; i < N; i++)
			Arrays.fill(dp[i], -1);

		dfs(0, 0);

		System.out.print(dp[0][0]);
		br.close();
	}

	private static long dfs(int x, int y) {
		if (x == N - 1 && y == N - 1)
			return 1;

		if (dp[x][y] != -1)
			return dp[x][y];

		int move = map[x][y];
		dp[x][y] = 0;

		if (x + move < N)
			dp[x][y] += dfs(x + move, y);

		if (y + move < N)
			dp[x][y] += dfs(x, y + move);

		return dp[x][y];
	}
}