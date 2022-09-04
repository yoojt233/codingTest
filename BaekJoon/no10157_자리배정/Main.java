package BaekJoon.no10157_자리배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 우로 90도 회전. R과 C값도 변경되야 한다.
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		int[][] map = new int[R][C];

		int x = 0;
		int y = 0;
		if (K > R * C)
			System.out.print(0);
		else {
			int dir = 0;
			int idx = 1;
			int[] dx = { 0, 1, 0, -1 }; // 우 하 좌 상
			int[] dy = { 1, 0, -1, 0 };

			while (idx < K) {
				map[x][y] = idx++;
				x += dx[dir];
				y += dy[dir];

				// 범위 이탈 및 다른 숫자를 만나면 방향 전환
				if (x < 0 || x >= R || y < 0 || y >= C || map[x][y] != 0) {
					x -= dx[dir];
					y -= dy[dir];
					dir = (dir + 1) % 4;
					x += dx[dir];
					y += dy[dir];
				}
			}
			sb.append(x + 1).append(" ").append(y + 1);
			System.out.print(sb.toString());
		}
		br.close();
	}
}
