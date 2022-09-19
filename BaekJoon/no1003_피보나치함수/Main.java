package BaekJoon.no1003_피보나치함수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; ++i) {
			num[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, num[i]);
		}

		int[][] dp = new int[max + 1][2];
		dp[0][0] = 1;
		dp[0][1] = 0;

		if (max > 0) {
			dp[1][0] = 0;
			dp[1][1] = 1;

			for (int i = 2; i <= max; ++i) {
				dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
				dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
			}
		}

		for (int i : num)
			sb.append(dp[i][0] + " " + dp[i][1] + "\n");

		System.out.print(sb.toString());
		br.close();
	}
}
