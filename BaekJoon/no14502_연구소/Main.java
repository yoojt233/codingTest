package BaekJoon.no14502_연구소;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int row, col, max;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static List<pos> space;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		max = Integer.MIN_VALUE;
		map = new int[row][col];
		space = new ArrayList<pos>();

		// 맵 구현
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if (temp == 0)
					space.add(new pos(i, j));
			}
		}

		defense(0, 0, new pos[3]);

		System.out.print(max);
		br.close();
	}

	private static void defense(int cnt, int start, pos[] sel) {
		if (cnt == 3) {
			map[sel[0].x][sel[0].y] = 1;
			map[sel[1].x][sel[1].y] = 1;
			map[sel[2].x][sel[2].y] = 1;
			max = Integer.max(max, spread(new int[row][col]));
			map[sel[0].x][sel[0].y] = 0;
			map[sel[1].x][sel[1].y] = 0;
			map[sel[2].x][sel[2].y] = 0;
			return;
		}

		for (int i = start; i < space.size(); i++) {
			sel[cnt] = space.get(i);
			defense(cnt + 1, i + 1, sel);
		}

	}

	private static int spread(int[][] lab) {
		boolean[][] visited = new boolean[row][col];

		for (int i = 0; i < row; i++)
			lab[i] = map[i].clone();

		int cnt = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (lab[i][j] == 2 && !visited[i][j]) {
					Queue<pos> q = new LinkedList<pos>();
					q.offer(new pos(i, j));
					visited[i][j] = true;

					while (!q.isEmpty()) {
						pos cur = q.poll();
						for (int d = 0; d < 4; d++) {
							int cx = cur.x + dx[d];
							int cy = cur.y + dy[d];
							if (cx >= 0 && cx < row && cy >= 0 && cy < col && lab[cx][cy] == 0) {
								lab[cx][cy] = 2;
								visited[cx][cy] = true;
								cnt++;
								q.offer(new pos(cx, cy));
							}
						}
					}
				}
			}
		}

		// 전체 0 구역 - 감연된 0 구역 - 벽이 된 0 구역
		return space.size() - cnt - 3;
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