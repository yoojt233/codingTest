package SWEA.no1247_최적경로;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, MIN;
	static StringBuilder sb;
	static pos[] where, first;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/SWEA/swea_1247.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			MIN = Integer.MAX_VALUE;

			where = new pos[N + 2];
			StringTokenizer st = new StringTokenizer(br.readLine());

			int idx = 0;
			// 위치 입력
			while (st.hasMoreTokens())
				where[idx++] = new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			per(0, 0, 0);
			sb.append(MIN).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}

	private static void per(int pre, int dis, int visit) {
		if (visit == (1 << N + 2) - 4) {
			dis += calc(pre, where[1]);
			MIN = Math.min(MIN, dis);
			return;
		}

		if (MIN < dis)
			return;

		for (int i = 2; i < N + 2; i++) {
			if ((visit & (1 << i)) != 0)
				continue;
			per(i, dis + calc(pre, where[i]), (visit | (1 << i)));
		}
	}

	private static int calc(int pre, pos position) {
		return Math.abs(where[pre].x - position.x) + Math.abs(where[pre].y - position.y);
	}

	static class pos {
		int x, y;

		public pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
