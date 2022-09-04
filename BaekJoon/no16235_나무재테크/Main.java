package BaekJoon.no16235_나무재테크;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, target;
	static land[][] map;
	static int[][] plus;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());

		plus = new int[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j)
				plus[i][j] = Integer.parseInt(st.nextToken());
		}

		map = new land[N][N];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				map[i][j] = new land(5, new PriorityQueue<Integer>());
			}
		}

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());

			map[x][y].tree.add(age);
		}

		while (target-- > 0)
			flow();

		int ans = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j)
				ans += map[i][j].tree.size();
		}

		System.out.print(ans);
		br.close();
	}

	private static void flow() {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (map[i][j].tree.isEmpty())
					continue;

				land pos = map[i][j];
				feed(pos);
			}
		}

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (map[i][j].tree.isEmpty())
					continue;

				for (int age : map[i][j].tree) {
					if (age % 5 == 0)
						seed(i, j);
				}
			}
		}

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j)
				map[i][j].vitamin += plus[i][j];
		}
	}

	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

	private static void seed(int x, int y) {
		for (int d = 0; d < 8; ++d) {
			int cx = x + dx[d];
			int cy = y + dy[d];

			if (cx < 0 || cx >= N || cy < 0 || cy >= N)
				continue;

			map[cx][cy].tree.add(1);
		}
	}

	private static void feed(land pos) {
		int die = 0;
		PriorityQueue<Integer> next = new PriorityQueue<>();

		while (!pos.tree.isEmpty()) {
			int cur = pos.tree.poll();
			if (pos.vitamin >= cur) {
				pos.vitamin -= cur;
				next.add(++cur);
			} else
				die += cur / 2;
		}

		pos.vitamin += die;
		pos.tree = next;
	}
}

class land {
	int vitamin;
	PriorityQueue<Integer> tree;

	public land(int vitamin, PriorityQueue<Integer> tree) {
		this.vitamin = vitamin;
		this.tree = tree;
	}
}