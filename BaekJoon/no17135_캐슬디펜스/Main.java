package BaekJoon.no17135_캐슬디펜스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int row, col, D, max;
	static int[][] map, origin;
	static int[] archer = new int[3];
	static int[] dx = { 0, -1, 0 };
	static int[] dy = { -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		max = Integer.MIN_VALUE;

		map = new int[row][col];
		origin = new int[row][col];
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++)
				origin[i][j] = Integer.parseInt(st.nextToken());
		}

		locate(0, 0);
		System.out.print(max);
		br.close();
	}

	private static void locate(int cnt, int start) {
		if (cnt == 3) {
			for (int i = 0; i < row; i++)
				map[i] = origin[i].clone();

			max = Math.max(max, game());
			return;
		}

		for (int i = start; i < col; i++) {
			archer[cnt] = i;
			locate(cnt + 1, i + 1);
		}
	}

	private static int game() {
		int cnt = 0;
		while (!empty()) {
			for (int i = 0; i < 3; i++)
				attack(i);

			cnt += gotcha();
			flow();
		}
		return cnt;
	}

	private static void attack(int n) {
		boolean[][] visited = new boolean[row][col];
		Queue<int[]> q = new LinkedList<int[]>();

		visited[row - 1][archer[n]] = true;
		q.offer(new int[] { row - 1, archer[n] });
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if ((row - cur[0]) + Math.abs(archer[n] - cur[1]) > D)
				return;

			if (map[cur[0]][cur[1]] != 0) {
				map[cur[0]][cur[1]] = 2;
				return;
			}

			for (int i = 0; i < 3; i++) {
				int cx = cur[0] + dx[i];
				int cy = cur[1] + dy[i];
				if (cx >= 0 && cx < row && cy >= 0 && cy < col && !visited[cx][cy]) {
					visited[cx][cy] = true;
					q.offer(new int[] { cx, cy });
				}
			}
		}
	}

	private static int gotcha() {
		int cnt = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j] == 2) {
					cnt++;
					map[i][j] = 0;
				}
			}
		}
		return cnt;
	}

	private static void flow() {

		// 한 칸 내리기
		for (int i = row - 1; i >= 1; i--)
			map[i] = map[i - 1].clone();

		// 맨 윗 줄 초기화
		map[0] = new int[col];
	}

	private static boolean empty() {

		// 맵에 적이 남아있다면
		for (int[] r : map) {
			for (int i : r) {
				if (i != 0)
					return false;
			}
		}

		return true;
	}
}
