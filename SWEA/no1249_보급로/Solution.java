package SWEA.no1249_보급로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static int N;
	static int[][] map, dijk;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dijk = new int[N][N];

			for (int i = 0; i < N; i++) {
				String dig = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = dig.charAt(j) - '0';
					dijk[i][j] = Integer.MAX_VALUE;
				}
			}

			bfs();

			sb.append("#" + t + " " + dijk[N - 1][N - 1] + "\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static void bfs() {
		Queue<pos> q = new LinkedList<pos>();
		q.offer(new pos(0, 0, map[0][0]));
		dijk[0][0] = map[0][0];

		while (!q.isEmpty()) {
			pos cur = q.poll();

			if (dijk[cur.r][cur.c] < cur.value)
				continue;

			for (int i = 0; i < 4; i++) {
				int cx = cur.r + dx[i];
				int cy = cur.c + dy[i];

				if (cx < 0 || cx >= N || cy < 0 || cy >= N)
					continue;

				if (dijk[cx][cy] > dijk[cur.r][cur.c] + map[cx][cy]) {
					dijk[cx][cy] = dijk[cur.r][cur.c] + map[cx][cy];
					q.offer(new pos(cx, cy, dijk[cx][cy]));
				}
			}
		}
	}

	static class pos {
		int r, c, value;

		public pos(int r, int c, int value) {
			this.r = r;
			this.c = c;
			this.value = value;
		}

		@Override
		public String toString() {
			return "pos [r=" + r + ", c=" + c + ", value=" + value + "]";
		}
	}
}
