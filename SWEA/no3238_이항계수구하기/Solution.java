package SWEA.no3238_이항계수구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine()); // 테케
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			long n = Long.parseLong(st.nextToken());
			long r = Long.parseLong(st.nextToken());
			int p = Integer.parseInt(st.nextToken());

			long ans = 1;

			// 팩토리얼 dp
			long[] fac = new long[p + 1];
			fac[0] = 1;
			for (int i = 1; i <= p; i++)
				fac[i] = (fac[i - 1] * i) % p;

			while (n != 0 || r != 0) {
				int np = (int) (n % p);
				int rp = (int) (r % p);
				if (np < rp) {
					ans = 0;
					break;
				}

				ans = (((ans * fac[np]) % p) * (power((fac[rp] * fac[np - rp]) % p, p - 2, p) % p)) % p;
				n /= p;
				r /= p;
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static long power(long x, int y, int p) {
		if (y == 0)
			return 1;
		else if (y == 1)
			return x;

		if (y % 2 == 0) {
			long temp = power(x, y / 2, p);
			return (temp * temp) % p;
		} else {
			long temp = power(x, y - 1, p) % p;
			return (temp * x) % p;
		}
	}
}
