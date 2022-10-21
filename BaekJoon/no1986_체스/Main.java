package BaekJoon.no1986_체스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];

		ArrayList<pos>[] piece = new ArrayList[3];
		for (int i = 0; i < 3; ++i)
			piece[i] = new ArrayList<>();

		int x = 0;
		for (int i = 0; i < 3; ++i) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());

			for (int j = 0; j < x; ++j) {
				int r = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken()) - 1;
				map[r][c] = true;
				piece[i].add(new pos(r, c));
			}
		}

		for (int i = 0; i < 3; ++i) {
			ArrayList<pos> list = piece[i];
			switch (i) {
			case 0:
				queen(list);
				break;
			case 1:
				knight(list);
				break;
			default:
				break;
			}
		}

		int ans = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (!map[i][j])
					++ans;
			}
		}

		System.out.print(ans);
		br.close();
	}

	static int[] kx = { -2, -2, -1, 1, 2, 2, 1, -1 };
	static int[] ky = { -1, 1, 2, 2, 1, -1, -2, -2 };

	private static void knight(ArrayList<pos> list) {
		for (pos k : list) {
			for (int d = 0; d < 8; ++d) {
				int r = k.r + kx[d];
				int c = k.c + ky[d];

				if (r < 0 || r >= N || c < 0 || c >= M)
					continue;
				map[r][c] = true;
			}
		}
	}

	static int[] qx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] qy = { -1, 0, 1, 1, 1, 0, -1, -1 };

	private static void queen(ArrayList<pos> list) {
		ArrayList<pos> possible = new ArrayList<>();
		for (pos q : list) {
			for (int d = 0; d < 8; ++d) {
				int r = q.r;
				int c = q.c;
				while (true) {
					r += qx[d];
					c += qy[d];

					if (r < 0 || r >= N || c < 0 || c >= M || map[r][c])
						break;

					possible.add(new pos(r, c));
				}
			}
		}
		for (pos p : possible)
			map[p.r][p.c] = true;
	}
}

class pos {
	int r, c;

	public pos(int r, int c) {
		this.r = r;
		this.c = c;
	}
}