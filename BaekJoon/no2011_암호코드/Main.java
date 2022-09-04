package BaekJoon.no2011_암호코드;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;

		String str = br.readLine();
		int N = str.length();
		int[] pwd = new int[N + 1];
		for (int i = 1; i <= N; i++)
			pwd[i] = str.charAt(i - 1) - '0';

		int[] dp = new int[N + 1];

		dp[0] = 1;

		// 첫 단어가 0이라면 이미 해석 불가
		if (pwd[1] != 0) {
			dp[1] = 1;

			for (int i = 2; i <= N; i++) {
				int join = pwd[i - 1] * 10 + pwd[i];

				// pwd[i]가 0 이면서, 합쳐 읽을 수 없다면 해석 불가
				if (pwd[i] == 0 && join != 10 && join != 20)
					break;

				// 하나로 합쳐 읽을 수 있는 경우
				if (9 < join && join <= 26) {

					// 10일 때와 20일 때
					if (pwd[i] == 0)
						dp[i] = dp[i - 2];
					else
						dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
				} else // 합칠 수 없다면 따로 읽어야한다
					dp[i] = dp[i - 1];
			}

			ans = dp[N];
		}

		System.out.print(ans);
		br.close();
	}
}
