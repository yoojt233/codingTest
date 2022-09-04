package BaekJoon.no18429_근손실;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, minus, ans;
	static int[] kit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		minus = Integer.parseInt(st.nextToken());

		kit = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			kit[i] = Integer.parseInt(st.nextToken());

		ans = 0;
		permu(0, 500, new boolean[N]);

		System.out.print(ans);
		br.close();
	}

	private static void permu(int cnt, int ex, boolean[] used) {
		if (ex < 500)
			return;

		if (cnt == N) {
			++ans;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (used[i])
				continue;
			used[i] = true;
			permu(cnt + 1, ex - minus + kit[i], used);
			used[i] = false;
		}
	}
}
