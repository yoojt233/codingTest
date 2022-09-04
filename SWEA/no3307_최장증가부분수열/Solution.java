package SWEA.no3307_최장증가부분수열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] number = new int[N];
			int[] dp = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				number[i] = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {
				dp[i] = 1;
				for (int j = 0; j < i; j++) {
					if (number[i] > number[j] && dp[j] + 1 > dp[i])
						dp[i] = dp[j] + 1;
				}
			}
			int max = Arrays.stream(dp).max().getAsInt();
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}

		System.out.print(sb.toString());
		br.close();
	}
}
