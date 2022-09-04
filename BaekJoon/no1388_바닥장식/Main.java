package BaekJoon.no1388_바닥장식;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int row, col;
	static char[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new char[row][col];
		visited = new boolean[row][col];

		for (int i = 0; i < row; i++)
			map[i] = br.readLine().toCharArray();

		int total = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (!visited[i][j]) {
					++total;
					visit(i, j);
				}
			}
		}

		System.out.print(total);
		br.close();
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void visit(int x, int y) {
		visited[x][y] = true;

		int cx = 0;
		int cy = 0;
		if (map[x][y] == '|') {
			for (int d = 0; d < 2; d++) {
				cx = x + dx[d];
				cy = y + dy[d];

				if (cx < 0 || cx >= row || visited[cx][cy] || map[x][y] != map[cx][cy])
					continue;
				visit(cx, cy);
			}
		} else {
			for (int d = 2; d < 4; d++) {
				cx = x + dx[d];
				cy = y + dy[d];

				if (cy < 0 || cy >= col || visited[cx][cy] || map[x][y] != map[cx][cy])
					continue;
				visit(cx, cy);
			}
		}
	}
}
