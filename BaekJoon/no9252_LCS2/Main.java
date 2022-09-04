package BaekJoon.no9252_LCS2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String first = br.readLine(); // 첫번째 줄
		String second = br.readLine(); // 두번째 줄
		int flen = first.length(); // 첫번째 줄 길이
		int slen = second.length(); // 두번째 줄 길이

		int[][] dp = new int[flen + 1][slen + 1]; // lcs 길이를 저장할 배열

		for (int i = 1; i <= flen; i++) {
			for (int j = 1; j <= slen; j++) {

				// 두 문자가 같다면 대각선 위 + 1
				if (first.charAt(i - 1) == second.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else // 위와 왼쪽 중 큰 값
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
			}
		}

		int lcs = dp[flen][slen];	
		System.out.println(lcs);

		Stack<Character> s = new Stack<Character>();

		// 맨 밑, 우측에서부터 탐색 시작
		while (s.size() < lcs) {

			// 위로 한 칸
			if (dp[flen][slen] == dp[flen - 1][slen])
				flen -= 1;

			// 좌로 한 칸
			else if (dp[flen][slen] == dp[flen][slen - 1])
				slen -= 1;

			// 대각선으로 한 칸
			else {
				if (dp[flen][slen] != dp[flen - 1][slen - 1])
					s.add(first.charAt(flen - 1));
				slen -= 1;
				flen -= 1;
			}
		}

		while (!s.isEmpty())
			sb.append(s.pop());

		System.out.print(sb.toString());
		br.close();
	}
}
