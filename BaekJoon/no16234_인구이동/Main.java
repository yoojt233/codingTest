package BaekJoon.no16234_인구이동;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] map;
	static root[] parents;
	static int N, L, R;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		// 국가들을 1차원으로 표현
		map = new int[N * N];
		parents = new root[N * N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i * N + j] = Integer.parseInt(st.nextToken());
		}

		int ans = 0;
		while (true) {

			// 인구 이동이 일어났었는지 체크
			boolean flag = false;
			init();

			for (int i = 0; i < N * N; i++) {
				for (int d = 0; d < 4; d++) {
					int cx = i / N + dx[d]; // 행
					int cy = i % N + dy[d]; // 열
					int next = cx * N + cy; // 1차원으로 표현

					// 범위 이탈, 이미 같은 집합
					if (cx < 0 || cx >= N || cy < 0 || cy >= N || find(i) == find(next))
						continue;

					// 두 국가의 인구 차 검사
					int dif = Math.abs(map[i] - map[next]);
					if (L <= dif && dif <= R) {
						union(i, next);
						flag = true;
					}
				}
			}

			if (flag) {
				++ans; // 인구 이동 횟수 증가
				for (int i = 0; i < N * N; i++) {
					int r = find(i); // 루트
					map[i] = parents[r].sum / parents[r].size;
				}
			} else
				break;
		}

		System.out.print(ans);
		br.close();
	}

	private static void init() {
		for (int i = 0; i < N * N; i++)
			parents[i] = new root(i, map[i], 1);
	}

	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return;

		parents[bRoot].idx = aRoot;
		parents[aRoot].sum += parents[bRoot].sum;
		parents[aRoot].size += parents[bRoot].size;
	}

	private static int find(int x) {
		if (x == parents[x].idx)
			return x;
		return parents[x].idx = find(parents[x].idx);
	}
}

// 인덱스 번호, 인구수 합, 연결된 국가 수
class root {
	int idx, sum, size;

	public root(int idx, int sum, int size) {
		super();
		this.idx = idx;
		this.sum = sum;
		this.size = size;
	}
}
