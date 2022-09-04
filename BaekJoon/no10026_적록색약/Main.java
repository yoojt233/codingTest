package BaekJoon.no10026_적록색약;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] map;
	static boolean[][] checkMe, checkNormal;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		checkMe = new boolean[N][N];
		checkNormal = new boolean[N][N];
		for (int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();

		int normal = 0, me = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!checkNormal[i][j] && map[i][j] == 'G') {
					normalG(i, j);
					normal++;
				} else if (!checkNormal[i][j] && map[i][j] == 'R') {
					normalR(i, j);
					normal++;
				} else if (!checkNormal[i][j] && map[i][j] == 'B') {
					normalB(i, j);
					normal++;
				}

				if (!checkMe[i][j] && map[i][j] != 'B') {
					meRG(i, j);
					me++;
				} else if (!checkMe[i][j] && map[i][j] == 'B') {
					meB(i, j);
					me++;
				}
			}
		}
		System.out.printf("%d %d", normal, me);
		br.close();
	}

	private static void normalG(int x, int y) {
		checkNormal[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			if (cx >= 0 && cx < N && cy >= 0 && cy < N && !checkNormal[cx][cy]) {
				if (map[cx][cy] == 'G')
					normalG(cx, cy);
			}
		}
	}

	private static void normalR(int x, int y) {
		checkNormal[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			if (cx >= 0 && cx < N && cy >= 0 && cy < N && !checkNormal[cx][cy]) {
				if (map[cx][cy] == 'R')
					normalR(cx, cy);
			}
		}
	}

	private static void normalB(int x, int y) {
		checkNormal[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			if (cx >= 0 && cx < N && cy >= 0 && cy < N && !checkNormal[cx][cy]) {
				if (map[cx][cy] == 'B')
					normalB(cx, cy);
			}
		}
	}

	private static void meB(int x, int y) {
		checkMe[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			if (cx >= 0 && cx < N && cy >= 0 && cy < N && !checkMe[cx][cy]) {
				if (map[cx][cy] == 'B')
					meB(cx, cy);
			}
		}
	}

	private static void meRG(int x, int y) {
		checkMe[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			if (cx >= 0 && cx < N && cy >= 0 && cy < N && !checkMe[cx][cy]) {
				if (map[cx][cy] != 'B')
					meRG(cx, cy);
			}
		}
	}
}
