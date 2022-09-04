package BaekJoon.no1926_그림;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char[][] back;
	static int MAX, area;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer nm = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(nm.nextToken());
		M = Integer.parseInt(nm.nextToken());
		MAX = 0;
		int cnt = 0;
		
		back = new char[N][M];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				back[i][j] = st.nextToken().charAt(0);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (back[i][j] == '1') {
					area = 1;
					checkPaint(i, j);
					cnt++;
				}
			}
		}
		System.out.printf("%d\n%d", cnt, MAX);
	}

	private static void checkPaint(int x, int y) {
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		back[x][y] = '2';

		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			if (cx >= 0 && cy >= 0 && cx < N && cy < M && back[cx][cy] == '1') {
				area++;
				checkPaint(cx, cy);
			}
			MAX = Math.max(MAX, area);
		}
	}
}
