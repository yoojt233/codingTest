package BaekJoon.no17141_연구소2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans;
	static List<pos>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new List[3];

		// 0: 빈 칸(empty), 1: 벽(wall), 2: 바이러스 칸(virus)
		for (int i = 0; i < 3; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				switch (Integer.parseInt(st.nextToken())) {
				case 0:
					list[0].add(new pos(i, j));
					break;
				case 1:
					list[1].add(new pos(i, j));
					break;
				case 2:
					list[2].add(new pos(i, j));
					list[0].add(new pos(i, j)); // 바이러스 칸도 빈 칸이 될 수 있다.
					break;
				}
			}
		}

		// N * N 행렬에서 최대값은 N * N이므로 초기 ans 값을 불가능한 값으로 초기화
		ans = N * N + 1;

		// 조합
		combo(0, 0, new pos[M]);

		// ans 값이 그대로라면 모든 칸 불가능
		if (ans >= N * N)
			System.out.print(-1);
		else
			System.out.print(ans);
		br.close();
	}

	// 몇 번째 인덱스? 탐색 시작 지점? 바이러스를 놓을 칸?
	private static void combo(int cnt, int op, pos[] sel) {

		// 바이러스 놓을 위치 지정 완료
		if (cnt == M) {
			boolean[][] map = new boolean[N][N];
			for (pos p : list[1]) // 벽
				map[p.x][p.y] = true;

			// 바이러스 확산
			bfs(map, sel);
			return;
		}

		// 바이러스 놓을 위치 선택
		for (int i = op; i < list[2].size(); i++) {
			sel[cnt] = list[2].get(i);
			combo(cnt + 1, i + 1, sel);
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void bfs(boolean[][] cmap, pos[] sel) {
		int time = 0; // 확산 시간

		Queue<pos> q = new LinkedList<pos>();

		// 바이러스 위치 Queue 삽입
		for (pos p : sel) {
			cmap[p.x][p.y] = true;
			q.add(p);
		}

		while (!q.isEmpty()) {

			// ans 값보다 크거나 같다면 이미 최솟값 갱신 불가능
			if (time - 1 >= ans)
				return;

			int size = q.size(); // 트리 레벨

			for (int i = 0; i < size; i++) {
				pos cur = q.poll();

				for (int d = 0; d < 4; d++) {
					int cx = cur.x + dx[d];
					int cy = cur.y + dy[d];

					// 범위 이탈, 벽 혹은 방문 여부
					if (cx < 0 || cx >= N || cy < 0 || cy >= N || cmap[cx][cy])
						continue;
					cmap[cx][cy] = true;
					q.add(new pos(cx, cy));
				}
			}
			time++;
		}

		if (check(cmap))
			ans = time - 1;
	}

	// 바이러스가 없는 빈 칸이 탐색
	private static boolean check(boolean[][] cmap) {
		for (pos p : list[0]) {
			if (!cmap[p.x][p.y])
				return false;
		}
		return true;
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