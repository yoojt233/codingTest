package BaekJoon.no13398_연속합2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			num[i] = Integer.parseInt(st.nextToken());

		int ans = num[0];
		int[][] dp = new int[2][N];
		dp[0][0] = num[0];
		dp[1][0] = num[0];

		for (int i = 1; i < N; i++) {
			dp[0][i] = Math.max(dp[0][i - 1] + num[i], num[i]); // 이전까지의 합 + 현재값 vs 현재값
			dp[1][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + num[i]); // [i - 1]까지 제외없음 + 현재값 제외 vs [i - 1]까지 최대 + 현재값

			int temp = Math.max(dp[0][i], dp[1][i]);
			if (temp > ans)
				ans = temp;
		}

		System.out.print(ans);
		br.close();
	}
}
