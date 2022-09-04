package BaekJoon.no3109_빵집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, answer;
	static char[][] map;
	static int[] dx = { -1, 0, 1 };
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		check = new boolean[R];
		// map data
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		// 시작 위치 찾기
		int x = 0;
		for (int i = 0; i < R; i++) {
			if (map[i][0] == '.') {
				x = i;
				setPipe(x, 0, x);
			}
		}
		System.out.println(answer);
	}

	private static void setPipe(int x, int y, int w) {
		if (y == C - 1) {
			check[w] = true;
			answer++;
			return;
		}

		for (int i = 0; i < 3; i++) {
			if (check[w] == true)
				return;
			int cx = x + dx[i];
			int cy = y + 1;
			if (cx >= 0 && cx < R && cy >= 0 && cy < C) {
				if (map[cx][cy] == '.') {
					map[cx][cy] = 'x';
					setPipe(cx, cy, w);
				}
			}
		}
	}
}
