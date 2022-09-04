package BaekJoon.no10974_모든순열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N;
	static int[] result;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		result = new int[N];

		permutation(0, new boolean[N + 1]);
		System.out.print(sb.toString());

		br.close();
	}

	private static void permutation(int cnt, boolean[] isSelected) {
		if (cnt == N) {
			for (int i = 0; i < result.length; i++)
				sb.append(result[i]).append(" ");
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (isSelected[i])
				continue;
			isSelected[i] = true;
			result[cnt] = i;
			permutation(cnt + 1, isSelected);
			isSelected[i] = false;
		}
	}
}
