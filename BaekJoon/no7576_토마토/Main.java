package BaekJoon.no7576_토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N, day;
	static int[][] box;
	static int[][] check;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Queue<coordinate> tomato;

	public static void main(String[] args) throws IOException {

		input(); // data 값 입력

		bfs(); // 4방탐색 이후 1증가

		HowLong();

		if (HowLong())
			System.out.println(day - 1);
		else
			System.out.println(-1);
	}

	private static boolean HowLong() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (check[i][j] >= day)
					day = check[i][j];
				if (check[i][j] == 0 && box[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	private static void bfs() {
		while (!tomato.isEmpty()) {
			int cnt = tomato.size();
			while (cnt-- > 0) {
				coordinate current = tomato.poll();
				int x = current.x;
				int y = current.y;

				for (int i = 0; i < 4; i++) {
					int cx = x + dx[i];
					int cy = y + dy[i];
					if (cx < 0 || cx >= N || cy < 0 || cy >= M || box[cx][cy] == -1 || check[cx][cy] > 0)
						continue;
					check[cx][cy] = check[x][y] + 1;
					tomato.offer(new coordinate(cx, cy));
				}
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer mn = new StringTokenizer(br.readLine());

		M = Integer.parseInt(mn.nextToken());
		N = Integer.parseInt(mn.nextToken());
		tomato = new ArrayDeque<coordinate>();

		day = -1;
		box = new int[N][M];
		check = new int[N][M];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					tomato.offer(new coordinate(i, j));
					check[i][j] = 1;
				}
			}
		}
	}
}

class coordinate {
	int x, y;

	public coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
