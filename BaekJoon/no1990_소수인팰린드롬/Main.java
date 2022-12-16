package BaekJoon.no1990_소수인팰린드롬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int op, ed;
	static boolean[] numbers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		op = Integer.parseInt(st.nextToken());
		ed = Integer.parseInt(st.nextToken());

		if (op % 2 == 0)
			++op;

		numbers = new boolean[ed + 1];
		init();

		StringBuilder sb = new StringBuilder();
		for (int i = op; i <= ed; i += 2) {
			if (!numbers[i] && palin(i))
				sb.append(i + "\n");
		}
		sb.append(-1);

		System.out.print(sb.toString());
		br.close();
	}

	private static void init() {
		for (int i = 3; i * i <= ed; i += 2) {
			if (!numbers[i]) {
				int idx = 2;
				while (i * idx <= ed)
					numbers[i * idx++] = true;
			}
		}
	}

	private static boolean palin(int op) {
		String s = Integer.toString(op);
		int size = s.length();

		for (int i = 0; i < size / 2; ++i) {
			if (s.charAt(i) != s.charAt(size - i - 1))
				return false;
		}
		return true;
	}
}
