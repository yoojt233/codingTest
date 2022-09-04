package BaekJoon.no1941_소문난칠공주;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static char[][] map = new char[5][5];
	static pos[] std = new pos[25];
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; i++) {
			String line = br.readLine();
			map[i] = line.toCharArray();
			for (int j = 0; j < 5; j++)
				std[i * 5 + j] = new pos(i, j, line.charAt(j));
		}

		combo(0, 0, new pos[7], 0, 0);

		System.out.print(ans);
		br.close();
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void combo(int cnt, int start, pos[] sel, int s, int y) {

		// 임도연파 4명 결성되는 순간 멸ㅋ망ㅋ
		if (y >= 4)
			return;

		// 7명이면 연결성 체크
		if (cnt == 7) {
			if (bfs(sel))
				ans++;
			return;
		}

		// 조합
		for (int i = start; i < 25; i++) {
			sel[cnt] = std[i];
			if (sel[cnt].status == 'S')
				combo(cnt + 1, i + 1, sel, s + 1, y);
			else
				combo(cnt + 1, i + 1, sel, s, y + 1);
		}
	}

	private static boolean bfs(pos[] sel) {
		boolean[] visited = new boolean[7];

		Queue<pos> q = new LinkedList<pos>();
		q.offer(sel[0]);
		visited[0] = true; // 시작 지점 방문 체크

		while (!q.isEmpty()) {
			pos cur = q.poll();

			// 사방 탐색
			for (int d = 0; d < 4; d++) {
				int cx = cur.x + dx[d];
				int cy = cur.y + dy[d];

				if (cx < 0 || cx >= 5 || cy < 0 || cy >= 5)
					continue;

				for (int i = 0; i < 7; i++) {
					if (visited[i])
						continue;

					if (sel[i].x == cx && sel[i].y == cy) {
						q.offer(sel[i]);
						visited[i] = true;
						break;
					}
				}
			}
		}

		// 연결 안된 사람이 있으면 false
		for (boolean b : visited) {
			if (!b)
				return false;
		}

		return true;
	}
}

class pos {
	int x, y;
	char status;

	public pos(int x, int y, char status) {
		super();
		this.x = x;
		this.y = y;
		this.status = status;
	}
}
