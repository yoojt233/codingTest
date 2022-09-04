package BaekJoon.no4485_녹색옷입은애가젤다지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] map, dijk;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = 1;
		N = Integer.parseInt(br.readLine());
		while (N != 0) {
			map = new int[N][N];
			dijk = new int[N][N];

			// 값 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dijk[i][j] = Integer.MAX_VALUE;
				}
			}

			bfs();
			sb.append("Problem " + (tc++) + ": " + dijk[N - 1][N - 1] + "\n");
			
			N = Integer.parseInt(br.readLine());
		}
		System.out.print(sb.toString());
		br.close();
	}

	private static void bfs() {
		Queue<pos> q = new LinkedList<pos>();
		dijk[0][0] = map[0][0];
		q.offer(new pos(0, 0, dijk[0][0]));

		while (!q.isEmpty()) {
			pos cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int cx = cur.x + dx[i];
				int cy = cur.y + dy[i];

				if (cx < 0 || cx >= N || cy < 0 || cy >= N || dijk[cx][cy] < dijk[cur.x][cur.y])
					continue;

				if (dijk[cx][cy] > dijk[cur.x][cur.y] + map[cx][cy]) {
					dijk[cx][cy] = dijk[cur.x][cur.y] + map[cx][cy];
					q.offer(new pos(cx, cy, dijk[cx][cy]));
				}
			}
		}
	}
}

class pos {
	int x, y, val;

	public pos(int x, int y, int val) {
		super();
		this.x = x;
		this.y = y;
		this.val = val;
	}

	@Override
	public String toString() {
		return "pos [x=" + x + ", y=" + y + ", val=" + val + "]";
	}
}
