package BaekJoon.no16985_Maaaaaaaaaze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][][] plates;

	static int[] dx = { -1, 1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		plates = new int[5][5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 5; k++)
					plates[i][j][k] = Integer.parseInt(st.nextToken());
			}
		}

		// 판때기를 쌓을 순서
		permu(0, new int[5], new boolean[5]);

		// 출력
		if (min > 125)
			System.out.print(-1);
		else
			System.out.print(min);

		br.close();
	}

	// 순열로 판때기 순서 정하기
	private static void permu(int cnt, int[] sel, boolean[] checked) {
		if (cnt == 5) {
			int[][][] map = new int[5][5][5];

			// 각각 4번씩 회전시켜서 bfs 탐색
			for (int a = 0; a < 5; a++) {
				map[0] = turn(sel[0]);
				for (int b = 0; b < 5; b++) {
					map[1] = turn(sel[1]);
					for (int c = 0; c < 5; c++) {
						map[2] = turn(sel[2]);
						for (int d = 0; d < 5; d++) {
							map[3] = turn(sel[3]);
							for (int e = 0; e < 5; e++) {
								map[4] = turn(sel[4]);
								bfs(map);
							}
						}
					}
				}
			}
			return;
		}

		for (int i = 0; i < 5; i++) {
			if (checked[i])
				continue;
			sel[cnt] = i;
			checked[i] = true;
			permu(cnt + 1, sel, checked);
			checked[i] = false;
		}
	}

	// 판때기 좌향 좌
	private static int[][] turn(int n) {
		int[][] after = new int[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++)
				after[4 - j][i] = plates[n][i][j];
		}

		plates[n] = after;
		return after;
	}

	// bfs 탐색
	static void bfs(int[][][] map) {

		// 출발 및 도착 지점이 입장 불가한 경우
		if (map[0][0][0] == 0 || map[4][4][4] == 0)
			return;

		boolean[][][] visited = new boolean[5][5][5];

		Queue<pos> q = new LinkedList<pos>();
		q.add(new pos(0, 0, 0, 0));
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			pos cur = q.poll(); // 현재 위치

			// 이미 최소보다 많이 움직였다면 더 이상 탐색이 무의미
			if (cur.move >= min)
				break;

			for (int d = 0; d < 6; d++) {

				int cx = cur.x + dx[d];
				int cy = cur.y + dy[d];
				int cz = cur.z + dz[d];

				// 경계값, 방문 여부, 출입 불가
				if (cz < 0 || cz >= 5 || cx < 0 || cx >= 5 || cy < 0 || cy >= 5 || visited[cz][cx][cy] || map[cz][cx][cy] == 0)
					continue;

				// 다음 이동이 도착 지점일 경우
				if (cx == 4 && cy == 4 && cz == 4) {
					min = cur.move + 1;
					return;
				}

				q.add(new pos(cx, cy, cz, cur.move + 1));
				visited[cz][cx][cy] = true;
			}
		}
	}
}

class pos {
	int x, y, z, move;

	public pos(int x, int y, int z, int move) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.move = move;
	}
}