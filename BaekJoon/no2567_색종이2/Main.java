package BaekJoon.no2567_색종이2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, ans;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[102][102];

		ans = 0;
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			paint(st.nextToken(), st.nextToken());
		}

		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if (map[i][j] == 1) {
					for (int dir = 0; dir < 4; dir++) {
						int cx = i + dx[dir];
						int cy = j + dy[dir];

						if (map[cx][cy] == 0)
							ans++;
					}
				}
			}
		}

		System.out.print(ans);
		br.close();
	}

	private static void paint(String sx, String sy) {
		int x = Integer.parseInt(sx);
		int y = Integer.parseInt(sy);

		for (int i = x; i < x + 10; i++)
			for (int j = y; j < y + 10; j++)
				map[i][j] = 1;
	}
}
