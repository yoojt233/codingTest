package SWEA.no5604_구간합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
	static HashMap<Long, Long> dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		dp = new HashMap<Long, Long>();

		long sum = 0;
		for (long i = 0; i <= 9; i++) {
			sum += i;
			dp.put(i, sum);
		}

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());

			long ans = F(B) - F(A - 1);

			sb.append("#" + t + " " + ans + "\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static Long F(long n) {
		if (n < 0)
			return (long) 0;

		if (dp.containsKey(n))
			return dp.get(n);

		long v = V(n);
		long f = F(n - 1 - n % v);
		long g = n / v * (n % v + 1) + F(n % v);
		long val = f + g;
		dp.put(n, val);

		return val;
	}

	private static long V(long n) {
		long x = 1;
		while (n >= 10) {
			x *= 10;
			n /= 10;
		}

		return x;
	}
}
