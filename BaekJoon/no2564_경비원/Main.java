package BaekJoon.no2564_경비원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static pos[] s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());

		int len = (row + col) * 2; // 총 변의 길이
		int N = Integer.parseInt(br.readLine());
		s = new pos[N + 1]; // x, y 좌표 배열

		for (int i = 0; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int left = Integer.parseInt(st.nextToken());
			switch (dir) {
			case 1:
				s[i] = new pos(dir, 0, left);
				break;
			case 2:
				s[i] = new pos(dir, col, left);
				break;
			case 3:
				s[i] = new pos(dir, left, 0);
				break;
			case 4:
				s[i] = new pos(dir, left, row);
				break;
			}
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			int temp = 0;
			if (s[N].dir + s[i].dir == 3) {
				temp = s[N].y + s[i].y + col;
			} else if (s[N].dir + s[i].dir == 7) {
				temp = s[N].x + s[i].x + row;
			} else {
				temp = Math.abs(s[N].x - s[i].x) + Math.abs(s[N].y - s[i].y);
			}
			ans += Math.min(temp, len - temp);
		}
		System.out.println(ans);
		br.close();
	}

	public static class pos {
		int dir, x, y;

		public pos(int dir, int x, int y) {
			super();
			this.dir = dir;
			this.x = x;
			this.y = y;
		}
	}
}
