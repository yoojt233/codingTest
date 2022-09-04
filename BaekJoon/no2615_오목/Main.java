package BaekJoon.no2615_오목;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new String[19][19];

		for (int i = 0; i < 19; i++)
			map[i] = br.readLine().split(" ");

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (map[i][j].equals("1") || map[i][j].equals("2")) {
					for (int dir = 0; dir < 4; dir++) {
						if (check(0, i, j, map[i][j], dir) == 5 && reverse(i, j, map[i][j], dir)) {
							System.out.printf("%s\n%d %d", map[i][j], i + 1, j + 1);
							System.exit(0);
						}
						max = 0;
					}
				}
			}
		}
		System.out.print(0);
		br.close();
	}

	static int[] dx = { 1, 0, -1, 1 };
	static int[] dy = { 0, 1, 1, 1 };
	static int max = 0;

	private static boolean reverse(int x, int y, String val, int dir) {
		int cx = x - dx[dir];
		int cy = y - dy[dir];
		if (cx >= 0 && cx < 19 && cy >= 0 && cy < 19 && map[cx][cy].equals(val))
			return false;
		return true;
	}

	private static int check(int cnt, int x, int y, String val, int dir) {
		max = Math.max(cnt, max);

		int cx = x + dx[dir];
		int cy = y + dy[dir];
		if (cx >= 0 && cx < 19 && cy >= 0 && cy < 19 && map[cx][cy].equals(val))
			check(cnt + 1, cx, cy, val, dir);

		return max + 1;
	}
}
