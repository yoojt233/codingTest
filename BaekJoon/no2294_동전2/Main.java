package BaekJoon.no2294_동전2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] value, dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 동전 가치 수
		int target = Integer.parseInt(st.nextToken()); // 목표 금액

		value = new int[n];
		dp = new int[target + 1];

		// 금액 입력받기
		for (int i = 0; i < n; i++)
			value[i] = Integer.parseInt(br.readLine().trim());

		int min;
		for (int i = 1; i <= target; i++) {
			min = 9999999;
			for (int j = 0; j < n; j++) {
				if (i >= value[j] && dp[i - value[j]] + 1 < min)
					min = dp[i - value[j]] + 1;
			}
			dp[i] = min;
		}

		int ans = dp[target] < 9999999 ? dp[target] : -1;
		System.out.print(ans);
		br.close();
	}
}
