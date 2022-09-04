package BaekJoon.no1189_컴백홈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, K, ans;
	static char[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++)
			map[i] = br.readLine().toCharArray();

		visited[R - 1][0] = true;
		dfs(new pos(R - 1, 0, 1));

		System.out.print(ans);
		br.close();
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void dfs(pos cur) {
		for (int d = 0; d < 4; d++) {
			int cx = cur.x + dx[d];
			int cy = cur.y + dy[d];
			int cm = cur.move + 1;

			if (cx < 0 || cx >= R || cy < 0 || cy >= C || map[cx][cy] == 'T' || visited[cx][cy] || cm > K)
				continue;

			if (cx == 0 && cy == C - 1 && cm == K)
				++ans;
			else {
				visited[cx][cy] = true;
				dfs(new pos(cx, cy, cm));
				visited[cx][cy] = false;
			}
		}
	}
}

class pos {
	int x, y, move;

	public pos(int x, int y, int move) {
		this.x = x;
		this.y = y;
		this.move = move;
	}
}