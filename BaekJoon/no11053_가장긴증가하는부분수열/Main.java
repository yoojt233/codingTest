package BaekJoon.no11053_가장긴증가하는부분수열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		int[] arr = new int[N];
		for (int i = 0; i < N; ++i)
			arr[i] = Integer.parseInt(input[i]);

		int[] dp = new int[N];
		dp[0] = arr[0];
		int len = 0;
		for (int i = 1; i < N; ++i) {
			if (arr[i] > dp[len])
				dp[++len] = arr[i];
			else {
				int where = Arrays.binarySearch(dp, 0, len + 1, arr[i]);
				if (where < 0)
					dp[-where - 1] = arr[i];
			}
		}

		System.out.print(len);
		br.close();
	}
}
