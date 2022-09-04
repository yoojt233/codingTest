package BaekJoon.no2234_성곽;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int row, col, total, wide = 1;
	static int[][] map;
	static boolean[][] visited;

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());

		map = new int[row][col];
		visited = new boolean[row][col];

		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (!visited[i][j]) {
					bfs(i, j);
					total++;
				}
			}
		}

		sb.append(total + "\n" + wide + "\n");

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				// 벽 뿌셔!
				for (int k = 0; k < 3; k++) {
					if ((map[i][j] & (1 << k)) != 0) {
						map[i][j] -= (1 << k);
						visited = new boolean[row][col];
						bfs(i, j);
						map[i][j] += (1 << k);
					}
				}
			}
		}

		sb.append(wide);

		System.out.print(sb.toString());
		br.close();
	}

	private static void bfs(int x, int y) {
		int cnt = 1;

		Queue<pos> q = new LinkedList<>();
		q.offer(new pos(x, y));
		visited[x][y] = true;

		while (!q.isEmpty()) {
			pos cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int cx = cur.x + dx[d];
				int cy = cur.y + dy[d];

				// 경계, 방문, 벽
				if (cx < 0 || cx >= row || cy < 0 || cy >= col || visited[cx][cy] || ((map[cur.x][cur.y] & (1 << d)) != 0))
					continue;

				q.offer(new pos(cx, cy));
				visited[cx][cy] = true;
				cnt++;
			}
		}

		wide = cnt > wide ? cnt : wide;
	}
}

class pos {
	int x, y;

	public pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
