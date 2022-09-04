package BaekJoon.no1600_말이되고픈원숭이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int row, col;
	static int[][] map;
	static boolean[][][] checked;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[] hx = { -2, -2, -1, 1, 2, 2, 1, -1 };
	static int[] hy = { -1, 1, 2, 2, 1, -1, -2, -2 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int k = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		checked = new boolean[k + 1][row][col];

		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<monkey> q = new LinkedList<>();
		q.offer(new monkey(0, 0, 0, 0));
		while (!q.isEmpty()) {
			monkey temp = q.poll();
			if (temp.x == row - 1 && temp.y == col - 1) {
				System.out.print(temp.cnt);
				System.exit(0);
			}

			shin(q, temp);
			if (temp.horse < k)
				ma(q, temp);
		}

		System.out.print("-1");
		br.close();
	}

	private static void shin(Queue<monkey> q, monkey temp) {
		for (int i = 0; i < 4; i++) {
			int cx = temp.x + dx[i];
			int cy = temp.y + dy[i];
			if (cx >= 0 && cy >= 0 && cx < row && cy < col && map[cx][cy] == 0 && !checked[temp.horse][cx][cy]) {
				checked[temp.horse][cx][cy] = true;
				q.offer(new monkey(cx, cy, temp.horse, temp.cnt + 1));
			}
		}
	}

	private static void ma(Queue<monkey> q, monkey temp) {
		for (int i = 0; i < 8; i++) {
			int cx = temp.x + hx[i];
			int cy = temp.y + hy[i];
			if (cx >= 0 && cy >= 0 && cx < row && cy < col && map[cx][cy] == 0 && !checked[temp.horse + 1][cx][cy]) {
				checked[temp.horse + 1][cx][cy] = true;
				q.offer(new monkey(cx, cy, temp.horse + 1, temp.cnt + 1));
			}
		}
	}
}

class monkey {
	int x, y, horse, cnt;

	public monkey(int x, int y, int horse, int cnt) {
		super();
		this.x = x;
		this.y = y;
		this.horse = horse;
		this.cnt = cnt;
	}
}
