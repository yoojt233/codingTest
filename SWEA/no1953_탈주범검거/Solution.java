package SWEA.no1953_탈주범검거;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int row, col, time;
	static int[][] map, visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine().trim());
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			time = Integer.parseInt(st.nextToken());

			map = new int[row][col];
			visited = new int[row][col];

			for (int i = 0; i < row; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < col; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}

			bfs(r, c);

			sb.append("#" + t + " " + getCtn() + "\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static int getCtn() {
		int cnt = 0;
		for (int[] v : visited) {
			for (int b : v)
				if (b > 0 && b <= time)
					cnt++;
		}

		return cnt;
	}

	private static void bfs(int r, int c) {
		visited[r][c] = 1;
		Queue<pos> q = new LinkedList<pos>();
		q.offer(new pos(r, c, map[r][c]));
		while (!q.isEmpty()) {
			pos cur = q.poll();

			int cx = 0;
			int cy = 0;

			switch (cur.pipe) {
			case 1: // 상하좌우
				for (int i = 0; i < 4; i++) {
					cx = cur.x + dx[i];
					cy = cur.y + dy[i];
					if (cx >= 0 && cx < row && cy >= 0 && cy < col && visited[cx][cy] == 0 && connected(i, cx, cy)) {
						q.offer(new pos(cx, cy, map[cx][cy]));
						visited[cx][cy] = visited[cur.x][cur.y] + 1;
					}
				}
				break;

			case 2: // 상하
				for (int i = 0; i < 2; i++) {
					cx = cur.x + dx[i];
					cy = cur.y + dy[i];
					if (cx >= 0 && cx < row && cy >= 0 && cy < col && visited[cx][cy] == 0 && connected(i, cx, cy)) {
						q.offer(new pos(cx, cy, map[cx][cy]));
						visited[cx][cy] = visited[cur.x][cur.y] + 1;
					}
				}
				break;

			case 3: // 좌우
				for (int i = 2; i < 4; i++) {
					cx = cur.x + dx[i];
					cy = cur.y + dy[i];
					if (cx >= 0 && cx < row && cy >= 0 && cy < col && visited[cx][cy] == 0 && connected(i, cx, cy)) {
						q.offer(new pos(cx, cy, map[cx][cy]));
						visited[cx][cy] = visited[cur.x][cur.y] + 1;
					}
				}
				break;

			case 4: // 상우
				for (int i = 0; i < 4; i += 3) {
					cx = cur.x + dx[i];
					cy = cur.y + dy[i];
					if (cx >= 0 && cx < row && cy >= 0 && cy < col && visited[cx][cy] == 0 && connected(i, cx, cy)) {
						q.offer(new pos(cx, cy, map[cx][cy]));
						visited[cx][cy] = visited[cur.x][cur.y] + 1;
					}
				}
				break;

			case 5: // 하우
				for (int i = 1; i < 4; i += 2) {
					cx = cur.x + dx[i];
					cy = cur.y + dy[i];
					if (cx >= 0 && cx < row && cy >= 0 && cy < col && visited[cx][cy] == 0 && connected(i, cx, cy)) {
						q.offer(new pos(cx, cy, map[cx][cy]));
						visited[cx][cy] = visited[cur.x][cur.y] + 1;
					}
				}
				break;

			case 6: // 하좌
				for (int i = 1; i < 3; i++) {
					cx = cur.x + dx[i];
					cy = cur.y + dy[i];
					if (cx >= 0 && cx < row && cy >= 0 && cy < col && visited[cx][cy] == 0 && connected(i, cx, cy)) {
						q.offer(new pos(cx, cy, map[cx][cy]));
						visited[cx][cy] = visited[cur.x][cur.y] + 1;
					}
				}
				break;

			case 7: // 상좌
				for (int i = 0; i < 4; i += 2) {
					cx = cur.x + dx[i];
					cy = cur.y + dy[i];
					if (cx >= 0 && cx < row && cy >= 0 && cy < col && visited[cx][cy] == 0 && connected(i, cx, cy)) {
						q.offer(new pos(cx, cy, map[cx][cy]));
						visited[cx][cy] = visited[cur.x][cur.y] + 1;
					}
				}
				break;
			}

		}
	}

	private static boolean connected(int d, int cx, int cy) {
		if (map[cx][cy] == 0)
			return false;

		switch (d) {
		case 0:
			if (map[cx][cy] == 3 || map[cx][cy] == 4 || map[cx][cy] == 7)
				return false;
			break;

		case 1:
			if (map[cx][cy] == 3 || map[cx][cy] == 5 || map[cx][cy] == 6)
				return false;
			break;

		case 2:
			if (map[cx][cy] == 2 || map[cx][cy] == 6 || map[cx][cy] == 7)
				return false;
			break;

		case 3:
			if (map[cx][cy] == 2 || map[cx][cy] == 4 || map[cx][cy] == 5)
				return false;
			break;

		}
		return true;
	}
}

class pos {
	int x, y, pipe;

	public pos(int x, int y, int pipe) {
		super();
		this.x = x;
		this.y = y;
		this.pipe = pipe;
	}
}