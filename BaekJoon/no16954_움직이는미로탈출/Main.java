package BaekJoon.no16954_움직이는미로탈출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static char[][] map;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new char[8][8];
		for (int i = 0; i < 8; i++)
			map[i] = br.readLine().toCharArray();

		System.out.print(bfs());

		br.close();
	}

	private static int bfs() {
		Queue<pos> q = new LinkedList<pos>();
		q.add(new pos(7, 0));

		while (!q.isEmpty()) {
			int size = q.size();
			boolean[][] visited = new boolean[8][8];

			for (int i = 0; i < size; i++) {
				pos cur = q.poll();

				if (cur.x == 0 && cur.y == 7)
					return 1;

				for (int d = 0; d < 9; d++) {
					int cx = cur.x + dx[d];
					int cy = cur.y + dy[d];

					if (cx < 0 || cx >= 8 || cy < 0 || cy >= 8 || map[cx][cy] == '#' || visited[cx][cy])
						continue;

					if (cx > 0 && map[cx - 1][cy] == '#')
						continue;

					q.offer(new pos(cx, cy));
					visited[cx][cy] = true;
				}
			}

			// 한 바퀴 Queue 돌고 벽 내리기
			getDown();
		}

		return 0;
	}

	private static void getDown() {
		for (int i = 6; i >= 0; i--)
			map[i + 1] = map[i].clone();

		Arrays.fill(map[0], '.');
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