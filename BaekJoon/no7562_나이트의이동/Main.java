package BaekJoon.no7562_나이트의이동;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static pos[] target = new pos[2];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 테케 수
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			N = Integer.parseInt(br.readLine());

			// 0 : 시작 위치, 1 : 목표 위치
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				target[i] = new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
			}

			sb.append(bfs()).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}

	// 나이트의 이동 방향
	static int[] dx = { -2, -2, -1, 1, 2, 2, 1, -1 };
	static int[] dy = { -1, 1, 2, 2, 1, -1, -2, -2 };

	private static int bfs() {

		// 방문 체크
		boolean[][] visited = new boolean[N][N];

		Queue<pos> q = new LinkedList<pos>();

		// 시작 위치
		q.offer(target[0]);
		visited[target[0].x][target[0].y] = true;

		while (!q.isEmpty()) {
			pos cur = q.poll(); // 현재 위치

			// 목표에 도착하면 끝
			if (cur.x == target[1].x && cur.y == target[1].y)
				return cur.move;

			for (int i = 0; i < 8; i++) {
				int cx = cur.x + dx[i];
				int cy = cur.y + dy[i];

				// 경계값 체크, 방문여부 체크
				if (cx < 0 || cx >= N || cy < 0 || cy >= N || visited[cx][cy])
					continue;

				q.offer(new pos(cx, cy, cur.move + 1));
				visited[cx][cy] = true;
			}
		}

		return -1;
	}
}

class pos {
	int x, y, move;

	public pos(int x, int y, int move) {
		super();
		this.x = x;
		this.y = y;
		this.move = move;
	}
}