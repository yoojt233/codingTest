package BaekJoon.no2138_전구와스위치;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static char[][] lights;
	static char[] target;
	static int[] cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		lights = new char[2][N];
		lights[0] = br.readLine().toCharArray();
		target = br.readLine().toCharArray();

		cnt = new int[2];
		init();
		for (int i = 1; i < N; ++i) {
			for (int j = 0; j < 2; ++j) {
				if (lights[j][i - 1] != target[i - 1]) {
					++cnt[j];
					turn(lights[j], i);
				}
			}
		}

		int ans = check();
		System.out.print(ans);
		br.close();
	}

	private static int check() {
		boolean[] flag = new boolean[2];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < 2; ++j) {
				if (flag[j])
					continue;

				if (lights[j][i] != target[i])
					flag[j] = true;
			}
		}

		if (!flag[0] && !flag[1])
			return Math.min(cnt[0], cnt[1]);
		else if (!flag[0])
			return cnt[0];
		else if (!flag[1])
			return cnt[1];
		return -1;
	}

	private static void init() {
		lights[1] = lights[0].clone();
		turn(lights[1], 0);
		cnt[1] = 1;
	}

	static int[] dx = { -1, 0, 1 };

	private static void turn(char[] arr, int x) {
		for (int d = 0; d < 3; ++d) {
			int cx = x + dx[d];

			if (cx < 0 || cx >= N)
				continue;
			arr[cx] = arr[cx] == '0' ? '1' : '0';
		}
	}
}
