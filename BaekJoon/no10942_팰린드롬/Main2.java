package BaekJoon.no10942_팰린드롬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	static int N;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		int[][] dp = new int[N][N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		// 길이 1
		for (int i = 0; i < N; i++)
			dp[i][i] = 1;

		// 길이 2
		for (int i = 1; i < N; i++) {
			if (arr[i - 1] == arr[i])
				dp[i - 1][i] = 1;
		}

		// 길이 3 이상
		for (int i = 2; i < N; i++) {
			for (int j = 0; j < N - i; j++) {
				if (arr[j] == arr[i + j] && dp[j + 1][i + j - 1] == 1)
					dp[j][i + j] = 1;
			}
		}

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			sb.append(dp[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] + "\n");
		}

		System.out.print(sb.toString());
		br.close();
	}
}
