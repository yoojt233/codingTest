package BaekJoon.no2448_별찍기11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static char[][] star;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		br.close();

		star = new char[N][N * 2 - 1];
		for (char[] s : star)
			Arrays.fill(s, ' ');

		divide(0, N - 1, N);

		for (char[] s : star) {
			for (char c : s)
				sb.append(c);
			sb.append("\n");
		}

		System.out.print(sb.toString());
	}

	private static void divide(int x, int y, int height) {
		if (height == 3) {
			star[x][y] = '*';
			star[x + 1][y - 1] = star[x + 1][y + 1] = '*';
			for (int i = 0; i < 5; i++)
				star[x + 2][y + i - 2] = '*';
		} else {
			int half = height / 2;
			divide(x, y, half);
			divide(x + half, y - half, half);
			divide(x + half, y + half, half);
		}
	}
}
