package BaekJoon.no1103_게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int row, col; // 행, 열
	static int[][] map; // 입력받을 배열
	static int[][] dp; // Memoization 배열

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		map = new int[row][col];
		dp = new int[row][col];

		// 입력
		for (int i = 0; i < row; i++) {
			String s = br.readLine();
			for (int j = 0; j < col; j++) {
				char temp = s.charAt(j);
				if (temp == 'H')
					map[i][j] = 0;
				else
					map[i][j] = temp - '0';
			}
		}

		// (0, 0)이 시작점
		int ans = dfs(0, 0, 0);
		if (ans != -1)
			ans++;

		System.out.println(ans);
		br.close();
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static int dfs(int i, int j, int level) {

		// 이미 값이 저장되어있다.
		if (dp[i][j] != 0)
			return dp[i][j];

		// 무한 이동 체크
		if (level > row * col)
			return -1;

		int move = map[i][j];
		int cnt = 0;
		for (int d = 0; d < 4; d++) {
			int cx = i + dx[d] * move;
			int cy = j + dy[d] * move;

			// 범위 이탈 및 구멍
			if (cx < 0 || cx >= row || cy < 0 || cy >= col || map[cx][cy] == 0)
				continue;

			int temp = dfs(cx, cy, level + 1);
			if (temp == -1) {
				dp[cx][cy] = -1;
				return -1;
			} else
				cnt = Integer.max(cnt, temp + 1);
		}

		dp[i][j] = cnt;
		return cnt;
	}
}