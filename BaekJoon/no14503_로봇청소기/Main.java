package BaekJoon.no14503_로봇청소기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int row, col, r, c, dir;

	// 북, 서, 남, 동
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 맵, 방문
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];

		// 시작 위치, 시작 방향
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		if (dir == 1 || dir == 3)
			dir = (dir + 2) % 4;

		// 맵 구현
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		map[r][c] = 2; // 처음 위치
		
		// 방향 및 후진 체크
		while (!isFinished(r, c, dir))
			map[r][c] = 2; // 방문 체크

		System.out.print(isClean());
		br.close();
	}

	private static int isClean() {
		int cnt = 0;
		for (int[] a : map) {
			for (int i : a)
				if (i == 2)
					cnt++;
		}

		return cnt;
	}

	private static boolean isFinished(int x, int y, int d) {

		// 사방 중 청소 안된 곳 존재
		for (int i = 1; i < 5; i++) {
			d = (dir + i) % 4;
			int cr = x + dx[d];
			int cc = y + dy[d];
			if (cr >= 0 && cr < row && cc >= 0 && cc < col && map[cr][cc] == 0) {
				dir = d;
				r = cr;
				c = cc;
				return false;
			}
		}

		// 후진 가능
		int cd = (dir + 2) % 4; // 뒷 방향
		int cr = x + dx[cd];
		int cc = y + dy[cd];
		if (map[cr][cc] != 1) {
			r = cr;
			c = cc;
			return false;
		}

		// 사방이 벽이거나 청소되어 있고 후진 불가능
		return true;
	}
}
