package BaekJoon.no2468_안전영역;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
	static int max = 1;
	static int[][] map, cop;
	static int[] safety;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		cop = new int[N][N];

		// 맵 구현
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				low = Math.min(low, temp); // 가장 낮은 영역
				high = Math.max(high, temp); // 가장 높은 영역
				map[i][j] = temp;
			}
		}

		safety = new int[high + 1]; // 각 높이마다 안전 영역 저장

		for (int i = 0; i <= high; i++) {

			if (i < low - 1) {
//				safety[i] = 1;
				continue;
			}

			// 값을 변경할 map
			for (int j = 0; j < N; j++)
				cop[j] = map[j].clone();

			rained(i);
//			safety[i] = bfs();
			max = Integer.max(max, bfs());
		}

		// safety에서 가장 큰 값 출력
//		System.out.print(Arrays.stream(safety).max().getAsInt());
		System.out.print(max);
		br.close();
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static int bfs() {
		boolean[][] visited = new boolean[N][N];
		int area = 0;

		// 시작 지점 찾아서
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				// bfs 시작
				if (cop[i][j] != 0 && !visited[i][j]) {
					Queue<pos> q = new LinkedList<pos>();
					q.offer(new pos(i, j));
					visited[i][j] = true;

					while (!q.isEmpty()) {
						pos cur = q.poll();
						for (int d = 0; d < 4; d++) {
							int cx = cur.x + dx[d];
							int cy = cur.y + dy[d];

							if (cx < 0 || cx >= N || cy < 0 || cy >= N || visited[cx][cy] || cop[cx][cy] == 0)
								continue;

							q.offer(new pos(cx, cy));
							visited[cx][cy] = true;
						}
					}

					// bfs 한 번 당 안전 영역 1개
					area++;
				}
			}
		}
		return area;
	}

	private static void rained(int level) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cop[i][j] <= level)
					cop[i][j] = 0;
			}
		}
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
