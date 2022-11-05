package BaekJoon.no18221_교수님저는취업할래요;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		String[][] room = new String[N][N];
		pos[] position = new pos[2];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				room[i][j] = st.nextToken();
				if ("2".equals(room[i][j]))
					position[0] = new pos(i, j);
				else if ("5".equals(room[i][j]))
					position[1] = new pos(i, j);
			}
		}

		boolean flag = true;
		if (dis(position) < 5)
			flag = false;

		if (flag) {
			int sx = Math.min(position[0].r, position[1].r);
			int ex = Math.max(position[0].r, position[1].r);
			int sy = Math.min(position[0].c, position[1].c);
			int ey = Math.max(position[0].c, position[1].c);

			int cnt = 0;
			out: for (int i = sx; i <= ex; ++i) {
				for (int j = sy; j <= ey; ++j) {
					if (room[i][j].equals("1")) {
						++cnt;
						if (cnt == 3)
							break out;
					}
				}
			}
			if (cnt < 3)
				flag = false;
		}

		System.out.print(flag ? 1 : 0);
		br.close();
	}

	private static double dis(pos[] position) {
		int x = position[0].r - position[1].r;
		int y = position[0].c - position[1].c;
		return Math.sqrt(x * x + y * y);
	}
}

class pos {
	int r, c;

	public pos(int r, int c) {
		this.r = r;
		this.c = c;
	}
}