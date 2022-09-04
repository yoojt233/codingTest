package BaekJoon.no6603_로또;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	static int[] Numbers;
	static StringTokenizer st;
	static int tc;
	static int[] click = new int[6];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		while (!st.equals("0")) {
			tc = Integer.parseInt(st.nextToken());
			Numbers = new int[tc];
			for (int i = 0; i < tc; i++) {
				Numbers[i] = Integer.parseInt(st.nextToken());
			}
			Combination(0, 0);
			System.out.println();
			st = new StringTokenizer(br.readLine());
		}
	}

	static void Combination(int cnt, int start) {
		if (cnt == 6) {
			for (int i = 0; i < 6; i++) {
				System.out.printf("%d ", click[i]);
			}
			System.out.println();
			return;
		}
		for (int i = start; i < tc; i++) {
			click[cnt] = Numbers[i];
			Combination(cnt + 1, i + 1);

		}
	}
}