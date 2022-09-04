package BaekJoon.no2596_비밀편지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] code = { { '0', '0', '0', '0', '0', '0' }, { '0', '0', '1', '1', '1', '1' },
			{ '0', '1', '0', '0', '1', '1' }, { '0', '1', '1', '1', '0', '0' }, { '1', '0', '0', '1', '1', '0' },
			{ '1', '0', '1', '0', '0', '1' }, { '1', '1', '0', '1', '0', '1' }, { '1', '1', '1', '0', '1', '0' } };
	static StringBuilder sb;
	static char[] output;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		output = new char[N];
		String str = br.readLine();

		for (int i = 0; i < N; i++) {
			String st = str.substring(i * 6, i * 6 + 6);
			char[] input = st.toCharArray();
			compare(input, i);
		}

		for (char c : output)
			System.out.printf("%c", c);

		br.close();
	}

	private static void compare(char[] input, int x) {
		int cnt = 0;
		for (int i = 0; i < 8; i++) { // 어떤 문자랑 비교?
			for (int j = 0; j < 6; j++) { // 비교 시작
				if (input[j] != code[i][j])
					cnt++;
			}

			if (cnt < 2) {
				switch (i) {
				case 0:
					output[x] = 'A';
					break;
				case 1:
					output[x] = 'B';
					break;
				case 2:
					output[x] = 'C';
					break;
				case 3:
					output[x] = 'D';
					break;
				case 4:
					output[x] = 'E';
					break;
				case 5:
					output[x] = 'F';
					break;
				case 6:
					output[x] = 'G';
					break;
				case 7:
					output[x] = 'H';
					break;
				}
				return;
			} else
				cnt = 0;
		}
		if (output[x] == '\0') {
			System.out.print(x + 1);
			System.exit(0);
		}
	}
}