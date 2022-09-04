package BaekJoon.no11051_이항계수2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int p = 10007;

		System.out.print(nCr(n, r, p));

		br.close();
	}

	private static long nCr(int n, int r, int p) {
		if (r == 0 || r == n)
			return 1;

		long[] dp = new long[n + 1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++)
			dp[i] = dp[i - 1] * i % p;

		return (dp[n] * power(dp[r], p - 2, p) % p * power(dp[n - r], p - 2, p) % p) % p;
	}

	private static long power(long x, int y, int p) {
		long res = 1;
		x %= p;

		while (y > 0) {
			if (y % 2 == 1)
				res = (res * x) % p;

			y /= 2;
			x = (x * x) % p;
		}

		return res;
	}
}
