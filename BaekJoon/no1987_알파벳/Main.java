package BaekJoon.no1987_알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] board;
	static int R, C, answer;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		answer = 1;

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		dfs(0, 0, 0, new boolean[26]);
		System.out.println(answer);
		br.close();
	}

	private static void dfs(int cnt, int x, int y, boolean[] alphabet) {
		if (alphabet[board[x][y] - 'A'])
			return;

		alphabet[board[x][y] - 'A'] = true;
		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			if (cx >= 0 && cx < R && cy >= 0 && cy < C) {
				dfs(cnt + 1, cx, cy, alphabet);
			}
			answer = Math.max(answer, cnt + 1);
		}
		alphabet[board[x][y] - 'A'] = false;
	}
}
