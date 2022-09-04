package BaekJoon.no11559_PuyoPuyo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 1. bfs 시작 위치 탐색
// 2. 연결된 size가 4보다 크면 삭제
// 3. 각 열의 아래에서 보다 위에 블럭이 있는지 확인

public class Main {
	static char[][] map;
	static boolean[][] visited;
	static List<pos> bomb;
	static int ans;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[12][6];
		bomb = new ArrayList<>();
		ans = 0;

		for (int i = 0; i < 12; i++)
			map[i] = br.readLine().toCharArray();

		// 1 라운드
		puyo();

		System.out.print(ans);
		br.close();
	}

	private static void puyo() {
		visited = new boolean[12][6];

		for (int r = 0; r < 12; r++) {
			for (int c = 0; c < 6; c++) {
				if (map[r][c] == '.' || visited[r][c])
					continue;

				bfs(r, c, new ArrayList<pos>());
			}
		}

		// 비어있으면 게임 종료
		if (bomb.isEmpty())
			return;
		else {
			ans++;
			delete();

			for (int c = 0; c < 6; c++) {
				for (int r = 11; r > 0; r--) {
					if (map[r][c] != '.')
						continue;

					getDown(r, c);
				}
			}

			puyo();
		}
	}

	// 블럭 내려
	private static void getDown(int r, int c) {
		for (int i = r - 1; i >= 0; i--) {
			if (map[i][c] != '.') {
				map[r][c] = map[i][c];
				map[i][c] = '.';
				return;
			}
		}
	}

	// 빠요~ 엔!
	private static void delete() {
		for (pos p : bomb)
			map[p.x][p.y] = '.';

		bomb.clear();
	}

	private static void bfs(int r, int c, ArrayList<pos> sel) {
		Queue<pos> q = new LinkedList<>();
		q.offer(new pos(r, c));
		sel.add(new pos(r, c)); // 이어진 블럭
		visited[r][c] = true;

		while (!q.isEmpty()) {
			pos cur = q.poll();
			char color = map[cur.x][cur.y];

			for (int d = 0; d < 4; d++) {
				int cx = cur.x + dx[d];
				int cy = cur.y + dy[d];

				// 경계 이탈, 재방문, 다른 블럭
				if (cx < 0 || cx >= 12 || cy < 0 || cy >= 6 || visited[cx][cy] || map[cx][cy] != color)
					continue;

				q.offer(new pos(cx, cy));
				sel.add(new pos(cx, cy));
				visited[cx][cy] = true;
			}
		}

		// 4개 이상 연결되어 있다면 bomb에 추가
		if (sel.size() > 3) {
			for (pos p : sel)
				bomb.add(p);
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