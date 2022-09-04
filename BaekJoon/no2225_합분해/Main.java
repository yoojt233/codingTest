package BaekJoon.no2225_합분해;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int mod = 1000000000;

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N + 1][K];

		// 1개로 만드는 방법은 1개 밖에 없다.
		if (K == 1)
			System.out.print(1);
		else {
			init(dp);

			// 현재 위치의 값 = 왼쪽 값 + 윗쪽 값
			for (int i = 1; i < N + 1; i++) {
				for (int k = 1; k < K; k++)
					dp[i][k] = (dp[i - 1][k] + dp[i][k - 1]) % mod;
			}
			System.out.print(dp[N][K - 1]);
		}

		br.close();
	}

	// 배열 값들을 1로 초기화
	private static void init(int[][] dp) {
		for (int i = 0; i < dp.length; i++) {
			for (int k = 0; k < dp[i].length; k++)
				dp[i][k] = 1;
		}
	}
}
