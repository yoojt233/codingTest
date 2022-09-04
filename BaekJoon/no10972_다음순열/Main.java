package BaekJoon.no10972_다음순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] standard;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		String input[] = br.readLine().split(" ");
		standard = new int[N];

		for (int i = 0; i < N; i++)
			standard[i] = Integer.parseInt(input[i]);

		if (np(standard)) {
			for (int i : standard)
				sb.append(i).append(" ");
		} else {
			System.out.print(-1);
			System.exit(0);
		}

		sb.setLength(sb.length() - 1);
		System.out.print(sb.toString());
		br.close();
	}

	private static boolean np(int[] standard) {
		int i = N - 1;
		while (i > 0 && standard[i] <= standard[i - 1])
			i--;

		if (i == 0)
			return false;

		int j = N - 1;
		while (standard[j] <= standard[i - 1])
			j--;

		swap(standard, i - 1, j);

		int k = N - 1;
		while (i < k) {
			swap(standard, i++, k--);
		}
		return true;
	}

	private static void swap(int[] standard, int i, int j) {
		int temp = standard[i];
		standard[i] = standard[j];
		standard[j] = temp;
	}
}
