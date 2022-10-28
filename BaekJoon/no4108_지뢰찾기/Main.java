package BaekJoon.no4108_지뢰찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			if (N == 0 && M == 0)
				break;

			char[][] map = new char[N][M];
			ArrayList<pos> mine = new ArrayList<>();
			for (int i = 0; i < N; ++i) {
				String cur = br.readLine();
				for (int j = 0; j < M; ++j) {
					map[i][j] = cur.charAt(j);
					if (map[i][j] == '*')
						mine.add(new pos(i, j));
				}
			}

			int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
			int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

			for (pos p : mine) {
				for (int d = 0; d < 8; ++d) {
					int r = p.r + dx[d];
					int c = p.c + dy[d];

					if (r < 0 || r >= N || c < 0 || c >= M || map[r][c] == '*')
						continue;

					if (map[r][c] == '.')
						map[r][c] = '1';
					else
						map[r][c] += 1;
				}
			}

			for (char[] arr : map) {
				for (char c : arr) {
					if (c != '.')
						sb.append(c);
					else
						sb.append(0);
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
		br.close();
	}
}

class pos {
	int r, c;

	public pos(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
