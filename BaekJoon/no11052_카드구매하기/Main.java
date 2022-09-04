package BaekJoon.no11052_카드구매하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int card[], dp[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		card = new int[N + 1];
		dp = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			card[i] = Integer.parseInt(st.nextToken());

		dp[1] = card[1];
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= i; j++)
				dp[i] = Math.max(dp[i], dp[i - j] + card[j]);
		}

		System.out.print(dp[N]);
		br.close();
	}
}
