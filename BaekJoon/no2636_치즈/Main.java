package BaekJoon.no2636_치즈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map, before;
	static boolean[][] checked;
	static int row, col;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		map = new int[row][col];
		before = new int[row][col];

		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		int hour = 0;
		while (getCheese(map) != 0) {
			for (int i = 0; i < row; i++)
				before[i] = map[i].clone();

			checked = new boolean[row][col];
			checked[0][0] = true;

			bfs(new pos(0, 0));
			hour++;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(hour).append("\n").append(getCheese(before));
		System.out.print(sb.toString());
		br.close();
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void bfs(pos pos) {
		Queue<pos> q = new LinkedList<pos>();
		q.offer(pos);
		while (!q.isEmpty()) {
			pos temp = q.poll();
			for (int i = 0; i < 4; i++) {
				int cx = temp.x + dx[i];
				int cy = temp.y + dy[i];
				if (cx >= 0 && cx < row && cy >= 0 && cy < col && !checked[cx][cy]) {
					if (map[cx][cy] == 1) {
						map[cx][cy] = 0;
						checked[cx][cy] = true;
					}
					if (map[cx][cy] == 0) {
						q.offer(new pos(cx, cy));
						checked[cx][cy] = true;
					}
				}
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j] == 2)
					map[i][j] = 0;
			}
		}
	}

	private static int getCheese(int[][] cheese) {
		int cnt = 0;
		for (int[] i : cheese)
			for (int j : i)
				if (j == 1)
					cnt++;
		return cnt;
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
