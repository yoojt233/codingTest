package BaekJoon.no9996_한국이그리울땐서버에접속하지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int star;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		char[] standard = br.readLine().toCharArray();

		// *의 위치
		star = 0;
		for (int i = 0, n = standard.length; i < n; i++) {
			if (standard[i] == '*') {
				star = i;
				break;
			}
		}

		for (int i = 0; i < N; i++) {
			char[] str = br.readLine().toCharArray();
			if (check(standard, str))
				sb.append("DA");
			else
				sb.append("NE");
			sb.append("\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static boolean check(char[] standard, char[] str) {
		int a = standard.length;
		int b = str.length;

		// str이 standard에서 *를 뺀 것보다 작으면 무조건 false
		if (b < a - 1)
			return false;

		// 앞에서부터 비교
		for (int i = 0; i < star; i++) {
			if (standard[i] != str[i])
				return false;
		}

		// 뒤에서부터 비교
		for (int i = 0; i < a - star - 1; i++) {
			if (standard[a - i - 1] != str[b - i - 1])
				return false;
		}
		
		// 모두 통과하면 true 반환
		return true;
	}
}
