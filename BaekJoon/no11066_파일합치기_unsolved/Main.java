package BaekJoon.no11066_파일합치기_unsolved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			int N = Integer.parseInt(br.readLine());
			long[] dp = new long[N];
			int[] chapter = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				chapter[i] = Integer.parseInt(st.nextToken());

			dp[0] = chapter[0];
			dp[1] = chapter[0] + chapter[1];
			for (int i = 2; i < N; i++)
				dp[i] = Math.min(dp[i - 1] * 2 + chapter[i], dp[i]);

			sb.append(dp[N - 1] + "\n");
		}

		System.out.print(sb.toString());
		br.close();
	}
}
