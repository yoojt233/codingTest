package BaekJoon.no5582_공통부분문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String first = br.readLine();
		String second = br.readLine();
		int[][] table = new int[first.length() + 1][second.length() + 1];

		int ans = 0;
		for (int i = 1; i <= first.length(); i++) {
			for (int j = 1; j <= second.length(); j++) {
				if (first.charAt(i - 1) == second.charAt(j - 1)) {
					table[i][j] = table[i - 1][j - 1] + 1;
					if (table[i][j] > ans)
						ans = table[i][j];
				}
			}
		}

		System.out.print(ans);
		br.close();
	}
}
