package SWEA.no5607_조합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static long P = 1234567891;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			sb.append("#" + t + " " + nCr(n, r, P) + "\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static long nCr(int n, int r, long p) {
		if (r == 0 || r == n)
			return 1;

		long[] fac = new long[n + 1];
		fac[0] = 1;

		for (int i = 1; i <= n; i++)
			fac[i] = fac[i - 1] * i % p;

		return (fac[n] * power(fac[r], p - 2, p) % p * power(fac[n - r], p - 2, p) % p) % p;
	}

	private static long power(long x, long y, long p) {
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
