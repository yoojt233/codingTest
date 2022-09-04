package BaekJoon.no2206_벽부수고이동하기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Node {
	static int N, M;
	static int mat[][];
	static boolean visited[][][];

	public static void main(String[] args) {
		String str;
		Scanner scan = new Scanner(System.in);

		N = scan.nextInt();
		M = scan.nextInt();
		visited = new boolean[N][M][2]; // visited[][][0]:안부숨, 1부숨
		mat = new int[N][M];

		for (int i = 0; i < N; i++) {
			str = scan.next();
			for (int j = 0; j < M; j++) {
				mat[i][j] = Integer.parseInt(str.charAt(j) + "");
			}
		}

		bfs(0, 0);
	}

	public static void bfs(int x, int y) {
		int nx, ny, wall, cnt = 1;
		int dx[] = { -1, 0, 0, 1 };
		int dy[] = { 0, -1, 1, 0 };
		Point p;
		Queue<Point> que = new LinkedList<Point>();

		que.offer(new Point(x, y, 0, 1));

		visited[x][y][0] = true;
		visited[x][y][1] = true;

		while (!que.isEmpty()) {
			p = que.poll();

			if (p.x == N - 1 && p.y == M - 1) {
				System.out.println(p.cnt);
				return;
			}

			for (int i = 0; i < 4; i++) {
				nx = p.x + dx[i];
				ny = p.y + dy[i];
				wall = p.wall;
				cnt = p.cnt;

				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (mat[nx][ny] == 1 && wall == 0 && visited[nx][ny][1] == false) { // 벽&벽을 부순적 없음
						visited[nx][ny][1] = true;
						que.offer(new Point(nx, ny, 1, cnt + 1));
					} else if (mat[nx][ny] == 0 && !visited[nx][ny][wall]) { // 이동 가능(벽없음)
						visited[nx][ny][wall] = true;
						que.offer(new Point(nx, ny, wall, cnt + 1));
					}
				}

			}
		} // while

		System.out.println("-1");
	}// bfs

	static class Point {
		int x, y, wall, cnt;

		public Point(int x, int y, int wall, int cnt) {
			this.x = x;
			this.y = y;
			this.wall = wall;
			this.cnt = cnt;
		}
	}
}