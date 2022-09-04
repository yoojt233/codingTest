package BaekJoon.no2206_벽부수고이동하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char[][] map;
	static boolean[][][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[2][N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++)
				map[i][j] = s.charAt(j);
		}

		int ans = bfs();

		System.out.print(ans);
		br.close();
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static int bfs() {
		Queue<pos> q = new LinkedList<pos>();
		q.add(new pos(0, 0, 1, false));
		visited[0][0][0] = true;
		visited[1][0][0] = true;

		while (!q.isEmpty()) {
			pos cur = q.poll();

			// 도착
			if (cur.x == N - 1 && cur.y == M - 1)
				return cur.move;

			// 사방 탐색
			for (int d = 0; d < 4; d++) {
				int cx = cur.x + dx[d];
				int cy = cur.y + dy[d];

				if (cx < 0 || cx >= N || cy < 0 || cy >= M)
					continue;

				// map[cx][cy]가 0일 때
				if (map[cx][cy] == '0') {
					if (!cur.status && !visited[0][cx][cy]) {
						visited[0][cx][cy] = true;
						q.add(new pos(cx, cy, cur.move + 1, cur.status));
					} else if (cur.status && !visited[1][cx][cy]) {
						visited[1][cx][cy] = true;
						q.add(new pos(cx, cy, cur.move + 1, cur.status));
					}
				}

				// map[cx][cy]가 1일 때
				else {
					if (!cur.status && !visited[1][cx][cy]) {
						visited[1][cx][cy] = true;
						q.add(new pos(cx, cy, cur.move + 1, true));
					}
				}
			}
		}
		return -1;
	}
}

class pos {
	int x, y, move;
	boolean status; // 벽 부셨으면 true, 아직 안부셨으면 false

	public pos(int x, int y, int move, boolean status) {
		super();
		this.x = x;
		this.y = y;
		this.move = move;
		this.status = status;
	}
}