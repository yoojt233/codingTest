package BaekJoon.no1463_1로만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {
	static int[] f;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		f = new int[N + 1];
		for (int i = 2; i <= N; i++) {
			f[i] = f[i - 1] + 1;
			if (i % 2 == 0)
				f[i] = Math.min(f[i / 2] + 1, f[i]);
			if (i % 3 == 0)
				f[i] = Math.min(f[i / 3] + 1, f[i]);
		}
		System.out.print(f[N]);
		br.close();
	}
}
