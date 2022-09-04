package BaekJoon.no12015_가장긴증가하는부분수열2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int[] dp = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			num[i] = Integer.parseInt(st.nextToken());

		dp[0] = num[0];
		int len = 0;
		for (int i = 1; i < N; i++) {
			if (num[i] > dp[len])
				dp[++len] = num[i];
			else {
				int where = Arrays.binarySearch(dp, 0, len + 1, num[i]);
				if (where < 0)
					dp[-where - 1] = num[i];
			}
		}

		System.out.println(len + 1);
		br.close();
	}
}