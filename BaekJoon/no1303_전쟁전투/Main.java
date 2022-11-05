package BaekJoon.no1303_전쟁전투;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char[][] map;
	static int[] ans;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		for (int i = 0; i < N; ++i)
			map[i] = br.readLine().toCharArray();

		ans = new int[2];

		visited = new boolean[N][M];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (visited[i][j])
					continue;
				bfs(map[i][j], i, j);
			}
		}

		System.out.printf("%d %d", ans[0], ans[1]);
		br.close();
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void bfs(char ch, int r, int c) {
		int cnt = 1;
		Queue<pos> q = new LinkedList<>();
		visited[r][c] = true;
		q.add(new pos(r, c));

		while (!q.isEmpty()) {
			pos cur = q.poll();
			for (int d = 0; d < 4; ++d) {
				int cr = cur.r + dx[d];
				int cc = cur.c + dy[d];

				if (cr < 0 || cr >= N || cc < 0 || cc >= M || visited[cr][cc] || ch != map[cr][cc])
					continue;

				visited[cr][cc] = true;
				++cnt;
				q.add(new pos(cr, cc));
			}
		}

		if (ch == 'W')
			ans[0] += cnt * cnt;
		else
			ans[1] += cnt * cnt;
	}
}

class pos {
	int r, c;

	public pos(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
