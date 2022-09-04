package BaekJoon.no2186_문자판;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static int[][][] dp;
	static int N, M, K, ans;
	static String target;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		K = Integer.parseInt(st.nextToken()); // 최대 이동 가능 거리
		ans = 0;
		map = new char[N][M];

		for (int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();

		target = br.readLine(); // 목표 문자열

		// 3차원 배열 dp의 모든 값을 -1로 초기화
		dp = new int[target.length()][N][M];
		for (int i = 0; i < target.length(); i++) {
			for (int j = 0; j < N; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				ans += dfs(0, i, j);
		}

		System.out.print(ans);
		br.close();
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static int dfs(int cnt, int x, int y) {

		// cnt 값이 목표의 길이와 같다면 문자열 완성
		if (cnt == target.length() - 1) {
			dp[cnt][x][y] = 1;
			return 1;
		}

		// 이미 방문했던 곳
		if (dp[cnt][x][y] != -1)
			return dp[cnt][x][y];

		// 해당 위치의 칸이 목표의 문자와 다르다면 방문 처리 후 0 return.
		if (map[x][y] != target.charAt(cnt)) {
			dp[cnt][x][y] = 0;
			return 0;
		}

		// 방문 처리
		dp[cnt][x][y] = 0;
		for (int d = 0; d < 4; d++) {
			for (int k = 1; k <= K; k++) {
				int cx = x + dx[d] * k;
				int cy = y + dy[d] * k;

				// 범위 이탈, 다음 문자가 다른 경우
				if (cx < 0 || cx >= N || cy < 0 || cy >= M || map[cx][cy] != target.charAt(cnt + 1))
					continue;

				dp[cnt][x][y] += dfs(cnt + 1, cx, cy);
			}
		}

		return dp[cnt][x][y];
	}
}