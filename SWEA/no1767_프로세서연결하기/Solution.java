package SWEA.no1767_프로세서연결하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static List<position> core;
	static int ans, N;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static boolean[] checked;
	static int[][] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			N = Integer.parseInt(br.readLine());
			graph = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					graph[i][j] = Integer.parseInt(st.nextToken());
			}

			// 코어의 위치(가장자리 제외)
			core = new ArrayList<position>();
			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < N - 1; j++) {
					if (graph[i][j] == 1)
						core.add(new position(i, j));
				}
			}

			ans = Integer.MAX_VALUE;
			checked = new boolean[core.size()];
			for (int i = core.size(); i >= 0; i--) {
				combo(0, 0, i);
				if (ans != Integer.MAX_VALUE)
					break;
			}

			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static void combo(int cnt, int start, int c) { // 카운트, 시작 지점, 코어 수
		if (cnt == c) {
			dfs(0);
			return;
		}

		for (int i = start; i < core.size(); i++) {
			checked[i] = true;
			combo(cnt + 1, i + 1, c);
			checked[i] = false;
		}
	}

	private static void dfs(int idx) {
		if (idx == core.size()) {
			ans = Math.min(cntLine(), ans);
			return;
		}

		if (!checked[idx]) {
			dfs(idx + 1);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int cx = core.get(idx).x;
			int cy = core.get(idx).y;
			boolean flag = false;

			while (true) {
				cx += dx[i];
				cy += dy[i];

				if (cx < 0 || cx >= N || cy < 0 || cy >= N) {
					flag = true;
					break;
				}

				if (graph[cx][cy] != 0)
					break;

				graph[cx][cy] = 2;
			}
			if (flag)
				dfs(idx + 1);

			while (true) {
				cx -= dx[i];
				cy -= dy[i];
				if (cx == core.get(idx).x && cy == core.get(idx).y)
					break;
				graph[cx][cy] = 0;
			}
		}
	}

	private static int cntLine() {
		int cnt = 0;
		for (int[] g : graph)
			for (int i : g)
				if (i == 2)
					cnt++;
		return cnt;
	}
}

class position {
	int x, y;

	public position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}