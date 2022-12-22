package BaekJoon.no1978_소수찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; ++i)
			max = Math.max(max, Integer.parseInt(input[i]));

		boolean[] pn = new boolean[max + 1];
		isPn(pn);

		int ans = 0;
		for (int i = 0; i < N; ++i) {
			if (!pn[Integer.parseInt(input[i])])
				++ans;
		}

		System.out.print(ans);
		br.close();
	}

	private static void isPn(boolean[] pn) {
		pn[0] = true;
		pn[1] = true;

		for (int i = 2; i * i <= max; ++i) {
			if (pn[i])
				continue;

			int temp = 2;
			while (i * temp <= max)
				pn[i * temp++] = true;
		}
	}
}
