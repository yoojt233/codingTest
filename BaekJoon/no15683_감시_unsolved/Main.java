package BaekJoon.no15683_감시_unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, answer;
	static char[][] map;
	static List<camera> c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer nm = new StringTokenizer(br.readLine());

		N = Integer.parseInt(nm.nextToken());
		M = Integer.parseInt(nm.nextToken());
		map = new char[N][M];
		answer = Integer.MAX_VALUE;
		c = new LinkedList<camera>();

		// 방 정보 입력
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if ('1' <= map[i][j] && map[i][j] <= '5') {
					c.add(new camera(i, j, map[i][j]));
				}
			}
		}

		On(0, c.get(0).x, c.get(0).y, c.get(0).no);

		System.out.print(answer);
		br.close();
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void On(int cnt, int x, int y, char no) {
		if (cnt == c.size()) {
			answer = Math.min(answer, counting());
			return;
		}

		
	}

	private static void watch(int x, int y, int dir) {
		int cx = x + dx[dir];
		int cy = y + dy[dir];
		while (cx >= 0 && cx < N && cy >= 0 && cy < M && map[cx][cy] != '6') {
			map[cx][cy] = '#';
			cx += dx[dir];
			cy += dy[dir];
		}
	}

	static int counting() {
		int cnt = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (map[i][j] == '0')
					cnt++;

		return cnt;
	}

	static class camera {
		int x, y;
		char no;

		public camera(int x, int y, char no) {
			this.x = x;
			this.y = y;
			this.no = no;
		}
	}
}
