package BaekJoon.no17142_연구소3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] origin;
	static List<pos> viruses, spaces;
	static boolean flag = false;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		origin = new int[N][N];
		viruses = new ArrayList<>();
		spaces = new ArrayList<>();
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				origin[i][j] = Integer.parseInt(st.nextToken());
				if (origin[i][j] == 2)
					viruses.add(new pos(i, j));
				else if (origin[i][j] == 0)
					spaces.add(new pos(i, j));
			}
		}

		if (spaces.size() == 0) {
			flag = true;
			ans = 0;
		} else {
			pos[] sel = new pos[M];
			combo(0, 0, sel);
		}

		System.out.print(flag ? ans : -1);
		br.close();
	}

	private static void combo(int cnt, int start, pos[] sel) {
		if (cnt == M) {
			int[][] map = new int[N][N];
			for (int i = 0; i < N; ++i)
				map[i] = origin[i].clone();

			spread(sel, map, spaces.size());
			return;
		}

		for (int i = start; i < viruses.size(); ++i) {
			sel[cnt] = viruses.get(i);
			combo(cnt + 1, i + 1, sel);
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void spread(pos[] sel, int[][] map, int space) {
		boolean[][] visited = new boolean[N][N];

		Queue<pos> q = new LinkedList<>();
		for (pos p : sel) {
			q.offer(p);
			visited[p.r][p.c] = true;
		}

		int time = 0;
		while (!q.isEmpty()) {
			if (time >= ans)
				return;

			if (space == 0)
				break;

			int size = q.size();
			for (int t = 0; t < size; ++t) {
				pos cur = q.poll();

				for (int d = 0; d < 4; ++d) {
					int cr = cur.r + dx[d];
					int cc = cur.c + dy[d];

					if (cr < 0 || cr >= N || cc < 0 || cc >= N || map[cr][cc] == 1 || visited[cr][cc])
						continue;

					if (map[cr][cc] == 0) {
						map[cr][cc] = 2;
						--space;
					}
					visited[cr][cc] = true;
					q.offer(new pos(cr, cc));
				}
			}
			++time;
		}

		if (space > 0)
			return;

		flag = true;
		ans = time;
	}
}

class pos {
	int r, c;

	public pos(int r, int c) {
		this.r = r;
		this.c = c;
	}
}