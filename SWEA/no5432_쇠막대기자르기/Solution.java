package SWEA.no5432_쇠막대기자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine()); // 테스트 케이스
		for (int t = 0; t < tc; t++) {
			sb.append("#").append(t).append(" ");

			String str = br.readLine();
			char[] arr = new char[str.length()];
			for (int i = 0; i < str.length(); i++) {
				arr[i] = str.charAt(i);
			}

			// 현재 쌓여 있는 쇠막대기 개수
			int cnt = 0;

			// 잘린 쇠막대기 개수
			int ans = 0;

			for (int i = 0; i < arr.length; i++) {

				// 쇠막대기 올리기
				if (arr[i] == '(' && i + 1 < arr.length && arr[i + 1] != ')')
					cnt++;

				// 다 잘린 쇠막대기
				if (arr[i] == ')' && arr[i - 1] != '(') {
					cnt--;
					ans++;
				}

				// 레이저이면
				if (arr[i] == ')' && arr[i - 1] == '(')
					ans += cnt;
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}
}
