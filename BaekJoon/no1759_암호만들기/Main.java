package BaekJoon.no1759_암호만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static char[] alpha, sel;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		sel = new char[L]; // 내가 고른 알파벳
		alpha = new char[C]; // 주어진 알파벳

		String input[] = br.readLine().split(" ");
		for (int i = 0; i < C; i++)
			alpha[i] = input[i].charAt(0);

		// 알파벳 순서 asc
		Arrays.sort(alpha);
		combo(0, 0, 0, 0);

		System.out.print(sb.toString());
		br.close();
	}

	private static void combo(int cnt, int start, int cons, int vowel) {

		if (cnt == L) {
			if (cons >= 1 && vowel >= 2) {
				for (int i = 0; i < L; i++)
					sb.append(sel[i]);
				sb.append("\n");
			}
			return;
		}

		for (int i = start; i < C; i++) {
			sel[cnt] = alpha[i];
			if (alpha[i] == 'a' || alpha[i] == 'i' || alpha[i] == 'u' || alpha[i] == 'e' || alpha[i] == 'o')
				// 모음이면 cons 증가
				combo(cnt + 1, i + 1, cons + 1, vowel);
			else
				// 자음이면 vowel 증가
				combo(cnt + 1, i + 1, cons, vowel + 1);
		}
	}
}
