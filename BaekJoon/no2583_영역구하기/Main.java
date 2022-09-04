package BaekJoon.no2583_영역구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static int[][] map;
	static int row, col;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		visited = new boolean[row][col];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			paint(sx, sy, ex, ey);
		}

		int total = 0;
		List<Integer> area = new ArrayList<>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j] == 0 && !visited[i][j]) {
					++total;
					area.add(visit(i, j));
				}
			}
		}
		Collections.sort(area);

		sb.append(total + "\n");
		for (int i : area)
			sb.append(i + " ");
		
		System.out.print(sb.toString());
		br.close();
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static int visit(int x, int y) {
		int cnt = 1;

		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { x, y });
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int cx = cur[0] + dx[d];
				int cy = cur[1] + dy[d];

				if (cx < 0 || cx >= row || cy < 0 || cy >= col || map[cx][cy] != 0 || visited[cx][cy])
					continue;

				visited[cx][cy] = true;
				q.add(new int[] { cx, cy });
				++cnt;
			}
		}

		return cnt;
	}

	private static void paint(int sx, int sy, int ex, int ey) {
		for (int i = sx; i < ex; i++) {
			for (int j = sy; j < ey; j++)
				map[i][j] = 1;
		}
	}
}
