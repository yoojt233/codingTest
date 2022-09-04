package BaekJoon.no1309_동물원;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N + 1];
		dp[0] = 1;
		dp[1] = 3;
		for (int i = 2; i <= N; i++)
			dp[i] = (2 * dp[i - 1] + dp[i - 2]) % 9901;

		System.out.print(dp[N]);
		br.close();
	}
}
