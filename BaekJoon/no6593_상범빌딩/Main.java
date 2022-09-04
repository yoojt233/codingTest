package BaekJoon.no6593_상범빌딩;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int L, R, C;
	static char[][][] map;
	static boolean[][][] visited;
	static pos start, end;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		input(br.readLine());
		while (!isEnd()) {
			map = new char[L][R][C]; // 층 행 렬
			visited = new boolean[L][R][C];

			// map 생성
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String line = br.readLine();
					for (int k = 0; k < C; k++) {
						char temp = line.charAt(k);
						map[i][j][k] = temp;

						// 시작 지점과 끝 지점 저장
						if (temp == 'S')
							start = new pos(i, j, k, 0);
						else if (temp == 'E')
							end = new pos(i, j, k, 0);
					}
				}
				br.readLine();
			}

			int x = bfs();
			if (x == Integer.MAX_VALUE)
				sb.append("Trapped!\n");
			else
				sb.append("Escaped in " + x + " minute(s).\n");

			input(br.readLine());
		}

		System.out.print(sb.toString());
		br.close();
	}

	// 동 서 남 북 상 하
	static int[] dx = { 0, 0, 1, -1, 0, 0 };
	static int[] dy = { 1, -1, 0, 0, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };

	private static int bfs() {
		Queue<pos> q = new LinkedList<pos>();
		q.add(start);
		visited[start.z][start.x][start.y] = true;

		while (!q.isEmpty()) {
			pos cur = q.poll();
			for (int i = 0; i < 6; i++) {
				int cz = cur.z + dz[i];
				int cx = cur.x + dx[i];
				int cy = cur.y + dy[i];

				// 경계값, 방문, 벽 체크
				if (cz < 0 || cz >= L || cx < 0 || cx >= R || cy < 0 || cy >= C || visited[cz][cx][cy] || map[cz][cx][cy] == '#')
					continue;

				// 다음 칸이 탈출구라면 return
				if (cz == end.z && cx == end.x && cy == end.y)
					return cur.move + 1;

				q.add(new pos(cz, cx, cy, cur.move + 1));
				visited[cz][cx][cy] = true;
			}
		}

		// 탈출 불가
		return Integer.MAX_VALUE;
	}

	private static boolean isEnd() {

		// 하나라도 0이 아니면 끝이 아니다.
		if (L != 0 || R != 0 || C != 0)
			return false;

		return true;
	}

	private static void input(String string) {
		StringTokenizer st = new StringTokenizer(string);
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
	}
}

class pos {
	int z, x, y, move;

	public pos(int z, int x, int y, int move) {
		this.z = z;
		this.x = x;
		this.y = y;
		this.move = move;
	}
}