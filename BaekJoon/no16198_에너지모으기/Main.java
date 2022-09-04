package BaekJoon.no16198_에너지모으기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] energy;
	static int N, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		energy = new int[N];
		ans = Integer.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			energy[i] = Integer.parseInt(st.nextToken());

		permu(0, 0, new boolean[N]);

		System.out.print(ans);
		br.close();
	}

	private static void permu(int cnt, int sum, boolean[] check) {
		if (cnt == N - 2) {
			ans = Math.max(ans, sum);
			return;
		}

		for (int i = 1; i < N - 1; i++) {
			if (check[i])
				continue;
			check[i] = true;

			// 왼쪽 구슬의 에너지
			int l = 1;
			while (check[i - l])
				l++;
			int left = energy[i - l];

			// 오른쪽 구슬의 에너지
			int r = 1;
			while (check[i + r])
				r++;
			int right = energy[i + r];

			permu(cnt + 1, sum + left * right, check);
			check[i] = false;
		}
	}
}
