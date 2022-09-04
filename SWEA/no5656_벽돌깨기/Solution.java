package SWEA.no5656_벽돌깨기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N, W, H, min;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 발사 가능 횟수
			W = Integer.parseInt(st.nextToken()); // 열
			H = Integer.parseInt(st.nextToken()); // 행
			int[][] graph = new int[H][W]; // 초기 배열
			map = new int[H][W]; // 변경될 배열

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					int x = Integer.parseInt(st.nextToken());
					graph[i][j] = map[i][j] = x;
				}
			}

			min = Integer.MAX_VALUE;
			permu(0, new int[N], graph);

			sb.append("#").append(t).append(" ").append(min).append("\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static void permu(int cnt, int[] where, int[][] graph) {
		if (cnt == N) {
			for (int i = 0; i < H; i++)
				map[i] = graph[i].clone();

			for (int i = 0; i < N; i++)
				bfs(where[i]);
			min = Math.min(min, getCnt());
			return;
		}

		for (int i = 0; i < W; i++) {
			if (min == 0)
				continue;
			where[cnt] = i;
			permu(cnt + 1, where, graph);
		}
	}

	private static int getCnt() {
		int cnt = 0;
		for (int[] m : map)
			for (int i : m)
				if (i != 0)
					cnt++;

		return cnt;
	}

	private static void bfs(int n) {
		int idx = 0;
		for (int i = 0; i < H; i++)
			if (map[i][n] != 0) {
				idx = i;
				break;
			}

		// 벽돌 뿌수기
		Queue<pos> q = new LinkedList<pos>();
		q.offer(new pos(idx, n));
		while (!q.isEmpty()) {
			pos cur = q.poll();
			int len = map[cur.x][cur.y] - 1;
			map[cur.x][cur.y] = 0;

			for (int j = 1; j <= len; j++) {
				for (int i = 0; i < 4; i++) {
					int cx = cur.x + dx[i] * j;
					int cy = cur.y + dy[i] * j;
					if (cx >= 0 && cx < H && cy >= 0 && cy < W && map[cx][cy] != 0)
						q.offer(new pos(cx, cy));
				}
			}
		}

		// 벽돌 밑으로 이동
		getDown();

	}

	private static void getDown() {
		for (int j = 0; j < W; j++) {
			for (int i = H - 1; i >= 0; i--) {
				if (map[i][j] != 0) {
					int temp = map[i][j];
					map[i][j] = 0;
					move(i, j, temp);
				}
			}
		}
	}

	private static void move(int x, int y, int temp) {
		while (map[x][y] == 0) {
			x++;
			if (x >= H)
				break;
		}
		map[x - 1][y] = temp;
	}
}

class pos {
	int x, y;

	public pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}