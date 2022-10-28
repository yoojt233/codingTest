package BaekJoon.no10844_쉬운계단수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		final int mod = 1000000000;

		long[][] dp = new long[N + 1][10];
		for (int i = 1; i < 10; ++i)
			dp[1][i] = 1;

		for (int i = 2; i < N + 1; ++i) {
			for (int j = 0; j < 10; ++j) {
				if (j == 0)
					dp[i][j] = dp[i - 1][1] % mod;
				else if (j == 9)
					dp[i][j] = dp[i - 1][8] % mod;
				else
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
			}
		}

		long ans = 0;
		for (long l : dp[N])
			ans = (ans + l) % mod;

		System.out.print(ans);
		br.close();
	}
}
