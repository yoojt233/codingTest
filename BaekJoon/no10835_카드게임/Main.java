package BaekJoon.no10835_카드게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] decks, dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		decks = new int[2][N];
		for (int i = 0; i < 2; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j)
				decks[i][j] = Integer.parseInt(st.nextToken());
		}

		dp = new int[N][N];
		for (int i = 0; i < N; ++i)
			Arrays.fill(dp[i], -1);

		System.out.println(solve(0, 0));
		br.close();
	}

	private static int solve(int left, int right) {
		if (left == N || right == N)
			return 0;

		if (dp[left][right] != -1)
			return dp[left][right];

		dp[left][right] = Math.max(solve(left + 1, right), solve(left + 1, right + 1));
		if (decks[0][left] > decks[1][right])
			dp[left][right] = Math.max(dp[left][right], solve(left, right + 1) + decks[1][right]);

		return dp[left][right];
	}
}
