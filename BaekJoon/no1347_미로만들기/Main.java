package BaekJoon.no1347_미로만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
	static int N, row_min, row_max, col_min, col_max;
	static HashSet<pos> path;
	static String order;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		order = br.readLine();

		row_min = 0;
		row_max = 0;
		col_min = 0;
		col_max = 0;

		path = new HashSet<>();
		getMatrix();
		map = new char[Math.abs(row_max - row_min) + 1][Math.abs(col_max - col_min) + 1];
		init();

		for (pos p : path) {
			int cx = p.x - row_min;
			int cy = p.y - col_min;
			map[cx][cy] = '.';
		}

		for (int i = 0; i < map.length; ++i) {
			for (int j = 0; j < map[i].length; ++j)
				sb.append(map[i][j]);
			sb.append("\n");
		}

		System.out.print(sb);
		br.close();
	}

	private static void init() {
		for (int i = 0; i < map.length; ++i)
			Arrays.fill(map[i], '#');
	}

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	private static void getMatrix() {
		pos cur = new pos(0, 0);
		path.add(cur);

		int d = 0;
		for (int i = 0; i < N; ++i) {
			switch (order.charAt(i)) {
			case 'F':
				cur = new pos(cur.x + dx[d], cur.y + dy[d]);
				break;
			case 'L':
				d -= 1;
				if (d < 0)
					d = 3;
				break;
			case 'R':
				d = (d + 1) % 4;
				break;
			}
			path.add(cur);

			row_min = Math.min(row_min, cur.x);
			row_max = Math.max(row_max, cur.x);
			col_min = Math.min(col_min, cur.y);
			col_max = Math.max(col_max, cur.y);
		}
	}
}

class pos {
	int x, y;

	public pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}