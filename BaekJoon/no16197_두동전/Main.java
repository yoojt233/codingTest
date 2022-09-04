package BaekJoon.no16197_두동전;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char[][] map;
	static pos[] coin = new pos[2];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		int idx = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				char temp = str.charAt(j);
				if (temp == 'o') // 동전!
					coin[idx++] = new pos(i, j, 1);
				map[i][j] = temp;
			}
		}

		System.out.println(bfs());
		br.close();
	}

	private static int bfs() {
		Queue<pos> q = new LinkedList<pos>();
		q.offer(coin[0]);
		q.offer(coin[1]);

		while (!q.isEmpty()) {
			pos coin1 = q.poll();
			pos coin2 = q.poll();

			// 횟수 초과
			if (coin1.move > 10)
				return -1;

			for (int d = 0; d < 4; d++) {
				boolean[] flag = new boolean[2];

				// 동전1 이동
				int cx1 = coin1.x + dx[d];
				int cy1 = coin1.y + dy[d];

				// 동전2 이동
				int cx2 = coin2.x + dx[d];
				int cy2 = coin2.y + dy[d];

				flag[0] = isOut(cx1, cy1);
				flag[1] = isOut(cx2, cy2);

				// 두 동전 모두 낙
				if (flag[0] && flag[1])
					continue;

				// 한 동전만 낙
				if ((flag[0] && !flag[1]) || (!flag[0] && flag[1]))
					return coin1.move;

				// coin1 벽
				if (map[cx1][cy1] == '#') {
					cx1 -= dx[d];
					cy1 -= dy[d];
				}

				// coin2 벽
				if (map[cx2][cy2] == '#') {
					cx2 -= dx[d];
					cy2 -= dy[d];
				}

				q.offer(new pos(cx1, cy1, coin1.move + 1));
				q.offer(new pos(cx2, cy2, coin2.move + 1));
			}
		}

		// 불가능
		return -1;
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// 낙 판정
	private static boolean isOut(int cx, int cy) {
		if (cx < 0 || cx >= N || cy < 0 || cy >= M)
			return true;

		return false;
	}
}

// 위치 클래스
class pos {
	int x, y, move;

	public pos(int x, int y, int move) {
		super();
		this.x = x;
		this.y = y;
		this.move = move;
	}
}