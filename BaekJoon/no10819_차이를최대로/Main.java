package BaekJoon.no10819_차이를최대로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] num, sel;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		num = new int[N];
		sel = new int[N];
		ans = Integer.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());

		int i = 0;
		while (st.hasMoreTokens())
			num[i++] = Integer.parseInt(st.nextToken());

		per(N, 0, new boolean[N]);
		System.out.print(ans);
		br.close();
	}

	private static void per(int N, int cnt, boolean[] checked) {
		if (cnt == N) {
			int sum = 0;
			for (int i = 0; i < N - 1; i++)
				sum += Math.abs(sel[i] - sel[i + 1]);
			ans = Math.max(ans, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (checked[i])
				continue;
			else {
				checked[i] = true;
				sel[cnt] = num[i];
				per(N, cnt + 1, checked);
				checked[i] = false;
			}
		}

	}
}
