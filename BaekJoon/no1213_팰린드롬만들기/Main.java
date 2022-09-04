package BaekJoon.no1213_팰린드롬만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] origin = br.readLine().toCharArray();
		int max = origin.length;

		// 알파벳이 몇 번 나오는지 저장
		int[] alpha = new int[26];
		for (char c : origin)
			alpha[c - 'A']++;

		int odd = 0; // 홀수 알파벳 개수
		boolean flag = true; // 팰린드롬 가능 여부

		for (int i : alpha) {

			// 홀수 확인
			if (i % 2 == 1) {

				// 홀수인 알파벳이 존재하려면 문장의 길이도 홀수여야 한다.
				if (max % 2 == 0) {
					flag = false;
					break;
				}
				++odd;
			}

			// 홀수인 알파벳이 2개 이상이면 팰린드롬 불가능
			if (odd > 1) {
				flag = false;
				break;
			}
		}

		if (!flag)
			sb.append("I'm Sorry Hansoo");
		else {
			char[] palin = new char[max];
			int idx = 0;

			// A부터 탐색 시작
			for (int i = 0; i < 26; i++) {
				if (alpha[i] == 0)
					continue;

				// 홀수인 알파벳은 가운데 필수
				if (alpha[i] % 2 == 1)
					palin[max / 2] = (char) (i + 'A');

				// 앞뒤
				while (alpha[i] > 1) {
					palin[idx] = palin[max - idx - 1] = (char) (i + 'A');
					++idx;
					alpha[i] -= 2;
				}
			}

			for (char c : palin)
				sb.append(c);
		}

		System.out.println(sb.toString());
		br.close();
	}
}
