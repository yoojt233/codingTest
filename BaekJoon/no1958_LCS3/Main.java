package BaekJoon.no1958_LCS3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// LCS 3차원 버전
public class Main {
	static String[] line;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		line = new String[3];
		int[] len = new int[3];
		for (int i = 0; i < 3; i++) {
			line[i] = br.readLine();
			len[i] = line[i].length();
		}

		int[][][] dp = new int[len[0] + 1][len[1] + 1][len[2] + 1];
		for (int i = 1; i <= len[0]; i++) {
			for (int j = 1; j <= len[1]; j++) {
				for (int k = 1; k <= len[2]; k++) {
					if (compare(i, j, k))
						dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
					else
						dp[i][j][k] = max(dp[i - 1][j][k], dp[i][j - 1][k], dp[i][j][k - 1]);
				}
			}
		}

		System.out.print(dp[len[0]][len[1]][len[2]]);
		br.close();
	}

	private static boolean compare(int i, int j, int k) {

		// 하나라도 다르면 false
		if (line[0].charAt(i - 1) != line[1].charAt(j - 1) || line[1].charAt(j - 1) != line[2].charAt(k - 1))
			return false;

		return true;
	}

	private static int max(int a, int b, int c) {
		return Math.max(a, Math.max(b, c));
	}
}