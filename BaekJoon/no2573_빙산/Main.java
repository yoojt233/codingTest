package BaekJoon.no2573_빙산;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int row, col;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		map = new int[row][col];
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		int time = 0;

		// 전부 녹은 상태가 아니면서 하나의 덩이일 경우
		while (piece() < 2) {
			if (allMelt()) {
				time = 0;
				break;
			}
			time++;
		}

		System.out.print(time);
		br.close();
	}

	private static boolean allMelt() {
		for (int[] m : map) {
			for (int i : m)
				if (i != 0) {

					// 안녹은게 있다면 false
					return false;
				}
		}

		return true;
	}

	private static int piece() {
		boolean[][] visited = new boolean[row][col];

		int cnt = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				// 바다 or 재방문
				if (map[i][j] == 0 || visited[i][j])
					continue;

				bfs(new pos(i, j), visited);
				cnt++;
			}
		}

		return cnt;
	}

	private static void bfs(pos start, boolean[][] visited) {
		Queue<pos> q = new LinkedList<pos>();
		q.offer(start);
		visited[start.x][start.y] = true;

		while (!q.isEmpty()) {
			pos cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int cx = cur.x + dx[d];
				int cy = cur.y + dy[d];

				if (cx < 0 || cx >= row || cy < 0 || cy >= col || visited[cx][cy])
					continue;

				// 바다면 1 감소
				if (map[cx][cy] == 0) {
					map[cur.x][cur.y]--;

					// 0보다 작으면 0으로 고정
					if (map[cur.x][cur.y] < 0)
						map[cur.x][cur.y] = 0;

					continue;
				}

				q.offer(new pos(cx, cy));
				visited[cx][cy] = true;
			}
		}
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