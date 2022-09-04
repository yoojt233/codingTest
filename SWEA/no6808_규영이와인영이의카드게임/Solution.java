package SWEA.no6808_규영이와인영이의카드게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static StringBuilder sb;
	static int[] a, b;
	static boolean[] deck = new boolean[19];
	static int victory, defeat;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		a = new int[9];
		b = new int[9];
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Arrays.fill(deck, false);

			// 규영이의 카드 입력 및 deck에서 규영이의 카드 체크
			for (int i = 0; i < 9; i++) {
				int temp = Integer.parseInt(st.nextToken());
				a[i] = temp;
				deck[temp] = true;
			}

			// 인영이의 카드 입력
			int idx = 0;
			for (int i = 1; i < deck.length; i++) {
				if (deck[i] == false)
					b[idx++] = i;
			}

			victory = 0;
			defeat = 0;
			permutation(0, 0, 0, new boolean[9]);
			sb.append("#").append(t + 1).append(" ").append(victory).append(" ").append(defeat).append("\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static void permutation(int cnt, int sumA, int sumB, boolean[] isSelected) {
		if (cnt == 9) {
			if (sumA > sumB)
				victory++;
			else
				defeat++;
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (isSelected[i] == true)
				continue;

			isSelected[i] = true;
			if (a[cnt] > b[i])
				permutation(cnt + 1, sumA + a[cnt] + b[i], sumB, isSelected);
			else
				permutation(cnt + 1, sumA, sumB + a[cnt] + b[i], isSelected);
			isSelected[i] = false;
		}
	}
}
