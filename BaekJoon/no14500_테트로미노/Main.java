package BaekJoon.no14500_테트로미노;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int N, M, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		ans = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(0, i, j, map[i][j]);
				visited[i][j] = false;
				h(i, j, map[i][j]);
			}
		}

		System.out.print(ans);
		br.close();
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void h(int x, int y, int total) {
		OUT: for (int i = 0; i < 4; i++) {
			int temp = total;
			for (int j = 0; j < 3; j++) {
				int cx = x + dx[(i + j) % 4];
				int cy = y + dy[(i + j) % 4];

				if (cx < 0 || cx >= N || cy < 0 || cy >= M)
					continue OUT;

				temp += map[cx][cy];
			}

			if (temp > ans)
				ans = temp;
		}
	}

	private static void dfs(int cnt, int x, int y, int total) {
		if (cnt == 3) {
			if (total > ans)
				ans = total;
			return;
		}

		for (int d = 0; d < 4; d++) {
			int cx = x + dx[d];
			int cy = y + dy[d];

			if (cx < 0 || cx >= N || cy < 0 || cy >= M || visited[cx][cy])
				continue;

			visited[cx][cy] = true;
			dfs(cnt + 1, cx, cy, total + map[cx][cy]);
			visited[cx][cy] = false;
		}
	}
}
